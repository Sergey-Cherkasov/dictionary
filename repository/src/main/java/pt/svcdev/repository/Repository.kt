package pt.svcdev.repository

interface Repository<T> {
    suspend fun getData(word: String): T
}
