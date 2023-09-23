package com.example.myfamilysafety

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show()

        val bootombar=findViewById<BottomNavigationView>(R.id.bottom_bar)
        bootombar.setOnItemSelectedListener { menuItem->
            if (menuItem.itemId==R.id.nav_Guard) {
                inflateFragment()
            }

            else if(menuItem.itemId==R.id.nav_home){
                inflateHomeFragment()
            }

            else if(menuItem.itemId==R.id.nav_dashboard){
                inflateDashBoardFragment()
            }

            else if(menuItem.itemId==R.id.nav_profile){
                inflateProfileFragment()
            }
            true
        }
    }

    private fun inflateProfileFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, ProfileFragment.newInstance())
        transaction.commit()
    }

    private fun inflateDashBoardFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, DashBoardFragment.newInstance())
        transaction.commit()
    }

    private fun inflateHomeFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, HomeFragment.newInstance())
        transaction.commit()
    }

    private fun inflateFragment() {
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,GuardFragment.newInstance())
        transaction.commit()
    }
}


