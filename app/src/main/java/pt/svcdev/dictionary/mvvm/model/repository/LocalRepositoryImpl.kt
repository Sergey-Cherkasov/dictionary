package pt.svcdev.dictionary.mvvm.model.repository

import pt.svcdev.dictionary.mvvm.model.data.AppState
import pt.svcdev.dictionary.mvvm.model.data.DataModel
import pt.svcdev.dictionary.mvvm.model.datasource.LocalDataSource

class LocalRepositoryImpl(private val dataSource: LocalDataSource<List<DataModel>>) :
    LocalRepository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> = dataSource.getData(word)

    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}