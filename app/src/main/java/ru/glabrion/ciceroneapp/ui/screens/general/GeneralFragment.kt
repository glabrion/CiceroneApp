package ru.glabrion.ciceroneapp.ui.screens.general

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_general.view.*
import moxy.presenter.InjectPresenter
import ru.glabrion.ciceroneapp.R
import ru.glabrion.ciceroneapp.Screens
import ru.glabrion.ciceroneapp.common.SimpleDividerItemDecoration
import ru.glabrion.ciceroneapp.model.network.Album
import ru.glabrion.ciceroneapp.ui.base.BaseFragment

class GeneralFragment : BaseFragment(), GeneralView {

    companion object {
        fun getNewInstance(): GeneralFragment {
            return GeneralFragment()
        }
    }

    @InjectPresenter
    lateinit var presenter: GeneralPresenter

    private var albumsAdapter =
        AlbumsAdapter { album: Album -> router.navigateTo(Screens.DetailsScreen(album.id, album.title)) }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_general, container, false)
    }

    override fun injectDependency() {
        presenter.injectDependency()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.swipe_container?.setOnRefreshListener {
            router.newRootScreen(Screens.GeneralScreen())
        }
        view.albums_rv?.layoutManager = LinearLayoutManager(view.context)
        view.albums_rv?.adapter = albumsAdapter
        view.albums_rv?.addItemDecoration(SimpleDividerItemDecoration(context))
        presenter.showAlbums()
    }

    override fun showAlbums(album: List<Album>) {
        albumsAdapter.setData(album)
    }
}