package ru.glabrion.ciceroneapp

import android.app.Application
import android.content.Context
import ru.glabrion.ciceroneapp.di.component.AppComponent
import ru.glabrion.ciceroneapp.di.component.DaggerAppComponent


class CiceroneApplication : Application() {
    companion object {
        lateinit var instance: CiceroneApplication
    }

    private lateinit var appComponent: AppComponent

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        instance = this
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder().build()
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }

}