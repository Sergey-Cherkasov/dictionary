package pt.svcdev.dictionary.mvp.model.datasource

import io.reactivex.Observable
import pt.svcdev.dictionary.mvp.model.data.DataModel

class RoomDatabaseImpl : DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}