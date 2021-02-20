package pt.svcdev.dictionary.mvvm.viewmodel

import androidx.lifecycle.LiveData
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import pt.svcdev.dictionary.mvvm.interactor.MainInteractor
import pt.svcdev.dictionary.mvvm.model.data.AppState
import pt.svcdev.dictionary.mvvm.model.datasource.DataSourceLocal
import pt.svcdev.dictionary.mvvm.model.datasource.DataSourceRemote
import pt.svcdev.dictionary.mvvm.model.repository.RepositoryImpl
import javax.inject.Inject

class MainViewModel @Inject constructor(private val interactor: MainInteractor) :
    BaseViewModel<AppState>() {

    // В переменной хранится последнее состояние Activity
    private var appState: AppState? = null

    fun subscribe(): LiveData<AppState> = liveDataForViewToObserve

    override fun getData(word: String, isOnline: Boolean) {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                    .subscribeOn(schedulerProvider.io())
                    .observeOn(schedulerProvider.ui())
                    .doOnSubscribe(doOnSubscribe())
                    .subscribeWith(getObserver())
        )
    }

    private fun getObserver() : DisposableObserver<AppState> =
            object: DisposableObserver<AppState>() {
                override fun onNext(t: AppState) {
                    appState = t
                    liveDataForViewToObserve.value = t
                }

                override fun onError(e: Throwable) {
                    liveDataForViewToObserve.value = AppState.Error(e)
                }

                override fun onComplete() {}
            }

    private fun doOnSubscribe(): (Disposable) -> Unit = {
        liveDataForViewToObserve.value = AppState.Loading(null)
    }

}