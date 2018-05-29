package clabr.twins.od.clabysh.data.model

import com.imangazaliev.notelin.mvp.model.AppDatabase
import com.reactiveandroid.Model
import com.reactiveandroid.annotation.Column
import com.reactiveandroid.annotation.PrimaryKey
import com.reactiveandroid.annotation.Table

@Table(name = "PlayerModel", database = AppDatabase::class)
class PlayerModel : Model {

    @PrimaryKey
    var id: Long = 0
    @Column(name = "beyt_count")
    var beytCount: Int? = null
    @Column(name = "score_model")
    var scoreListModel: List<ScoreModel>? = null

    constructor(beytCount: Int, scoreListModel: List<ScoreModel>) {
        this.beytCount = beytCount
        this.scoreListModel = scoreListModel
    }

    constructor()

}