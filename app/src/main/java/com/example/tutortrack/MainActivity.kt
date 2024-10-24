package com.example.tutortrack

import android.graphics.Typeface
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.tutortrack.fragment.PostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var headerPosts: TextView
    private lateinit var headerLibrary: TextView
    private lateinit var headerCoaching: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)

        headerPosts = findViewById(R.id.header_posts)
        headerLibrary = findViewById(R.id.header_library)
        headerCoaching = findViewById(R.id.header_coaching)

        // Set click listeners for header navigation items
        headerPosts.setOnClickListener { selectFragment(PostFragment(), headerPosts) }
        headerLibrary.setOnClickListener { selectFragment(LibraryFragment(), headerLibrary) }
        headerCoaching.setOnClickListener { selectFragment(CoachingFragment(), headerCoaching) }

        // Load default fragment
        if (savedInstanceState == null) {
            selectFragment(PostFragment(), headerPosts) // Set PostFragment as default
        }

        // Set up the navigation drawer
        setupNavigationDrawer()

        // Set up the bottom navigation
        setupBottomNavigation()

        // Floating Action Button click listener
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            // Handle FAB click
        }
    }

    private fun setupNavigationDrawer() {
        val navigationView: NavigationView = findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_settings -> {
                    // Handle settings click
                    true
                }
                R.id.nav_about -> {
                    // Handle about click
                    true
                }
                else -> false
            }
        }

        // Set up toolbar for opening the navigation drawer
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    private fun setupBottomNavigation() {
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Handle home click
                    true
                }
                R.id.nav_message -> {
                    // Handle message click
                    true
                }
                else -> false
            }
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun selectFragment(fragment: Fragment, selectedTextView: TextView) {
        // Reset styles for header items
        resetHeaderStyles()

        // Set selected styles for the clicked item
        selectedTextView.setTypeface(null, Typeface.BOLD)
        selectedTextView.paint.isUnderlineText = true

        // Load the selected fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_content, fragment)
            .commit()
    }

    private fun resetHeaderStyles() {
        // Reset styles for all header items
        headerPosts.setTypeface(null, Typeface.NORMAL)
        headerPosts.paint.isUnderlineText = false

        headerLibrary.setTypeface(null, Typeface.NORMAL)
        headerLibrary.paint.isUnderlineText = false

        headerCoaching.setTypeface(null, Typeface.NORMAL)
        headerCoaching.paint.isUnderlineText = false
    }
}
