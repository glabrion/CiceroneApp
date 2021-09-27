package ru.glabrion.ciceroneapp.ui.screens.details

import kotlinx.coroutines.*
import moxy.InjectViewState
import ru.glabrion.ciceroneapp.CiceroneApplication
import ru.glabrion.ciceroneapp.ui.base.BasePresenter
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

@InjectViewState
class DetailsPresenter : BasePresenter<DetailsView>(), CoroutineScope {

  private val job = Job()
  override val coroutineContext: CoroutineContext
    get() = job + Dispatchers.IO

  fun showAlbum(albumId: Int?) {

    launch {
      try {
        val photos =
            withContext(coroutineContext) { apiService.getPhotosByAlbumId(albumId) }
        launch(Dispatchers.Main) {
          viewState.setData(photos)
        }
      } catch (e: Exception) {
        e.printStackTrace()
        launch(Dispatchers.Main) {
          viewState.showError()
        }
      }
    }
  }

  override fun injectDependency() {
    CiceroneApplication.instance.getAppComponent().inject(this)
  }

  fun backPressed() {
    router.exit()
  }

}