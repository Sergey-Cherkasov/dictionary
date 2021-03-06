package pt.svcdev.repository.datasource

interface LocalDataSource<T> : DataSource<T> {

    suspend fun saveToDB(appState: pt.svcdev.model.AppState)
}
