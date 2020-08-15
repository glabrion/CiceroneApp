package ru.glabrion.ciceroneapp.ui.base

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import moxy.MvpAppCompatActivity
import ru.glabrion.ciceroneapp.CiceroneApplication
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

abstract class BaseActivity : MvpAppCompatActivity(), FragmentManager.OnBackStackChangedListener {
    @Inject
    protected lateinit var router: Router

    @Inject
    protected lateinit var navigatorHolder: NavigatorHolder
    protected open val navigator: Navigator

    init {
        navigator = SupportAppNavigator(this, -1)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        CiceroneApplication.instance.getAppComponent().inject(this)
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }


    private fun init() {
        supportFragmentManager.addOnBackStackChangedListener(this)
    }

    override fun onBackStackChanged() {}
}