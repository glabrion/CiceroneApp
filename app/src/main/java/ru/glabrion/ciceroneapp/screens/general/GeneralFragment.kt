package ru.glabrion.ciceroneapp.screens.general

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_general.*
import ru.glabrion.ciceroneapp.R
import ru.glabrion.ciceroneapp.Screens
import ru.glabrion.ciceroneapp.ui.base.BaseFragment

class GeneralFragment: BaseFragment() {
    companion object {
        fun getNewInstance(): GeneralFragment {
            return GeneralFragment()
        }
    }

//    @InjectPresenter
//    lateinit var presenter: GeneralPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_general, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        to_details_screen.setOnClickListener { router.navigateTo(Screens.DetailsScreen()) }
    }
}