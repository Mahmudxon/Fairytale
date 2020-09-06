package uz.mahmudxon.fairy.repository.story

import uz.mahmudxon.fairy.db.FairytaleDao
import uz.mahmudxon.fairy.model.Fairytale
import uz.mahmudxon.fairy.repository.FairytaleResponse

class StoryResponseImpl(private val dao: FairytaleDao) : IStoryRepository {
    override suspend fun getStory(id : Int): FairytaleResponse<List<Fairytale>> {
        return try {
            val result = dao.getById(id)
            FairytaleResponse.Success(result)
        } catch (e: Exception) {
            FairytaleResponse.Error(e)
        }
    }

}