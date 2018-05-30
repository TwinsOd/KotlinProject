package clabr.twins.od.clabysh.data.repository

import android.content.Context
import clabr.twins.od.clabysh.data.model.GameModel

class RepositoryImpl(private var context: Context) : Repository {

    override fun getGames(callback: LoadDataCallback<List<GameModel>>) {
        val list: MutableList<GameModel> = mutableListOf()
        list.add(GameModel(1002, 4))
        list.add(GameModel(502, 4))
        list.add(GameModel(502, 2))
        list.add(GameModel(1002, 3))

        callback.onDataLoaded(list)
    }
}