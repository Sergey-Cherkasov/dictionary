package pt.svcdev.dictionary.mvp.model.repository

import io.reactivex.Observable
import pt.svcdev.dictionary.mvp.model.data.DataModel
import pt.svcdev.dictionary.mvp.model.datasource.DataSource

class RepositoryImpl(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}
