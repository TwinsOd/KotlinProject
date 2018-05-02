package clabr.twins.od.clabysh

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout_new_game.setOnClickListener(this)
        add_new_game_image.setOnClickListener(this)
        add_new_game_text.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.layout_new_game -> Toast.makeText(this, "layout", Toast.LENGTH_SHORT).show()
                R.id.add_new_game_image -> Toast.makeText(this, "img", Toast.LENGTH_SHORT).show()
                R.id.add_new_game_text -> Toast.makeText(this, "text", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
