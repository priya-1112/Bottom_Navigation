package com.example.bottomnavigation_practice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bottomnavigation_practice.databinding.ActivityMainBinding
import com.example.bottomnavigation_practice.fragments.Home_Fragment
import com.example.bottomnavigation_practice.fragments.Notification_Fragment
import com.example.bottomnavigation_practice.fragments.Profile_Fragment
import com.example.bottomnavigation_practice.fragments.Setting_Fragment
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigation = binding.bottomNavigation
        bottomNavigation.add(
            CurvedBottomNavigation.Model(1, "Home", R.drawable.baseline_home_24)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(2,"Notification", R.drawable.baseline_notifications_24)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(3, "Setting", R.drawable.baseline_settings_24)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(4,"Profile", R.drawable.baseline_profile_24)
        )

        bottomNavigation.setOnClickMenuListener {
            when (it.id){
                1-> {
                    replaceFragment(Home_Fragment())

                }
                2-> {
                    replaceFragment(Notification_Fragment())
                }
                3-> {replaceFragment(Setting_Fragment())

                }
                4->{replaceFragment(Profile_Fragment())}
            }
        }

//        default Bottom Navigation
         replaceFragment(Home_Fragment())
        bottomNavigation.show(1)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .commit()
    }
}