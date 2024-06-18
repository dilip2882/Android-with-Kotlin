package com.dilip.viewpager2example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.dilip.viewpager2example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val images = listOf(
            R.drawable.dc,
            R.drawable.gt,
            R.drawable.mi,
            R.drawable.csk,
            R.drawable.kkr
        )

        val adapter = ViewPagerAdapter(images)
        binding.viewPager.adapter = adapter

        binding.viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

        binding.viewPager.beginFakeDrag()
        binding.viewPager.fakeDragBy(-10f)
        binding.viewPager.endFakeDrag()
    }
}