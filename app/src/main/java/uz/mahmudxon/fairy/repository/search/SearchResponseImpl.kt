package uz.mahmudxon.fairy.repository.search

import uz.mahmudxon.fairy.db.FairytaleDao
import uz.mahmudxon.fairy.model.Fairytale
import uz.mahmudxon.fairy.repository.FairytaleResponse

class SearchResponseImpl(private val dao: FairytaleDao) : ISearchRepository {
    override suspend fun getStory(search : String): FairytaleResponse<List<Fairytale>> {
        return try {
            val result = dao.getBySearch("$search%")
            FairytaleResponse.Success(result)
        } catch (e: Exception) {
            FairytaleResponse.Error(e)
        }
    }

}