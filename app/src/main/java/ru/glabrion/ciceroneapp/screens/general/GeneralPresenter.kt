package ru.glabrion.ciceroneapp.screens.general

import kotlinx.coroutines.*
import ru.glabrion.ciceroneapp.CiceroneApplication
import ru.glabrion.ciceroneapp.model.network.Album
import ru.glabrion.ciceroneapp.ui.base.BasePresenter
import kotlin.coroutines.CoroutineContext

class GeneralPresenter(): BasePresenter<GeneralView>(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun showAlbums() {
        var albums = mutableListOf<Album>()
        launch {
            albums = withContext(coroutineContext){
                apiService.getAlbums().await()
            }
            withContext(Dispatchers.Main){
                viewState.showAlbums(albums)
            }
        }
    }

    fun init() {
        CiceroneApplication.instance.getAppComponent().inject(this)
    }
}