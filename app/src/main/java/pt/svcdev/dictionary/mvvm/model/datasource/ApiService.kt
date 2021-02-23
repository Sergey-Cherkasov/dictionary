package pt.svcdev.dictionary.mvvm.model.datasource

import kotlinx.coroutines.Deferred
import pt.svcdev.dictionary.mvvm.model.data.DataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("words/search")
    fun searchAsync(@Query("search") wordToSearch: String): Deferred<List<DataModel>>
}