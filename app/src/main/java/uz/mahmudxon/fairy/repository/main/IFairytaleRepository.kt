package uz.mahmudxon.fairy.repository.main

import uz.mahmudxon.fairy.model.Fairytale
import uz.mahmudxon.fairy.repository.FairytaleResponse

interface IFairytaleRepository {
    suspend fun getAll() : FairytaleResponse<List<Fairytale>>
}