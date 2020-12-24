package ru.glabrion.ciceroneapp.ui.screens.details

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.glabrion.ciceroneapp.model.network.Photo
import ru.glabrion.ciceroneapp.ui.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface DetailsView: BaseView {
    fun setData(photos: MutableList<Photo>)
}