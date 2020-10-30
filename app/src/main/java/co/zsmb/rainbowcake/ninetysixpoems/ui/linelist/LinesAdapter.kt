package co.zsmb.rainbowcake.ninetysixpoems.ui.linelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import co.zsmb.rainbowcake.ninetysixpoems.R
import co.zsmb.rainbowcake.ninetysixpoems.domain.Line
import kotlinx.android.synthetic.main.item_news.view.*

class LinesAdapter : ListAdapter<Line, LinesAdapter.ViewHolder>(LinesItemComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lines, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val headline: TextView = itemView.headlineText
        private val trail: TextView = itemView.trailText

        fun bind(item: Line) {
            headline.text = item.line
            trail.text = item.line
        }
    }
}
