package co.zsmb.rainbowcake.ninetysixpoems.ui.saved

import androidx.recyclerview.widget.DiffUtil
import co.zsmb.rainbowcake.ninetysixpoems.ui.saved.SavedPresenter.SavedNewsItem

object SavedNewsItemComparator : DiffUtil.ItemCallback<SavedNewsItem>() {
    override fun areItemsTheSame(oldItem: SavedNewsItem, newItem: SavedNewsItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SavedNewsItem, newItem: SavedNewsItem): Boolean {
        return oldItem == newItem
    }
}
