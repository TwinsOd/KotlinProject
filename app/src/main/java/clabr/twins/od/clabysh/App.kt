package clabr.twins.od.clabysh

import android.app.Application
import android.content.Context
import clabr.twins.od.clabysh.data.model.GameModel
import clabr.twins.od.clabysh.data.repository.Repository
import clabr.twins.od.clabysh.data.repository.RepositoryImpl
import com.imangazaliev.notelin.mvp.model.AppDatabase
import com.reactiveandroid.ReActiveAndroid
import com.reactiveandroid.ReActiveConfig
import com.reactiveandroid.internal.database.DatabaseConfig

class App : Application() {
    var repository : Repository? = null

    override fun onCreate() {
        super.onCreate()

        repository = RepositoryImpl(this)

        val appDatabaseConfig = DatabaseConfig.Builder(AppDatabase::class.java)
                .addModelClasses(GameModel::class.java)
                .build()

        ReActiveAndroid.init(ReActiveConfig.Builder(this)
                .addDatabaseConfigs(appDatabaseConfig)
                .build())
    }

    companion object {

        operator fun get(context: Context): App {
            return context.applicationContext as App
        }
    }
}