package pt.svcdev.dictionary.mvvm.model.datasource

import pt.svcdev.dictionary.mvvm.model.data.AppState

interface LocalDataSource<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}
