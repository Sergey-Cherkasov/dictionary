package pt.svcdev.dictionary.mvvm.view.base

import pt.svcdev.dictionary.mvvm.model.data.AppState

interface View {
    fun renderData(appState: AppState)
}