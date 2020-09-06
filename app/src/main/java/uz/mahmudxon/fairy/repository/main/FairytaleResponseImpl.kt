package uz.mahmudxon.fairy.repository.main

import uz.mahmudxon.fairy.db.FairytaleDao
import uz.mahmudxon.fairy.model.Fairytale
import uz.mahmudxon.fairy.repository.FairytaleResponse

class FairytaleResponseImpl(private val dao: FairytaleDao) : IFairytaleRepository {
    override suspend fun getAll(): FairytaleResponse<List<Fairytale>> {
        return try {
            val result = dao.getAll()
            FairytaleResponse.Success(result)
        } catch (e: Exception) {
            FairytaleResponse.Error(e)
        }
    }

}