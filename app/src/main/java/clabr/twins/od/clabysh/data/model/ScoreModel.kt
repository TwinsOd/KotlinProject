package clabr.twins.od.clabysh.data.model

import com.imangazaliev.notelin.mvp.model.AppDatabase
import com.reactiveandroid.Model
import com.reactiveandroid.annotation.Column
import com.reactiveandroid.annotation.PrimaryKey
import com.reactiveandroid.annotation.Table

@Table(name = "ScoreModel", database = AppDatabase::class)
class ScoreModel : Model {

    @PrimaryKey
    var id: Long = 0
    @Column(name = "number")
    var number: Int? = null
    @Column(name = "score")
    var score: Int? = null
    @Column(name = "text")
    var text: String? = null


    constructor(number: Int, score: Int, text: String) {
        this.number = number
        this.score = score
        this.text = text
    }

    constructor()

}