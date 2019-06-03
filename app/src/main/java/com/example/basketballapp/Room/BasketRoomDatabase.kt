package com.example.basketballapp.Room

import android.content.Context
import androidx.room.*
import androidx.room.Database
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.basketballapp.Room.Dao.GameBasketDao
import com.example.basketballapp.Room.Entity.GameBasket
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * This is the backend. The database. This used to be done by the OpenHelper.
 * The fact that this has very few comments emphasizes its coolness.
 */
@Database(entities = [GameBasket::class], version = 2)

abstract class BasketRoomDatabase : RoomDatabase() {

    abstract fun GameBasketDao(): GameBasketDao


    companion object {
        @Volatile
        private var INSTANCE: BasketRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): BasketRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BasketRoomDatabase::class.java,
                    "GameBasket_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(Companion.BookDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private class BookDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            /**
             * Override the onOpen method to populate the database.
             * For this sample, we clear the database every time it is created or opened.
             */
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.GameBasketDao())
                    }
                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more words, just add them.
         */
        suspend fun populateDatabase(gameBasketDao: GameBasketDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            gameBasketDao.deleteAll()

            //Insert Games
            gameBasketDao.insert(GameBasket(1,"Barca","Madrid",1,2,"22/07/1998","13:30"))
            gameBasketDao.insert(GameBasket(2,"Liverpool","Alianza",2,3,"22/07/2019","15:30"))
        }
    }

}
