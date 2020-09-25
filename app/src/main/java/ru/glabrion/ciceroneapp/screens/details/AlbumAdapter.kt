package ru.glabrion.ciceroneapp.screens.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_photo.view.*
import ru.glabrion.ciceroneapp.R
import ru.glabrion.ciceroneapp.common.getProgressBar
import ru.glabrion.ciceroneapp.model.network.Photo

class AlbumAdapter :
    RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    private val photos = mutableListOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_photo,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    override fun getItemCount() = photos.size

    fun setData(items: List<Photo>) {
        photos.clear()
        photos.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(photo: Photo) {
            itemView.photo_iv?.apply {
                val path = photo.url
                Picasso.get()
                    .load(path)
                    .error(R.drawable.error)
                    .placeholder(getProgressBar(context))
                    .into(itemView.photo_iv)
            }
        }
    }
}