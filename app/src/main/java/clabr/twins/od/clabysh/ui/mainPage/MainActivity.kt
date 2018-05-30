package clabr.twins.od.clabysh.ui.mainPage

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import clabr.twins.od.clabysh.App
import clabr.twins.od.clabysh.R
import clabr.twins.od.clabysh.data.model.GameModel
import clabr.twins.od.clabysh.data.repository.LoadDataCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var listGames: List<GameModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout_new_game.setOnClickListener {
            Toast.makeText(this, "click new game", Toast.LENGTH_SHORT).show()
        }
        game_list.layoutManager = LinearLayoutManager(this)
        with(ItemClickSupport.addTo(game_list)) {
            setOnItemClickListener { game_list }
            setOnItemLongClickListener { game_list; true }
        }
        App[this].repository!!.getGames(object : LoadDataCallback<List<GameModel>> {
            override fun onDataLoaded(response: List<GameModel>) {
                listGames = response
                game_list.adapter = GamesAdapter(listGames!!)
                updateView()
            }

            override fun onError(throwable: Throwable) {

            }
        })
    }

    fun updateView() {
        game_list.adapter.notifyDataSetChanged()
        if (listGames == null || listGames!!.isEmpty()) {
            game_list.visibility = View.GONE
            games_is_empty.visibility = View.VISIBLE
        } else {
            game_list.visibility = View.VISIBLE
            games_is_empty.visibility = View.GONE
        }
    }
}
