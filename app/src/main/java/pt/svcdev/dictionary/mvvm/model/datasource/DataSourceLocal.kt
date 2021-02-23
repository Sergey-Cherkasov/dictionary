package pt.svcdev.dictionary.mvvm.model.datasource

import pt.svcdev.dictionary.mvvm.model.data.DataModel

class DataSourceLocal(private val remoteProvider: RoomDatabaseImpl = RoomDatabaseImpl()) :
    DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> = remoteProvider.getData(word)
}
