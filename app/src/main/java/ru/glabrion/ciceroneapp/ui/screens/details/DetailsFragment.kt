package ru.glabrion.ciceroneapp.ui.screens.details

import android.icu.text.CaseMap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_details.view.*
import moxy.presenter.InjectPresenter
import ru.glabrion.ciceroneapp.R
import ru.glabrion.ciceroneapp.Screens
import ru.glabrion.ciceroneapp.common.AppConst.ALBUM_ID_KEY
import ru.glabrion.ciceroneapp.common.AppConst.ALBUM_TITLE_KEY
import ru.glabrion.ciceroneapp.common.BackButtonListener
import ru.glabrion.ciceroneapp.model.network.Photo
import ru.glabrion.ciceroneapp.ui.base.BaseFragment

class DetailsFragment : BaseFragment(), DetailsView, BackButtonListener {

  @InjectPresenter
  lateinit var presenter: DetailsPresenter
  private var albumId: Int? = 0
  private var albumTitle: String? = ""
  private var albumAdapter = AlbumAdapter()

  companion object {
    fun getNewInstance(id: Int?, title: String?): DetailsFragment {
      val detailsFragment = DetailsFragment()
      val bundle = Bundle()
      bundle.putInt(ALBUM_ID_KEY, id ?: 0)
      bundle.putString(ALBUM_TITLE_KEY, title ?: "")
      detailsFragment.arguments = bundle
      return detailsFragment
    }
  }

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
                           ): View? {
    super.onCreateView(inflater, container, savedInstanceState)
    return inflater.inflate(R.layout.fragment_details, container, false)
  }

  override fun injectDependency() {
    presenter.injectDependency()
  }


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    albumId = arguments?.getInt(ALBUM_ID_KEY, 0)
    albumTitle = arguments?.getString(ALBUM_TITLE_KEY, "")
    view.photos_rv?.layoutManager = GridLayoutManager(view.context, 2)
    view.photos_rv?.adapter = albumAdapter
    view.swipe_container.setOnRefreshListener {
      router.navigateTo(Screens.DetailsScreen(
          albumId,
          albumTitle
                                             ))
    }
    presenter.showAlbum(albumId)
    view.toolbar.setNavigationOnClickListener {
      onBackPressed()
    }
    view.toolbar?.title = albumTitle
  }

  override fun setData(photos: MutableList<Photo>) {
    albumAdapter.setData(photos)
  }

  override fun onBackPressed(): Boolean {
    presenter.backPressed()
    return true
  }

  override fun showError() {
    Toast.makeText(view?.context, getString(R.string.error), Toast.LENGTH_SHORT).show()
  }
}