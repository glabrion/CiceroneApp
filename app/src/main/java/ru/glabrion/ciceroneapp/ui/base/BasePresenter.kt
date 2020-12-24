package ru.glabrion.ciceroneapp.ui.base

import moxy.MvpPresenter
import ru.glabrion.ciceroneapp.model.network.Api
import ru.terrakok.cicerone.Router
import javax.inject.Inject

abstract class BasePresenter<View: BaseView> : MvpPresenter<View>() {
    @Inject
    protected lateinit var router: Router

    @Inject
    protected lateinit var apiService: Api

    abstract fun injectDependency()
}