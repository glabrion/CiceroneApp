package ru.glabrion.ciceroneapp.screens.details

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.glabrion.ciceroneapp.ui.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface DetailsView: BaseView {
}