package com.flycuts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.flycuts.common.CommonFragment;
import com.flycuts.common.GlobalReferences;
import com.flycuts.db.Pref;
import com.flycuts.fragments.BarbersLocationMapFragment;
import com.flycuts.fragments.HistoryFragment;
import com.flycuts.fragments.LegalFragment;
import com.flycuts.fragments.MyScheduleFragment;
import com.flycuts.fragments.NavigationFragment;
import com.flycuts.fragments.OffersFragment;
import com.flycuts.fragments.SettingFragment;
import com.flycuts.fragments.WebViewFragment;
import com.flycuts.model.SelectedService;

import java.util.List;

/**
 * Created by akashyadav on 9/2/17.
 */

public class MotherActivity extends BaseActivity implements NavigationFragment.FragmentDrawerListener{


   public DrawerLayout drawer;
    private ArrayAdapter<String> mAdapter;
    Boolean buttonStateOpen;
    NavigationFragment navigationFragment;
    public String barber_id;
    public String url="https://washodry.com/about";
    List<SelectedService> service;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
           getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mother_activity);
        GlobalReferences.getInstance().baseActivity =this;
        GlobalReferences.getInstance().progressBar = (LinearLayout)findViewById(R.id.linlaHeaderProgress);
        GlobalReferences.getInstance().pref  = new Pref(this);
        drawer = findViewById(R.id.drawer_layout);
        navigationFragment = (NavigationFragment) getSupportFragmentManager().findFragmentById(R.id.fr_navdrawer);
        navigationFragment.setUp( GlobalReferences.getInstance().baseActivity, R.id.fr_navdrawer, drawer );
        navigationFragment.setDrawerListener(this);

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            public void onBackStackChanged() {
                Log.i("Tag", "back stack changed ");
                int backCount = getSupportFragmentManager().getBackStackEntryCount();

                if (backCount > 0) {
                    FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1);
                    String str = backStackEntry.getName();
                    Fragment fragment = getSupportFragmentManager().findFragmentByTag(str);
                    GlobalReferences.getInstance().mCommonFragment = (CommonFragment) fragment;
                    try {
                        ((CommonFragment) GlobalReferences.getInstance().mCommonFragment).onRefresh();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_container);
                    if (fragment != null) {
                        GlobalReferences.getInstance().mCommonFragment = (CommonFragment) fragment;
                        try {
                            ((CommonFragment) GlobalReferences.getInstance().mCommonFragment).onRefresh();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Bundle bundle=getIntent().getBundleExtra("data");
        if(bundle!=null) {
            String identifier = bundle.getString("identifier");
            if (identifier != null && identifier.equals("Notification")) {
                MyScheduleFragment myScheduleFragment=new MyScheduleFragment();
                myScheduleFragment.setArguments(bundle);
               // HistoryFragment historyFragment=new HistoryFragment();

                addFragmentWithBackStack(myScheduleFragment, true);
            }else{
                addFragmentWithBackStack(new BarbersLocationMapFragment(), true);
            }
        }else{
            addFragmentWithBackStack(new BarbersLocationMapFragment(), true);

            Log.e("tag", "onCreate: barber.flycuts.com.flycutsbarber.fragment call" );

        }




    }




    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        } else {
            try {
                if (GlobalReferences.getInstance().progressBar.getVisibility() == View.VISIBLE) {
                    GlobalReferences.getInstance().progressBar.setVisibility(View.GONE);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            super.onBackPressed();
        }
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {

        onSectionAttached(position);

    }


    public void onSectionAttached(int number) {


        switch (number) {
            case 0:
                addFragmentWithBackStack(new BarbersLocationMapFragment(),true);
                break;
            case 1:
                addFragmentWithBackStack(new HistoryFragment(),true);
                break;
            case 4:
                addFragmentWithBackStack(new LegalFragment(),true);
                break;
            case 3:
                WebViewFragment webViewFragment=new WebViewFragment();
                Bundle bundle=new Bundle();
                bundle.putString("url","http://pickyourlaundry.com/flycuts/webapp/frontend/web/barber/about-us");
                bundle.putString("title","About Us");
                webViewFragment.setArguments(bundle);
                GlobalReferences.getInstance().baseActivity.addFragmentWithBackStack(webViewFragment,true);
                break;
            case 2:
                OffersFragment offersFragment=new OffersFragment();
                GlobalReferences.getInstance().baseActivity.addFragmentWithBackStack(offersFragment,true);
                break;
            case 5:
                GlobalReferences.getInstance().baseActivity.addFragmentWithBackStack(new SettingFragment(),true);
                break;



        }

    }
    public void setList(List<SelectedService> list){
        this.service=list;
    }
    public List<SelectedService>getService(){
        return service;
    }
}
