package uz.mahmudxon.fairy.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject
import uz.mahmudxon.fairy.model.Fairytale
import uz.mahmudxon.fairy.repository.FairytaleResponse
import uz.mahmudxon.fairy.repository.search.ISearchRepository

class SearchViewModel : ViewModel(), KoinComponent {
    private val repo: ISearchRepository by inject()
    private val stories: MutableLiveData<List<Fairytale>> = MutableLiveData()
    fun getStories(): LiveData<List<Fairytale>> = stories
    fun getStories(search: String) {
        viewModelScope.launch {
            Log.d("TTT", "getStories: $search")
            val result = repo.getStory(search)
            if (result is FairytaleResponse.Success)
                stories.value = result.data
        }
    }
}