package pt.svcdev.mainscreen

import pt.svcdev.core.viewmodel.Interactor
import pt.svcdev.model.AppState
import pt.svcdev.model.DataModel
import pt.svcdev.repository.LocalRepository
import pt.svcdev.repository.Repository

class MainInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: LocalRepository<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(
        word: String,
        fromRemoteSource: Boolean
    ): AppState {

        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(remoteRepository.getData(word))
            localRepository.saveToDB(appState)
        } else {
            appState = AppState.Success(localRepository.getData(word))
        }

        return appState
    }
}
