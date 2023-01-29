package com.example.gameondemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity (

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @ColumnInfo(name = "nome")
    var nome: String?,

    @ColumnInfo(name = "email")
    var email: String?,

    @ColumnInfo(name = "golos")
    var golos: Int?,

    @ColumnInfo(name = "assistencias")
    var assistencias: Int?,

    @ColumnInfo(name = "nr-jogos")
    var nrJogos: Int?,

    @ColumnInfo(name = "image-url")
    var imageUrl: String?

)