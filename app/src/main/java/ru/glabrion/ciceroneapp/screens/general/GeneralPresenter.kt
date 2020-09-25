package ru.glabrion.ciceroneapp.screens.general

import kotlinx.coroutines.*
import ru.glabrion.ciceroneapp.CiceroneApplication
import ru.glabrion.ciceroneapp.model.network.Album
import ru.glabrion.ciceroneapp.ui.base.BasePresenter
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class GeneralPresenter() : BasePresenter<GeneralView>(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun showAlbums() {
        var albums: MutableList<Album>
        launch {
            try {
                albums = withContext(coroutineContext) {
                    apiService.getAlbums().await()
                }
                withContext(Dispatchers.Main) {
                    viewState.showAlbums(albums)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun init() {
        CiceroneApplication.instance.getAppComponent().inject(this)
    }
}