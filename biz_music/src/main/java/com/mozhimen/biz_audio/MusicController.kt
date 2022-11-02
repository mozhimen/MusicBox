package com.mozhimen.biz_audio

import com.mozhimen.componentk.audiok.AudioK
import com.mozhimen.componentk.audiok.mos.MAudioK

/**
 * @ClassName MusicController
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/11/2 22:39
 * @Version 1.0
 */
object MusicController {
    @JvmStatic
    fun addMusic(music: MAudioK) {
        AudioK.instance.addAudioToPlayList(music)
    }

    @JvmStatic
    fun pauseMusic() {
        AudioK.instance.pause()
    }

    @JvmStatic
    fun playMusic() {
        AudioK.instance.play()
    }
}