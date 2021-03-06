package pt.svcdev.historyscreen

import pt.svcdev.model.DataModel
import pt.svcdev.repository.LocalRepository
import pt.svcdev.repository.Repository

class HistoryInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: LocalRepository<List<DataModel>>
) : pt.svcdev.core.viewmodel.Interactor<pt.svcdev.model.AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): pt.svcdev.model.AppState =
        pt.svcdev.model.AppState.Success(
            if (fromRemoteSource) {
                remoteRepository
            } else {
                localRepository
            }.getData(word)
        )

}