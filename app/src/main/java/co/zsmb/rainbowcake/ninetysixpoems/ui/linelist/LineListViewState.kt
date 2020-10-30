package co.zsmb.rainbowcake.ninetysixpoems.ui.linelist

import co.zsmb.rainbowcake.ninetysixpoems.domain.Line

sealed class LineListViewState

object Loading : LineListViewState()

data class LineListReady(val news: ArrayList<Line>) : LineListViewState()

object NetworkError : LineListViewState()
