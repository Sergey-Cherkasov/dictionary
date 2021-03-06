package pt.svcdev.core

import pt.svcdev.model.AppState

interface View {
    fun renderData(appState: AppState)
}