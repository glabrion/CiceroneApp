package ru.glabrion.ciceroneapp

import androidx.fragment.app.Fragment
import ru.glabrion.ciceroneapp.ui.screens.details.DetailsFragment
import ru.glabrion.ciceroneapp.ui.screens.general.GeneralFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
  class GeneralScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
      return GeneralFragment.getNewInstance()
    }
  }

  class DetailsScreen(private val id: Int?, private val title: String?) : SupportAppScreen() {
    override fun getFragment(): Fragment {
      return DetailsFragment.getNewInstance(id, title)
    }
  }
}