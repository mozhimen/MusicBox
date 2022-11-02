package com.mozhimen.musicbox

import android.os.Bundle
import android.transition.TransitionInflater
import com.mozhimen.basick.basek.BaseKActivityVB
import com.mozhimen.musicbox.databinding.ActivityMusicPlayBinding

/**
 * @ClassName MusicPlayActivity
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/11/2 22:46
 * @Version 1.0
 */
class MusicPlayActivity : BaseKActivityVB<ActivityMusicPlayBinding>() {
    override fun initFlag() {
        window.enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.transition_bottom2top)
    }
    override fun initData(savedInstanceState: Bundle?) {
    }
}