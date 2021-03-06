package pt.svcdev.repository

import pt.svcdev.model.AppState
import pt.svcdev.model.DataModel
import pt.svcdev.repository.datasource.LocalDataSource

class LocalRepositoryImpl(private val dataSource: LocalDataSource<List<DataModel>>) :
    LocalRepository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> =
        dataSource.getData(word)

    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}