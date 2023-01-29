package com.example.gameondemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.room.Room

class MainActivity : AppCompatActivity() {

    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGenerateUsers = findViewById<Button>(R.id.btnGenerateUsers)

        val database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "users-database"
        ).allowMainThreadQueries().build()

        userDao = database.userDao()

        btnGenerateUsers.setOnClickListener {
            generateData()
        }
    }

    private fun generateData() {
        val users = mutableListOf<UserEntity>()
        for (i in 1..10000) {
            val randomNumbers = (0..100).random()
            users.add(
                UserEntity(
                    nome = "User $randomNumbers",
                    email = "xxx@gmail.com",
                    golos = randomNumbers,
                    assistencias = randomNumbers,
                    nrJogos = randomNumbers,
                    imageUrl = "userImage$randomNumbers.jpg"
                )
            )
        }
        val startTime = System.currentTimeMillis()

        userDao.registerUsers(users)

        val endTime = System.currentTimeMillis()
        val elapsedTime = endTime - startTime
        println("Tempo total de inserção: $elapsedTime ms")
    }
}