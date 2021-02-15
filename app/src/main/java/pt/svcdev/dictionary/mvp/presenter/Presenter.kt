package pt.svcdev.dictionary.mvp.presenter

import pt.svcdev.dictionary.mvp.model.data.AppState
import pt.svcdev.dictionary.mvp.view.base.View

interface Presenter<T: AppState, V: View> {
    fun attachView(view: V)
    fun detachView(view: V)
    fun getData(word: String, isOnline: Boolean)
}