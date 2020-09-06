package uz.mahmudxon.fairy.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import org.koin.core.KoinComponent
import org.koin.core.inject
import uz.mahmudxon.fairy.model.Fairytale
import uz.mahmudxon.fairy.repository.FairytaleResponse
import uz.mahmudxon.fairy.repository.main.IFairytaleRepository

class MainViewModel : ViewModel(), KoinComponent {
    private val repo: IFairytaleRepository by inject()
    val data: LiveData<List<Fairytale>> = liveData {
        val result = repo.getAll()
        if (result is FairytaleResponse.Success)
            emit(result.data)
    }
}