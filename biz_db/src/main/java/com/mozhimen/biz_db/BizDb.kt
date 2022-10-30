package com.mozhimen.biz_db

import com.mozhimen.biz_db.commons.MusicBoxDatabase
import com.mozhimen.biz_db.mos.AudioBean
import com.mozhimen.biz_db.mos.FavouriteBean

/**
 * @ClassName BizDb
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/10/30 12:36
 * @Version 1.0
 */
object BizDb {
    private val _audioDao = MusicBoxDatabase.get().audioDao
    private val _favouriteDao = MusicBoxDatabase.get().favouriteDao

    fun addFavouriteBean(audioBean: AudioBean) {
        _audioDao.insertAudioBean(audioBean)
        _favouriteDao.insertFavouriteBean(FavouriteBean(audioBean.id))
    }

    fun removeFavouriteBean(audioId: String) {
        _audioDao.deleteAudioBeanById(audioId)
        _favouriteDao.deleteFavouriteBeanByAudioId(audioId)
    }

    fun hasFavouriteBean(audioId: String): Boolean =
        _favouriteDao.selectFavouriteBeanByAudioId(audioId) != null
}