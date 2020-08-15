package ru.glabrion.ciceroneapp.ui.base

import android.content.Context
import moxy.MvpAppCompatFragment
import ru.glabrion.ciceroneapp.CiceroneApplication
import ru.terrakok.cicerone.Router
import javax.inject.Inject

abstract class BaseFragment : MvpAppCompatFragment() {
    @Inject
    protected lateinit var router: Router

    override fun onAttach(context: Context) {
        super.onAttach(context)
        CiceroneApplication.instance.getAppComponent().inject(this)
    }
}