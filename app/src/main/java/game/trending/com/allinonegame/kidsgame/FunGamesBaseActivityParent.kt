package game.trending.com.allinonegame.kidsgame

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.Log

import game.trending.com.allinonegame.R
import game.trending.com.allinonegame.racinggames.CommonFragment
import game.trending.com.allinonegame.racinggames.GlobalReferences


/**
 * Created by Akashyadav on 11/02/17.
 */

open class FunGamesBaseActivityParent : AppCompatActivity() {
    protected lateinit var fragmentManager: FragmentManager
    protected var fragmentTransaction: FragmentTransaction? = null
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        //fragmentManager =getSupportFragmentManager();

    }

    open fun addFragmentWithBackStack(fragment: Fragment, addToBackStack: Boolean) {
        try {
            GlobalReferences.getInstance().mCommonFragment = fragment as CommonFragment
            val backStateName = fragment.javaClass.name
            val manager = supportFragmentManager
            if (manager != null) {
                //                runOnUiThread(new Runnable() {
                //                    @Override
                //                    public void run() {
                //
                //                        fragmentManager =getSupportFragmentManager();
                //                        Log.e("fragmentManager",fragmentManager+"");
                //                    }
                //                });
                Log.e("manager.findFra)", manager.findFragmentByTag(backStateName).toString() + "")

                val fragment1 = manager.findFragmentByTag(backStateName)
                //            if(fragment1 instanceof PagerFragment) {
                //                Suggestions suggestions = barber.flycuts.com.flycutsbarber.fragment.getArguments().getParcelable("near_by");
                //                fragment1.getArguments().putParcelable("near_by", suggestions);
                //            }

                val fragmentPopped = manager.popBackStackImmediate(backStateName, 0)

                if (!fragmentPopped && manager.findFragmentByTag(backStateName) == null) { //barber.flycuts.com.flycutsbarber.fragment not in back stack, create it.

                    val ft = manager.beginTransaction()
                    //  ft.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left);
                    ft.replace(R.id.frame_container, fragment, backStateName)

                    // ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    if (addToBackStack)
                        ft.addToBackStack(backStateName)
                    ft.commitAllowingStateLoss()
                } else {
                    // Fragment fragment1 = manager.findFragmentByTag(fragmentTag);
                    Log.e("alreadyyy", "aleadyyy")
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onResume() {
        super.onResume()
        fragmentManager = supportFragmentManager
        Log.e("manager", supportFragmentManager.toString() + "")
    }

    open fun replaceFragmentWithAnimation(fragment: Fragment, tag: String) {
        val currentFragment = GlobalReferences.getInstance().mCommonFragment as Fragment
        val fragTransaction = supportFragmentManager.beginTransaction()
        //fragTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.enter_from_right, R.anim.enter_from_right,R.anim.enter_from_right);
        fragTransaction.detach(currentFragment)
        fragTransaction.attach(currentFragment)
        fragTransaction.commitAllowingStateLoss()
    }
}
