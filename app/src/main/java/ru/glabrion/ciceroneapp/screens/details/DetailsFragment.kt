package ru.glabrion.ciceroneapp.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_details.view.*
import moxy.presenter.InjectPresenter
import ru.glabrion.ciceroneapp.R
import ru.glabrion.ciceroneapp.Screens
import ru.glabrion.ciceroneapp.common.AppConst.ALBUM_ID_KEY
import ru.glabrion.ciceroneapp.model.network.Photo
import ru.glabrion.ciceroneapp.ui.base.BaseFragment

class DetailsFragment : BaseFragment(), DetailsView {

    @InjectPresenter
    lateinit var presenter: DetailsPresenter
    private var albumId: Int? = 0
    private var albumAdapter = AlbumAdapter()

    companion object {
        fun getNewInstance(id: Int?): DetailsFragment {
            val detailsFragment = DetailsFragment()
            val bundle = Bundle()
            bundle.putInt(ALBUM_ID_KEY, id ?: 0)
            detailsFragment.arguments = bundle
            return detailsFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        albumId = arguments?.getInt(ALBUM_ID_KEY, 0)
        view.photos_rv?.layoutManager = GridLayoutManager(view.context, 2)
        view.photos_rv?.adapter = albumAdapter
        view.swipe_container.setOnRefreshListener {router.navigateTo(Screens.DetailsScreen(albumId))}
        presenter.init()
        presenter.showAlbum(albumId)
    }

    override fun setData(photos: MutableList<Photo>) {
        albumAdapter.setData(photos)
    }
}