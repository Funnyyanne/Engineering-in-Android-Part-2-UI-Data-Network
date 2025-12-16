package com.epam.test.minimalistnotes


import android.content.Context
import androidx.room.*

//
//// --- 1. Entity: 定义表结构 ---
//@Entity(tableName = "users")
//data class User(
//    @PrimaryKey(autoGenerate = true) val id: Int = 0,
//    val name: String,
//    val role: String
//)
//
//// --- 2. DAO: 定义操作方法 ---
//@Dao
//interface UserDao {
//    // 返回 Flow，这样数据库更新时 UI 会自动收到通知
//    @Query("SELECT * FROM users ORDER BY id DESC")
//    fun getAllUsers(): Flow<List<User>>
//
//    @Insert
//    suspend fun insertUser(user: User)
//
//    @Delete
//    suspend fun deleteUser(user: User)
//}
//
//// --- 3. Database: 数据库入口 ---
//@Database(entities = [User::class], version = 1, exportSchema = false)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun userDao(): UserDao
//
//    // 单例模式：确保全局只有一个数据库实例
//    companion object {
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        fun getDatabase(context: Context): AppDatabase {
//            return INSTANCE ?: synchronized(this) {
//                Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "contact_database"
//                )
//                    .fallbackToDestructiveMigration() // 仅用于演示：版本冲突时重建数据库
//                    .build()
//                    .also { INSTANCE = it }
//            }
//        }
//    }
//}

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "note_database"
                )
//                    .fallbackToDestructiveMigration() // 允许在版本冲突时重建数据库
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}