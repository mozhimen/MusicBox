package com.imooc.lib_audio.mediaplayer.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.imooc.lib_audio.mediaplayer.model.AudioBean
import com.imooc.lib_audio.mediaplayer.model.FavouriteBean
import com.mozhimen.basick.utilk.content.UtilKApplication

/**
 * @ClassName MusicBoxDatabase
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2023/2/25 18:21
 * @Version 1.0
 */
@Database(entities = [AudioBean::class, FavouriteBean::class], version = 1, exportSchema = false)
abstract class MusicBoxDatabase : RoomDatabase() {
    abstract val favouriteDao: IFavouriteDao
    abstract val audioDao: IAudioDao

    companion object {
        @Volatile
        private var _db: MusicBoxDatabase =
            Room.databaseBuilder(UtilKApplication.instance.get(), MusicBoxDatabase::class.java, "musicbox_db").allowMainThreadQueries().build()

        @JvmStatic
        fun get(): MusicBoxDatabase {
            return _db
        }
    }
}
