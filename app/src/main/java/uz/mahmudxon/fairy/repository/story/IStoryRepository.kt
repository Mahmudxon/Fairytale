package uz.mahmudxon.fairy.repository.story

import uz.mahmudxon.fairy.model.Fairytale
import uz.mahmudxon.fairy.repository.FairytaleResponse

interface IStoryRepository {
    suspend fun getStory(id : Int) : FairytaleResponse<List<Fairytale>>
}