package ru.glabrion.ciceroneapp

import androidx.fragment.app.Fragment
import ru.glabrion.ciceroneapp.screens.details.DetailsFragment
import ru.glabrion.ciceroneapp.screens.general.GeneralFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class GeneralScreen : SupportAppScreen() {
        override fun getFragment(): Fragment? {
            return GeneralFragment.getNewInstance()
        }
    }

    class DetailsScreen : SupportAppScreen() {
        override fun getFragment(): Fragment? {
            return DetailsFragment.getNewInstance()
        }
    }
}