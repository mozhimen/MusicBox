package com.mozhimen.biz_ui.music.helpers

import android.animation.ObjectAnimator
import android.content.Context
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.mozhimen.basick.extsk.view.loadImageCircle
import com.mozhimen.biz_ui.R

/**
 * @ClassName MusicAdapter
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/11/7 22:14
 * @Version 1.0
 */
class MusicPagerAdapter(
    private val _context: Context,
    private val _imgUrls: ArrayList<String>
) : PagerAdapter() {
    private val _anims = SparseArray<ObjectAnimator>()

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val rootView = LayoutInflater.from(_context).inflate(R.layout.layoutk_music_indicator_item, null)
        val imgView: ImageView = rootView.findViewById(R.id.layoutk_music_indicator_item_img)
        imgView.loadImageCircle(_imgUrls[position])
        container.addView(rootView)
        _anims.put(position, createAnim(rootView))
        return rootView
    }

    override fun getCount(): Int {
        return _imgUrls.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    private fun createAnim(view: View): ObjectAnimator? {
        view.rotation = 0f
        val animator = ObjectAnimator.ofFloat(view, View.ROTATION.name, 0f, 360f)
        animator.duration = 10000
        animator.interpolator = LinearInterpolator()
        animator.repeatCount = -1
        animator.start()
        return animator
    }

    fun getAnim(pos: Int): ObjectAnimator {
        return _anims.get(pos)
    }

}