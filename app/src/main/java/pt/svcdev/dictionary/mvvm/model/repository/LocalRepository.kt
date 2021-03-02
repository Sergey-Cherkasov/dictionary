package pt.svcdev.dictionary.mvvm.model.repository

import pt.svcdev.dictionary.mvvm.model.data.AppState

interface LocalRepository<T> : Repository<T> {
    suspend fun saveToDB(appState: AppState)
}