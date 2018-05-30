package clabr.twins.od.clabysh.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import clabr.twins.od.clabysh.ui.mainPage.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(this, MainActivity::class.java))
    }
}
