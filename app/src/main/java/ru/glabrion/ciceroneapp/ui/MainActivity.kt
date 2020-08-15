package ru.glabrion.ciceroneapp.ui

import android.os.Bundle
import ru.glabrion.ciceroneapp.R
import ru.glabrion.ciceroneapp.Screens
import ru.glabrion.ciceroneapp.ui.base.BaseActivity
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : BaseActivity() {

    override var navigator = SupportAppNavigator(this, R.id.main_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            router.newRootScreen(Screens.GeneralScreen())
        }

    }
}