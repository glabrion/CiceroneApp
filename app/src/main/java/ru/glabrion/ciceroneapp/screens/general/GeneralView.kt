package ru.glabrion.ciceroneapp.screens.general

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.glabrion.ciceroneapp.ui.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface GeneralView: BaseView {
    fun showContent(text: String)
}