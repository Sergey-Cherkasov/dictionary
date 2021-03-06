package pt.svcdev.repository

import pt.svcdev.model.DataModel
import pt.svcdev.repository.datasource.DataSource


class RepositoryImpl(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}
