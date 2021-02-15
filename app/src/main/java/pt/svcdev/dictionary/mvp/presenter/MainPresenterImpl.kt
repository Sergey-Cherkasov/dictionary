package pt.svcdev.dictionary.mvp.presenter

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import pt.svcdev.dictionary.mvp.model.data.AppState
import pt.svcdev.dictionary.mvp.model.datasource.DataSourceLocal
import pt.svcdev.dictionary.mvp.model.datasource.DataSourceRemote
import pt.svcdev.dictionary.mvp.model.repository.RepositoryImpl
import pt.svcdev.dictionary.mvp.view.base.View
import pt.svcdev.dictionary.mvp.interactor.MainInteractor
import pt.svcdev.dictionary.rx.SchedulerProvider

class MainPresenterImpl<T : AppState, V : View>(
        private val interactor: MainInteractor = MainInteractor(
        RepositoryImpl(DataSourceRemote()),
        RepositoryImpl(DataSourceLocal())
    ),
        protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
        protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : Presenter<T, V> {

    private var currentView: V? = null

    override fun attachView(view: V) {
        if (view != currentView) {
            currentView = view
        }
    }

    override fun detachView(view: V) {
        compositeDisposable.clear()
        if (view == currentView) {
            currentView = null
        }
    }

    override fun getData(word: String, isOnline: Boolean) {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe { currentView?.renderData(AppState.Loading(null)) }
                .subscribeWith(getObserver())
        )
    }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {

            override fun onNext(appState: AppState) {
                currentView?.renderData(appState)
            }

            override fun onError(e: Throwable) {
                currentView?.renderData(AppState.Error(e))
            }

            override fun onComplete() {
            }
        }
    }
}
