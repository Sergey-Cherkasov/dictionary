package pt.svcdev.model.api

import kotlinx.coroutines.Deferred
import pt.svcdev.model.DataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("words/search")
    fun searchAsync(@Query("search") wordToSearch: String): Deferred<List<DataModel>>
}