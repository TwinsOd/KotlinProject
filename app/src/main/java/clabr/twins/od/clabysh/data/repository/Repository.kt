package clabr.twins.od.clabysh.data.repository

interface Repository {
    fun getGames(callback: LoadDataCallback<List<String>>)


}