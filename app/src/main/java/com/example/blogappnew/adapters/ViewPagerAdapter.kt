package com.example.blogappnew.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.example.blogappnew.R
import java.util.*


class ViewPagerAdapter(private val context: Context) : PagerAdapter() {

    private lateinit var inflater: LayoutInflater

    private val images = arrayOf(R.drawable.p1, R.drawable.p2, R.drawable.p3)
    private val titles = arrayOf("Learn", "Create", "Enjoy")
    private val descriptions = arrayOf(
        "simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard",
        "simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard",
        "simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard"
    )

    override fun getCount(): Int {
        return titles.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = inflater.inflate(R.layout.view_pager, container, false)
        initViews(v, position)
        Objects.requireNonNull(container).addView(v);
        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }

    private fun initViews(v: View, position: Int) {
        v.findViewById<ImageView>(R.id.imageView_pager).setImageResource(images[position])
        v.findViewById<TextView>(R.id.tv_title_viewpager).text = titles[position]
        v.findViewById<TextView>(R.id.tv_des_viewpager).text = descriptions[position]
    }
}