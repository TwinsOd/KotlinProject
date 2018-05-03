package clabr.twins.od.clabysh.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import clabr.twins.od.clabysh.App
import clabr.twins.od.clabysh.R
import clabr.twins.od.clabysh.data.repository.LoadDataCallback
import clabr.twins.od.clabysh.data.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var listGames : List<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout_new_game.setOnClickListener(this)
        add_new_game_image.setOnClickListener(this)
        add_new_game_text.setOnClickListener(this)

        App.get(this).repository!!.getGames(object : LoadDataCallback<List<String>> {
            override fun onDataLoaded(response: List<String>) {
                listGames = response
            }

            override fun onError(throwable: Throwable) {

            }
        })
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.layout_new_game -> Toast.makeText(this, listGames!![0], Toast.LENGTH_SHORT).show()
                R.id.add_new_game_image -> Toast.makeText(this, listGames!![1], Toast.LENGTH_SHORT).show()
                R.id.add_new_game_text -> Toast.makeText(this, listGames!![2], Toast.LENGTH_SHORT).show()
            }
        }
    }
}
