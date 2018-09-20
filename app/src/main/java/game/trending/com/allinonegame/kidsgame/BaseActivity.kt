package game.trending.com.allinonegame.kidsgame

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import game.trending.com.allinonegame.R
import game.trending.com.allinonegame.racinggames.CommonFragment
import game.trending.com.allinonegame.racinggames.GlobalReferences

/**
 * Created by Akashyadav on 11/02/17.
 */

open class BaseActivity : FunGamesBaseActivityParent() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {

        super.onCreate(savedInstanceState, persistentState)
        //fragmentManager =getSupportFragmentManager();

    }



    override fun onPostResume() {
        super.onPostResume()
    }

    override fun addFragmentWithBackStack(fragment: Fragment, addToBackStack: Boolean) {
        try {
            GlobalReferences.getInstance().mCommonFragment = fragment as CommonFragment
            val backStateName = fragment.javaClass.name
            val manager = supportFragmentManager
            if (manager != null) {

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
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onResume() {
        super.onResume()
        onPostResume()
        fragmentManager = supportFragmentManager
        Log.e("manager", supportFragmentManager.toString() + "")
    }

    override fun replaceFragmentWithAnimation(fragment: android.support.v4.app.Fragment, tag: String) {
        val currentFragment = GlobalReferences.getInstance().mCommonFragment as Fragment
        val fragTransaction = supportFragmentManager.beginTransaction()
        // fragTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.enter_from_right, R.anim.enter_from_right,R.anim.enter_from_right);
        fragTransaction.detach(currentFragment)
        fragTransaction.attach(currentFragment)
        fragTransaction.commitAllowingStateLoss()
    }

//    companion object {
//
//        fun hideSoftKeyboard(activity: Activity?) {
//            if (activity != null) {
//                val inputManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//                if (activity.currentFocus != null && inputManager != null) {
//                    inputManager.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0)
//                    inputManager.hideSoftInputFromInputMethod(activity.currentFocus!!.windowToken, 0)
//                }
//            }
//        }
//
//        fun hideSoftKeyboard(view: View?) {
//            if (view != null) {
//                val inputManager = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//                inputManager?.hideSoftInputFromWindow(view.windowToken, 0)
//            }
//        }
//    }
}
