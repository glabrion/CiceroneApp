package ru.glabrion.ciceroneapp.ui.screens.general

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.glabrion.ciceroneapp.model.network.Album
import ru.glabrion.ciceroneapp.ui.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface GeneralView: BaseView {
    fun showAlbums(album: List<Album>)
    fun openAlbumDetails(id: Int?)
}