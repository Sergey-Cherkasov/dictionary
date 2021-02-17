package pt.svcdev.dictionary.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import pt.svcdev.dictionary.mvvm.model.data.AppState
import pt.svcdev.dictionary.rx.SchedulerProvider

abstract class BaseViewModel<T : AppState>(
    protected val liveDataForViewToObserve: MutableLiveData<T> = MutableLiveData(),
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : ViewModel() {
    /**
     * Метод позволяет Activity подписывается на изменение данных
     * @return liveData LiveData, через которую передаются данные
     */
    abstract fun getData(word: String, isOnline: Boolean)

    /**
     * Метод вызывается перед уничтожением Activity
     */
    override fun onCleared() {
        compositeDisposable.clear()
    }
}