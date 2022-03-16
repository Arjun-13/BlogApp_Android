package com.example.blogappnew

import android.R
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.blogappnew.adapters.ViewPagerAdapter
import com.example.blogappnew.databinding.ActivityOnBoardBinding


class OnBoardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardBinding
    private lateinit var pagerAdapter: ViewPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initviews()
    }

    private fun initviews() {
        pagerAdapter = ViewPagerAdapter(this)
        binding.viewPagerView.addOnPageChangeListener(listener)
        binding.viewPagerView.adapter = pagerAdapter
        addDots(0)

        binding.btnRight.setOnClickListener {
            if (binding.btnRight.text.toString() == "Next") {
                binding.viewPagerView.currentItem = binding.viewPagerView.currentItem + 1
            } else {
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
            }
        }

        binding.btnLeft.setOnClickListener {
            binding.viewPagerView.currentItem = binding.viewPagerView.currentItem + 2
        }
    }

    private val listener: OnPageChangeListener = object : OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            addDots(position)
            //ok now we need to change the text of Next button to Finish if we reached page 3
            //and hide Skip button if we are not in page 1
            if (position == 0) {
                binding.btnLeft.visibility = View.VISIBLE
                binding.btnLeft.isEnabled = true
                binding.btnRight.text = "Next"
            } else if (position == 1) {
                binding.btnLeft.visibility = View.GONE
                binding.btnLeft.isEnabled = false
                binding.btnRight.text = "Next"
            } else {
                binding.btnLeft.visibility = View.GONE
                binding.btnLeft.isEnabled = false
                binding.btnRight.text = "Finish"
            }
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }

    private fun addDots(position: Int) {
        binding.dotsLayout.removeAllViews()
        val dots = arrayOfNulls<TextView>(3)
        for (i in dots.indices) {
            dots[i] = TextView(this)
            //this html code creates dot
            dots[i]?.text = Html.fromHtml("&#8226")
            dots[i]?.textSize = 35F
            dots[i]?.setTextColor(ContextCompat.getColor(this,R.color.darker_gray))
            binding.dotsLayout.addView(dots[i])
        }
        // ok now lets change the selected dot color
        if (dots.size > 0) {
            dots[position]?.setTextColor(resources.getColor(R.color.black))
        }
    }
}