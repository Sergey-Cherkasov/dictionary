package pt.svcdev.dictionary.mvvm.model.datasource

import pt.svcdev.dictionary.mvvm.model.data.DataModel

class RoomDatabaseImpl : DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}