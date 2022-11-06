package com.mozhimen.biz_ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.mozhimen.basick.basek.BaseKLayoutRelative

/**
 * @ClassName ViewKMusicIndicator
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/11/3 23:27
 * @Version 1.0
 */
class LayoutKMusicIndicator @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    BaseKLayoutRelative(context, attrs, defStyleAttr), ViewPager.OnPageChangeListener {

    private lateinit var _imgViewIndicator: ImageView
    private lateinit var _pagerDisc: ViewPager
    private lateinit var _musicPagerAdapter: MusicPagerAdapter

    init {
        initView()
    }

    override fun initView() {
        val container = LayoutInflater.from(context).inflate(R.layout.layoutk_music_indicator, this)
        _imgViewIndicator = container.findViewById(R.id.layoutk_music_indicator_indicator)
        _pagerDisc = container.findViewById(R.id.layoutk_music_indicator_page)
        _pagerDisc.apply { overScrollMode = View.OVER_SCROLL_NEVER }
        _musicPagerAdapter = MusicPagerAdapter()
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {

    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    class MusicPagerAdapter(
        private val _context: Context,
        private val _imgUrls: ArrayList<String>
    ) : PagerAdapter() {
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val rootView = LayoutInflater.from(_context).inflate(R.layout.layoutk_music_indicator_item, null)
            val imgView: ImageView = rootView.findViewById(R.id.layoutk_music_indicator_item_img)
            container.addView(rootView)

            return
        }

        override fun getCount(): Int {

        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
        }

    }
}