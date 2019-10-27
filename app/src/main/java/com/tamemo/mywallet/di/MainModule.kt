package com.tamemo.mywallet.di

import android.content.Context
import com.tamemo.mywallet.common.Scheduler
import com.tamemo.mywallet.database.AppDatabase
import com.tamemo.mywallet.preference.UserPreference
import com.tamemo.mywallet.repository.WalletRepository
import com.tamemo.mywallet.ui.dashboard.DashboardViewModel
import com.tamemo.mywallet.ui.main.MainViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun getModules(context: Context) = listOf(
        getPreferenceModule(context),
        getDatabaseModule(context),
        getViewModelModule(),
        getRepositoryModule(),
        getCommonModule()
)

fun getPreferenceModule(context: Context): Module {
    return module {
        single { UserPreference(context.getSharedPreferences(UserPreference.domain, UserPreference.mode)) }
    }
}

fun getDatabaseModule(context: Context): Module {
    return module {
        single { AppDatabase.newInstance(context) }
        single { get<AppDatabase>().getUserDao() }
        single { get<AppDatabase>().getWalletDao() }
        single { get<AppDatabase>().getTransactionDao() }
    }
}

fun getViewModelModule(): Module {
    return module {
        single { MainViewModel(get()) }
        single { DashboardViewModel(get()) }
    }
}

fun getRepositoryModule(): Module {
    return module {
        single { WalletRepository(get(), get(), get(), get(), get()) }
    }
}

fun getCommonModule(): Module {
    return module {
        single { Scheduler() }
    }
}