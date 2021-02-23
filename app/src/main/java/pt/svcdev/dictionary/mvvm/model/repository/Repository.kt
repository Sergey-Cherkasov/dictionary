package pt.svcdev.dictionary.mvvm.model.repository

interface Repository<T> {
    suspend fun getData(word: String): T
}
