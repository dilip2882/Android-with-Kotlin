package com.dilip.bottomnavigationexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dilip.bottomnavigationexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        setFragment(firstFragment)

/*        binding.bottomNavigationView.setOnNavigationItemSelectedListener {   // depreciated
            when (it.itemId) {
                R.id.miHome -> setFragment(firstFragment)
                R.id.miMessages -> setFragment(secondFragment)
                R.id.miProfile -> setFragment(thirdFragment)
            }
            true
        }*/

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.miHome -> setFragment(firstFragment)
                R.id.miMessages -> setFragment(secondFragment)
                R.id.miProfile -> setFragment(thirdFragment)
            }
            true
        }

        binding.bottomNavigationView.getOrCreateBadge(R.id.miMessages).apply {
            number = 10
            isVisible = true
        }

    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }
}