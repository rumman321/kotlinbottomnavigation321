package com.calculator.bottomnavigatin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.calculator.bottomnavigatin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val home=HomeFragment()
        val person=BmiFragment()
        val setting=CalculatorFragment()
        setCurrentFragment(home)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> setCurrentFragment(home)
                R.id.bmi ->setCurrentFragment(person)
                R.id.setting ->setCurrentFragment(setting)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayout,fragment)
            commit()
        }

    }
}