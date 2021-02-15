package pt.svcdev.dictionary.mvp.model.datasource

import io.reactivex.Observable
import pt.svcdev.dictionary.mvp.model.data.DataModel

class DataSourceLocal(private val remoteProvider: RoomDatabaseImpl = RoomDatabaseImpl()) :
    DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> = remoteProvider.getData(word)
}
