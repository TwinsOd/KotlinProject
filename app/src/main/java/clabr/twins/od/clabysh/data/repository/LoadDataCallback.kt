package clabr.twins.od.clabysh.data.repository

interface LoadDataCallback<T> {
    fun onDataLoaded(response: T)

    fun onError(throwable: Throwable)
}