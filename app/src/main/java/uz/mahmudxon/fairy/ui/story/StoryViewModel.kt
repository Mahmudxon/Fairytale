package uz.mahmudxon.fairy.ui.story

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject
import uz.mahmudxon.fairy.model.Fairytale
import uz.mahmudxon.fairy.repository.FairytaleResponse
import uz.mahmudxon.fairy.repository.story.IStoryRepository

class StoryViewModel : ViewModel(), KoinComponent {
    private val repo : IStoryRepository by inject()
    private val stories : MutableLiveData<List<Fairytale>> = MutableLiveData()
    fun getStories() : LiveData<List<Fairytale>> = stories
    fun getStories(id : Int) {
        viewModelScope.launch {
            val result = repo.getStory(id)
            if(result is FairytaleResponse.Success)
                stories.value = result.data
        }
    }
}