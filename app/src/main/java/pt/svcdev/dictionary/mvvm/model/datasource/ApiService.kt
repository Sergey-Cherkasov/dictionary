package pt.svcdev.dictionary.mvvm.model.datasource

import io.reactivex.Observable
import pt.svcdev.dictionary.mvvm.model.data.DataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("words/search")
    fun search(@Query("search") wordToSearch: String): Observable<List<DataModel>>
}