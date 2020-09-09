package com.luckytrip.luckytrip

import androidx.multidex.MultiDexApplication
import com.luckytrip.luckytrip.api.apiClientModule
import com.luckytrip.luckytrip.api.rooms.roomsRepository
import com.luckytrip.luckytrip.api.json.parsingModules
import com.luckytrip.luckytrip.logger.loggerModule
import com.luckytrip.luckytrip.ui.home.homeViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

val moduleList = listOf(
    parsingModules,
    apiClientModule,
    roomsRepository,
    loggerModule,
    homeViewModelModule
)

class App : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(moduleList)
        }
    }
}
