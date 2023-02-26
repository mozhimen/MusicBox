package com.imooc.lib_audio.mediaplayer.db

import com.imooc.lib_audio.mediaplayer.model.AudioBean
import com.imooc.lib_audio.mediaplayer.model.FavouriteBean

/**
 * @ClassName GreenDaoHelper
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2023/2/25 18:15
 * @Version 1.0
 */
object DBHelper {
    private lateinit var _db: MusicBoxDatabase

    @JvmStatic
    fun initDatabase() {
        _db = MusicBoxDatabase.get()
    }

    @JvmStatic
    fun addFavourite(audioBean: AudioBean) {
        _db.favouriteDao.insertFavouriteBean(FavouriteBean(audioBean.id))
    }

    @JvmStatic
    fun removeFavourite(audioBean: AudioBean) {
        _db.favouriteDao.deleteFavouriteBeanByAudioId(audioBean.id)
    }

    @JvmStatic
    fun selectFavourite(audioBean: AudioBean): FavouriteBean? {
        return _db.favouriteDao.selectFavouriteBeanByAudioId(audioBean.id)
    }
}