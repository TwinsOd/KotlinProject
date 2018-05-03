package clabr.twins.od.clabysh

import android.app.Application
import android.content.Context
import clabr.twins.od.clabysh.data.repository.Repository
import clabr.twins.od.clabysh.data.repository.RepositoryImpl

class App : Application() {
    var repository : Repository? = null

    override fun onCreate() {
        super.onCreate()

        repository = RepositoryImpl(this)
    }

    companion object {

        operator fun get(context: Context): App {
            return context.applicationContext as App
        }
    }
}