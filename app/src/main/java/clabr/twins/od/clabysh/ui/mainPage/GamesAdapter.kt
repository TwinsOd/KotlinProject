package clabr.twins.od.clabysh.ui.mainPage

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import clabr.twins.od.clabysh.R
import clabr.twins.od.clabysh.data.model.GameModel
import clabr.twins.od.clabysh.data.utils.formatDate


class GamesAdapter(private val gamesList: List<GameModel>) : RecyclerView.Adapter<GamesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GamesAdapter.ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.game_item, viewGroup, false)
        return GamesAdapter.ViewHolder(v)
    }

    override
    fun onBindViewHolder(viewHolder: GamesAdapter.ViewHolder, i: Int) {
        val model = gamesList[i]
        viewHolder.noteTitle.text = String.format("number %s", i)
        viewHolder.noteDate.text = formatDate(model.createAt)
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var noteTitle: TextView = itemView.findViewById(R.id.tvItemNoteTitle) as TextView
        var noteDate: TextView = itemView.findViewById(R.id.tvItemNoteDate) as TextView
    }
}
