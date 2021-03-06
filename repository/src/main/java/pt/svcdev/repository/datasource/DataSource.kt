package pt.svcdev.repository.datasource

interface DataSource<T> {

    suspend fun getData(word: String): T
}
