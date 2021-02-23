package pt.svcdev.dictionary.mvvm.model.datasource

import pt.svcdev.dictionary.mvvm.model.data.DataModel

class DataSourceRemote(private val remoteProvider: RetrofitImpl = RetrofitImpl()) :
    DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> = remoteProvider.getData(word)
}
