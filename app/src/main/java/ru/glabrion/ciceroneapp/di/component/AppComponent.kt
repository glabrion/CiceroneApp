package ru.glabrion.ciceroneapp.di.component

import dagger.Component
import ru.glabrion.ciceroneapp.di.module.ApiModule
import ru.glabrion.ciceroneapp.di.module.NavigationModule
import ru.glabrion.ciceroneapp.ui.screens.details.DetailsPresenter
import ru.glabrion.ciceroneapp.ui.screens.general.GeneralPresenter
import ru.glabrion.ciceroneapp.ui.base.BaseActivity
import ru.glabrion.ciceroneapp.ui.base.BaseFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [NavigationModule::class, ApiModule::class])
interface AppComponent {
    fun inject(baseActivity: BaseActivity?)
    fun inject(baseFragment: BaseFragment?)
    fun inject(generalPresenter: GeneralPresenter?)
    fun inject(detailsPresenter: DetailsPresenter?)
}