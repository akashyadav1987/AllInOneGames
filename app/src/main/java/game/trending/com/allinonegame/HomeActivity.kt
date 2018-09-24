package game.trending.com.allinonegame

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.*
import com.special.ResideMenu.ResideMenu
import com.special.ResideMenu.ResideMenuItem
import game.trending.com.allinonegame.bestgames.AwesomeGameListFragment
import game.trending.com.allinonegame.fragment.AboutUsFragment
import game.trending.com.allinonegame.fragment.FeedBackFragment
import game.trending.com.allinonegame.kidsgame.BaseActivity
import game.trending.com.allinonegame.racinggames.CommonFragment
import game.trending.com.allinonegame.racinggames.GlobalReferences
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : BaseActivity(), ResideMenu.OnMenuListener, View.OnClickListener {

    private var gamesMenuItem: ResideMenuItem? = null
    private var feedBackMenuItem: ResideMenuItem? = null
    private var aboutUsMenuItem: ResideMenuItem? = null

    /***On click of items **/
    override fun onClick(view: View?) {
        if (view == gamesMenuItem) {
            changeFragment(AwesomeGameListFragment());
        } else if (view == feedBackMenuItem) {
            changeFragment(FeedBackFragment())
        } else if (view == aboutUsMenuItem) {
            changeFragment(AboutUsFragment())
        }
    }

    /*switching to fragment**/
    fun changeFragment(fragment: Fragment) {
        addFragmentWithBackStack(fragment, true)
        if(resideMenu.isOpened)
            resideMenu.closeMenu()
    }


    override fun openMenu() {
    }

    override fun closeMenu() {
    }

    private lateinit var resideMenu: ResideMenu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar)
        GlobalReferences.getInstance().baseActivity = this;
        GlobalReferences.getInstance().toolbar = toolbar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            if(Build.VERSION.SDK_INT>=23){
                window.statusBarColor = ResourcesCompat.getColor(resources,R.color.c_e3e3e4,null);
            }
        }
        // attach to current activity;
        resideMenu = ResideMenu(this)
        resideMenu.setBackground(R.color.white)
        resideMenu.attachToActivity(this)
        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT)

        gamesMenuItem = ResideMenuItem(this, R.drawable.games, "Games")
        feedBackMenuItem = ResideMenuItem(this, R.drawable.ic_feedback, "FeedBack")
        aboutUsMenuItem = ResideMenuItem(this, R.drawable.ic_about_us, "About Us")

        gamesMenuItem?.setOnClickListener(this)
        feedBackMenuItem?.setOnClickListener(this)
        aboutUsMenuItem?.setOnClickListener(this)

        resideMenu.addMenuItem(gamesMenuItem, ResideMenu.DIRECTION_LEFT) // or  ResideMenu.DIRECTION_RIGHT
        resideMenu.addMenuItem(feedBackMenuItem, ResideMenu.DIRECTION_LEFT) // or  ResideMenu.DIRECTION_RIGHT
        resideMenu.addMenuItem(aboutUsMenuItem, ResideMenu.DIRECTION_LEFT) // or  ResideMenu.DIRECTION_RIGHT


        val toggle = object : ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
            }

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
            }
        } // Drawer Toggle Object Made
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        toolbar.setNavigationOnClickListener {
            if (resideMenu.isOpened) {
                resideMenu.closeMenu()
            } else {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT)
            }
        }

            changeFragment(AwesomeGameListFragment());


        supportFragmentManager.addOnBackStackChangedListener {
            Log.i("Tag", "back stack changed ")
            val backCount = supportFragmentManager.backStackEntryCount

            if (backCount > 0) {
                val backStackEntry = supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1)
                val str = backStackEntry.name
                val fragment = supportFragmentManager.findFragmentByTag(str)
                GlobalReferences.getInstance().mCommonFragment = fragment as CommonFragment
                try {
                    (GlobalReferences.getInstance().mCommonFragment as CommonFragment).onRefresh()
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            } else {
                val fragment = supportFragmentManager.findFragmentById(R.id.frame_container)
                if (fragment != null) {
                    GlobalReferences.getInstance().mCommonFragment = fragment as CommonFragment
                    try {
                        (GlobalReferences.getInstance().mCommonFragment as CommonFragment).onRefresh()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                }
            }
        }

    }

    override fun onBackPressed() {
        if (resideMenu.isOpened()) {
            resideMenu.closeMenu()
        } else {
            if(supportFragmentManager.backStackEntryCount==1){
                finish()
            }else
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
