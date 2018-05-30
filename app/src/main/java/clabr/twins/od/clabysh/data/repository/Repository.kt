package clabr.twins.od.clabysh.data.repository

import clabr.twins.od.clabysh.data.model.GameModel

interface Repository {
    fun getGames(callback: LoadDataCallback<List<GameModel>>)


}