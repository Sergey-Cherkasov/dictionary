package pt.svcdev.dictionary.utils

import pt.svcdev.dictionary.mvvm.model.data.AppState
import pt.svcdev.dictionary.mvvm.model.data.DataModel
import pt.svcdev.dictionary.mvvm.model.data.Meanings

fun parseSearchResults(data: AppState): AppState {
    val newSearchResults = mutableListOf<DataModel>()
    when (data) {
        is AppState.Success -> {
            val searchResults = data.data
            if (!searchResults.isNullOrEmpty()) {
                searchResults.forEach { searchResult ->
                    parseResult(searchResult, newSearchResults) }
            }
        }
    }
    return AppState.Success(newSearchResults)
}

private fun parseResult(dataModel: DataModel, newDataModels: MutableList<DataModel>) {
    if (!dataModel.text.isNullOrBlank() && !dataModel.meanings.isNullOrEmpty()) {
        val newMeanings = mutableListOf<Meanings>()
        dataModel.meanings.forEach { meaning ->
            if (meaning.translation != null && !meaning.translation.translation.isNullOrBlank()) {
                newMeanings.add(Meanings(meaning.translation, meaning.imageUrl))
            }
        }

        if (newMeanings.isNotEmpty()) { newDataModels.add(DataModel(dataModel.text, newMeanings)) }
    }
}