package com.example.basketballapp.Room.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GameBasket")

data class GameBasket(
        @PrimaryKey
        var id: Long = 0,
        @ColumnInfo(name = "teamA")
        val teamA: String,
        @ColumnInfo(name = "teamB")
        val teamB: String,
        @ColumnInfo(name = "ScoreTeamA")
        val ScoreTeamA: Int,
        @ColumnInfo(name = "ScoreTeamB")
        val ScoreTeamB: Int,
        @ColumnInfo(name = "Date")
        val date: String,
        @ColumnInfo(name = "Time")
        val time: String


)
