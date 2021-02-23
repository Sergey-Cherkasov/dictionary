package pt.svcdev.dictionary.mvvm.model.datasource

interface DataSource<T> {

    suspend fun getData(word: String): T
}
