package co.zsmb.rainbowcake.ninetysixpoems.ui.detail

sealed class DetailViewState

object Loading : DetailViewState()

data class DetailReady(val news: DetailPresenter.DetailedNewsItem) : DetailViewState()
