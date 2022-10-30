package com.mozhimen.biz_db.commons

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mozhimen.basick.utilk.UtilKGlobal
import com.mozhimen.biz_db.mos.AudioBean
import com.mozhimen.biz_db.mos.FavouriteBean

/**
 * @ClassName Database
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/10/30 12:14
 * @Version 1.0
 */
@Database(entities = [AudioBean::class, FavouriteBean::class], version = 1, exportSchema = false)
abstract class MusicBoxDatabase : RoomDatabase() {
    abstract val favouriteDao: IFavouriteDao
    abstract val audioDao: IAudioDao

    companion object {
        @Volatile
        private var _db: MusicBoxDatabase =
            Room.databaseBuilder(UtilKGlobal.instance.getApp()!!, MusicBoxDatabase::class.java, "musicbox_db").build()

        @JvmStatic
        fun get(): MusicBoxDatabase {
            return _db
        }
    }
}