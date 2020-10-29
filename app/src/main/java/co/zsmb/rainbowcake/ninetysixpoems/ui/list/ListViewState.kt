package co.zsmb.rainbowcake.ninetysixpoems.ui.list

import co.zsmb.rainbowcake.ninetysixpoems.ui.list.ListPresenter.NewsItem

sealed class ListViewState

object Loading : ListViewState()

data class ListReady(val news: List<NewsItem>) : ListViewState()

object NetworkError : ListViewState()
