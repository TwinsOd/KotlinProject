package clabr.twins.od.clabysh.data.model

import com.imangazaliev.notelin.mvp.model.AppDatabase
import com.reactiveandroid.Model
import com.reactiveandroid.annotation.Column
import com.reactiveandroid.annotation.PrimaryKey
import com.reactiveandroid.annotation.Table
import java.util.*

@Table(name = "GameModel", database = AppDatabase::class)
class GameModel : Model {

    @PrimaryKey
    var id: Long = 0
    @Column(name = "name_player_1")
    var namePlater_1: String? = null
    @Column(name = "name_player_2")
    var namePlater_2: String? = null
    @Column(name = "name_player_3")
    var namePlater_3: String? = null
    @Column(name = "name_player_4")
    var namePlater_4: String? = null
    @Column(name = "created_at")
    var createAt: Date? = null
    @Column(name = "change_at")
    var changedAt: Date? = null
    @Column(name = "max_score")
    var maxScore: Int? = null
    @Column(name = "team_1")
    var team_1: TeamModel? = null
    @Column(name = "team_2")
    var team_2: TeamModel? = null
    @Column(name = "team_3")
    var team_3: TeamModel? = null
    @Column(name = "count_players")
    var countPlayers: Int? = null

    constructor(createAt: Date, maxScore: Int, countPlayers: Int) {
        this.createAt = createAt
        this.maxScore = maxScore
        this.countPlayers = countPlayers
    }

    constructor()
}