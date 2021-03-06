package pt.svcdev.repository

import pt.svcdev.model.AppState

interface LocalRepository<T> : Repository<T> {
    suspend fun saveToDB(appState: AppState)
}