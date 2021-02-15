package pt.svcdev.dictionary.mvp.model.datasource

import io.reactivex.Observable
import pt.svcdev.dictionary.mvp.model.data.DataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("words/search")
    fun search(@Query("search") wordToSearch: String): Observable<List<DataModel>>
}