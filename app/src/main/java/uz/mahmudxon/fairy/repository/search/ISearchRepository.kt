package uz.mahmudxon.fairy.repository.search

import uz.mahmudxon.fairy.model.Fairytale
import uz.mahmudxon.fairy.repository.FairytaleResponse

interface ISearchRepository {
    suspend fun getStory(search : String) : FairytaleResponse<List<Fairytale>>
}