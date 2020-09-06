package uz.mahmudxon.fairy.module

import androidx.room.Room
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import uz.mahmudxon.fairy.db.FairytaleDB
import uz.mahmudxon.fairy.list.Adapter
import uz.mahmudxon.fairy.repository.main.FairytaleResponseImpl
import uz.mahmudxon.fairy.repository.main.IFairytaleRepository
import uz.mahmudxon.fairy.repository.search.ISearchRepository
import uz.mahmudxon.fairy.repository.search.SearchResponseImpl
import uz.mahmudxon.fairy.repository.story.IStoryRepository
import uz.mahmudxon.fairy.repository.story.StoryResponseImpl
import uz.mahmudxon.fairy.ui.main.MainViewModel
import uz.mahmudxon.fairy.ui.search.SearchViewModel
import uz.mahmudxon.fairy.ui.story.StoryViewModel
import uz.mahmudxon.fairy.util.Prefs

val appModule = module {
    single { Prefs(get()) }
}

val dbModule = module {
    single<FairytaleDB> {
        Room.databaseBuilder(get(), FairytaleDB::class.java, "Fairytale.db")
            .createFromAsset("ertak.db").build()
    }
    single { get<FairytaleDB>().getDao() }
}

val mainModule = module {
    single {
        Adapter()
    }
    single<IFairytaleRepository> { FairytaleResponseImpl(get()) }
    viewModel {
        MainViewModel()
    }

}

val storyModule = module {
    viewModel {
        StoryViewModel()
    }
    single<IStoryRepository> { StoryResponseImpl(get()) }
}
val searchModule = module {
    viewModel {
        SearchViewModel()
    }
    single<ISearchRepository> { SearchResponseImpl(get()) }
}