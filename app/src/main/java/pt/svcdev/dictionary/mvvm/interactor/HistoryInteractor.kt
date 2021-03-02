package pt.svcdev.dictionary.mvvm.interactor

import pt.svcdev.dictionary.mvvm.model.data.AppState
import pt.svcdev.dictionary.mvvm.model.data.DataModel
import pt.svcdev.dictionary.mvvm.model.repository.LocalRepository
import pt.svcdev.dictionary.mvvm.model.repository.Repository

class HistoryInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: LocalRepository<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState =
        AppState.Success(
            if (fromRemoteSource) {
                remoteRepository
            } else {
                localRepository
            }.getData(word)
        )

}