package ru.glabrion.ciceroneapp.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        injectDependency()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    abstract fun injectDependency()
}