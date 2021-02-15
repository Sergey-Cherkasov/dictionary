package pt.svcdev.dictionary.mvp.view.base

import pt.svcdev.dictionary.mvp.model.data.AppState

interface View {
    fun renderData(appState: AppState)
}