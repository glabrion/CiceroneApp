package ru.glabrion.ciceroneapp.di.component

import dagger.Component
import ru.glabrion.ciceroneapp.di.module.NavigationModule
import ru.glabrion.ciceroneapp.ui.base.BaseActivity
import ru.glabrion.ciceroneapp.ui.base.BaseFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [NavigationModule::class])
interface AppComponent {
    fun inject(activity: BaseActivity?)
    fun inject(activity: BaseFragment?)
}