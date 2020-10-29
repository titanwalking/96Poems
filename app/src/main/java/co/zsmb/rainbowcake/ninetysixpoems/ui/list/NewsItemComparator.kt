package co.zsmb.rainbowcake.ninetysixpoems.ui.list

import androidx.recyclerview.widget.DiffUtil
import co.zsmb.rainbowcake.ninetysixpoems.ui.list.ListPresenter.NewsItem

object NewsItemComparator : DiffUtil.ItemCallback<NewsItem>() {
    override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem == newItem
    }
}
