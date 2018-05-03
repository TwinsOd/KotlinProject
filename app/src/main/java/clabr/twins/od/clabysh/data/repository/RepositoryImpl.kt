package clabr.twins.od.clabysh.data.repository

import android.content.Context

class RepositoryImpl(context : Context) : Repository {

    override fun getGames(callback: LoadDataCallback<List<String>>) {
        val list : MutableList<String> = mutableListOf()
        list.add("first")
        list.add("second")
        list.add("3_")
        list.add("4_")

        callback.onDataLoaded(list)
    }
}