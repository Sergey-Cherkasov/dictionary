package pt.svcdev.dictionary.mvvm.model.datasource

import io.reactivex.Observable
import pt.svcdev.dictionary.mvvm.model.data.DataModel

class DataSourceRemote(private val remoteProvider: RetrofitImpl = RetrofitImpl()) :
    DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> = remoteProvider.getData(word)
}
