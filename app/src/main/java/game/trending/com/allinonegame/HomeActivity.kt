package game.trending.com.allinonegame

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import com.special.ResideMenu.ResideMenu
import com.special.ResideMenu.ResideMenuItem
import game.trending.com.allinonegame.bestgames.AwesomeGameListFragment
import game.trending.com.allinonegame.kidsgame.BaseActivity
import game.trending.com.allinonegame.racinggames.GlobalReferences
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*





class HomeActivity : BaseActivity(), ResideMenu.OnMenuListener {


    override fun openMenu() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun closeMenu() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var resideMenu:ResideMenu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
        GlobalReferences.getInstance().baseActivity = this;
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        // attach to current activity;
        resideMenu = ResideMenu(this)
        resideMenu.setBackground(R.drawable.banner1)
        resideMenu.attachToActivity(this)

        // create menu items;
        val titles = arrayOf("Home", "Profile", "Calendar", "Settings")
        val icon = intArrayOf(R.drawable.ic_menu_camera, R.drawable.ic_menu_gallery, R.drawable.ic_menu_send, R.drawable.ic_menu_share)

        for (i in titles.indices) {
            val item = ResideMenuItem(this, icon[i], titles[i])
           // item.setOnClickListener(this)
            resideMenu.addMenuItem(item, ResideMenu.DIRECTION_LEFT) // or  ResideMenu.DIRECTION_RIGHT
        }

//        val toggle = ActionBarDrawerToggle(
//                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
//        drawer_layout.addDrawerListener(toggle)
//        toggle.syncState()
//
//        nav_view.setNavigationItemSelectedListener(this)
//        nav_view.setCheckedItem(0)
        addFragmentWithBackStack(AwesomeGameListFragment(),true)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }



    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        return resideMenu.dispatchTouchEvent(ev)
    }
}
