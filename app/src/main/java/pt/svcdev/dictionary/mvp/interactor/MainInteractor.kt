package pt.svcdev.dictionary.mvp.interactor

import io.reactivex.Observable
import pt.svcdev.dictionary.mvp.model.data.AppState
import pt.svcdev.dictionary.mvp.model.data.DataModel
import pt.svcdev.dictionary.mvp.model.repository.Repository
import pt.svcdev.dictionary.mvp.interactor.Interactor

class MainInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}
