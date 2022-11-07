package com.mozhimen.biz_ui.music

import android.animation.Animator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import com.mozhimen.basick.basek.BaseKLayoutRelative
import com.mozhimen.biz_ui.R
import com.mozhimen.biz_ui.music.commons.ILayoutKMusicListener
import com.mozhimen.biz_ui.music.helpers.MusicPagerAdapter

/**
 * @ClassName ViewKMusicIndicator
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/11/3 23:27
 * @Version 1.0
 */
class LayoutKMusicIndicator @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    BaseKLayoutRelative(context, attrs, defStyleAttr) {

    private lateinit var _imgViewIndicator: ImageView
    private lateinit var _viewPagerDisc: ViewPager
    private lateinit var _musicPagerAdapter: MusicPagerAdapter

    private var _currentIndex: Int = 0
    private val _imgUrls = ArrayList<String>()
    private var _layoutKMusicListener: ILayoutKMusicListener? = null
    private val _onPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {
            _layoutKMusicListener?.onMusicChange(position)
        }

        override fun onPageScrollStateChanged(state: Int) {
            when (state) {
                ViewPager.SCROLL_STATE_IDLE -> showPlayView()
                ViewPager.SCROLL_STATE_DRAGGING -> showPauseView()
                ViewPager.SCROLL_STATE_SETTLING -> {}
            }
        }
    }

    fun setListener(listener: ILayoutKMusicListener) {
        _layoutKMusicListener = listener
    }

    fun setMusicLoad(index: Int) {
        if (index in _imgUrls.indices) {
            _currentIndex = index.also { showLoadView(it, true) }
        }
    }

    fun setMusicPause() {
        showPauseView()
    }

    fun setMusicStart() {
        showPlayView()
    }

    override fun initView() {
        val container = LayoutInflater.from(context).inflate(R.layout.layoutk_music_indicator, this)
        _imgViewIndicator = container.findViewById(R.id.layoutk_music_indicator_indicator)
        _viewPagerDisc = container.findViewById(R.id.layoutk_music_indicator_page)
        _viewPagerDisc.apply { overScrollMode = View.OVER_SCROLL_NEVER }
        _musicPagerAdapter = MusicPagerAdapter(context, _imgUrls)
        _viewPagerDisc.adapter = _musicPagerAdapter
        _viewPagerDisc.addOnPageChangeListener(_onPageChangeListener)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        initView()
    }

    private fun showLoadView(index: Int, isSmooth: Boolean) {
        if (index in _imgUrls.indices)
            _viewPagerDisc.setCurrentItem(index, isSmooth)
    }

    private fun showPlayView() {
        val anim: Animator = _musicPagerAdapter.getAnim(_viewPagerDisc.currentItem)
        if (anim.isPaused) anim.resume() else anim.start()
    }

    private fun showPauseView() {
        val anim: Animator = _musicPagerAdapter.getAnim(_viewPagerDisc.currentItem)
        anim.pause()
    }
}