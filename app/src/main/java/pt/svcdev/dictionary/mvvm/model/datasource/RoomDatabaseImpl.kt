package pt.svcdev.dictionary.mvvm.model.datasource

import pt.svcdev.dictionary.mvvm.model.data.AppState
import pt.svcdev.dictionary.mvvm.model.data.DataModel
import pt.svcdev.dictionary.room.HistoryDao
import pt.svcdev.dictionary.utils.convertDataModelSuccessToEntity
import pt.svcdev.dictionary.utils.mapHistoryEntityToSearchResult

class RoomDatabaseImpl(private val historyDao: HistoryDao) : LocalDataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> =
        mapHistoryEntityToSearchResult(historyDao.all())

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}