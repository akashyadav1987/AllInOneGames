package game.trending.com.allinonegame.racinggames;

import android.location.Location;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import org.json.JSONObject;

import game.trending.com.allinonegame.kidsgame.BaseActivity;


/**
 * Created by admin on 5/12/2017.
 */
public class GlobalReferences {
    private static GlobalReferences globalReferences =null;
    public static GlobalReferences getInstance(){
        if(globalReferences==null){
            return globalReferences = new GlobalReferences();
        }
        return globalReferences;
    }
    public BaseActivity baseActivity;
    public CommonFragment mCommonFragment;
    public LinearLayout progressBar;
    public Toolbar toolbar;
    //public CheckForPermissions checkForPermissions;
    public JSONObject postParamUserProfile;
    public boolean isLocationAlertShown;
    public Location currentLocation;

}
