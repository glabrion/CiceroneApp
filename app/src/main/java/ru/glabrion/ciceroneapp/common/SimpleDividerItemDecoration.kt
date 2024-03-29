package ru.glabrion.ciceroneapp.common

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView
import ru.glabrion.ciceroneapp.R

class SimpleDividerItemDecoration(context: Context?) : RecyclerView.ItemDecoration() {
  private var mDivider: Drawable? = null

  init {
    if (context != null) {
      mDivider = context.getDrawable(R.drawable.items_divider)
    }
  }

  override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
    val left = parent.paddingLeft
    val right = parent.width - parent.paddingRight + 10

    val childCount = parent.childCount
    for (i in 0 until childCount) {
      val child = parent.getChildAt(i)

      val params = child.layoutParams as RecyclerView.LayoutParams

      val top = child.bottom + params.bottomMargin
      val bottom = top + (mDivider?.intrinsicHeight ?: 0)

      mDivider?.setBounds(left, top, right, bottom)
      mDivider?.draw(c)
    }
  }
}