package pt.svcdev.repository.datasource

import pt.svcdev.model.room.HistoryDao
import pt.svcdev.utils.convertDataModelSuccessToEntity
import pt.svcdev.utils.mapHistoryEntityToSearchResult

class RoomDatabaseImpl(private val historyDao: HistoryDao) : LocalDataSource<List<pt.svcdev.model.DataModel>> {

    override suspend fun getData(word: String): List<pt.svcdev.model.DataModel> =
        mapHistoryEntityToSearchResult(historyDao.all())

    override suspend fun saveToDB(appState: pt.svcdev.model.AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}