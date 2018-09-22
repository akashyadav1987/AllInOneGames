package game.trending.com.allinonegame.racinggames;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by admin on 5/12/2017.
 */
public class CommonFragment extends Fragment {
    public String screenTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        try {
            if((GlobalReferences.getInstance().toolbar!=null)) {
                GlobalReferences.getInstance().toolbar.setTitle(screenTitle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void onRefresh() {
        try{
            if((GlobalReferences.getInstance().toolbar!=null)) {
                GlobalReferences.getInstance().toolbar.setTitle(screenTitle);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
