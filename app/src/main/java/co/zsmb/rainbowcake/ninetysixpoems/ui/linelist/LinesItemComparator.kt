package co.zsmb.rainbowcake.ninetysixpoems.ui.linelist

import androidx.recyclerview.widget.DiffUtil
import co.zsmb.rainbowcake.ninetysixpoems.domain.Line

object LinesItemComparator : DiffUtil.ItemCallback<Line>() {
    override fun areItemsTheSame(oldItem: Line, newItem: Line): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Line, newItem: Line): Boolean {
        return oldItem.line == newItem.line
    }

}
