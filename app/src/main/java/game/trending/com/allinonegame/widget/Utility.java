package game.trending.com.allinonegame.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import game.trending.com.allinonegame.racinggames.GlobalReferences;

import static android.content.ContentValues.TAG;


/**
 * Created by admin on 5/6/2017.
 */
public class Utility {
    public static boolean isNetworkAvailable(Activity activity) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) GlobalReferences.getInstance().baseActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
    public static synchronized void showNoInternetConnectionToast(){
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static synchronized void showToastMsg(String msg){
        try{
            Toast.makeText(GlobalReferences.getInstance().baseActivity,
                   msg, Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String getBase64FromBitmap(final Bitmap bitmap) {
        String encodedFormImage = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 90,
                    byteArrayOutputStream);
            byte[] uploadBitmap = byteArrayOutputStream.toByteArray();
            encodedFormImage = Base64.encodeToString(uploadBitmap,
                    Base64.DEFAULT);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return encodedFormImage;
    }
    public static Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();
        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 0) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, 1200, 628, true);
    }

    //------- For Profile Module -------//
    public static Bitmap getResizedBitmap(String imageDecodeString) {
        Bitmap bitmap = null;
        try {
            if (imageDecodeString == null) {
                throw new NullPointerException();
            } else {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 2;
                options.inPurgeable = Boolean.TRUE;
                bitmap = BitmapFactory.decodeFile(imageDecodeString, options);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;

    }
    public static Typeface getFontPoppins_Regular() {
        Typeface typeface = Typeface.createFromAsset(GlobalReferences.getInstance().baseActivity.getAssets(), "Poppins-Regular.ttf");
        return typeface;
    }
    public static Typeface getFontsNovaRegular() {
        Typeface typeface = Typeface.createFromAsset(GlobalReferences.getInstance().baseActivity.getAssets(), "Proxima Nova Regular.otf");
        return typeface;
    }
    public static Typeface getFontsNovaLight() {
        Typeface typeface = Typeface.createFromAsset(GlobalReferences.getInstance().baseActivity.getAssets(), "Proxima Nova Light.otf");
        return typeface;
    }
    public static Typeface getFontsNovaSemiBold() {
        Typeface typeface = Typeface.createFromAsset(GlobalReferences.getInstance().baseActivity.getAssets(), "Proxima Nova Semibold.otf");
        return typeface;
    }
    public static Typeface getFontsNovaBold() {
        Typeface typeface = Typeface.createFromAsset(GlobalReferences.getInstance().baseActivity.getAssets(), "Proxima Nova Bold.otf");
        return typeface;
    }

    public static Typeface getFontRobotoMedium() {
        Typeface typeface = Typeface.createFromAsset(GlobalReferences.getInstance().baseActivity.getAssets(), "Roboto-Medium.ttf");
        return typeface;
    }

    public static Typeface getFontRobotoRegular() {
        Typeface typeface = Typeface.createFromAsset(GlobalReferences.getInstance().baseActivity.getAssets(), "Roboto-Regular.ttf");
        return typeface;
    }
    public static Typeface getFontNovaItalic() {
        Typeface typeface = Typeface.createFromAsset(GlobalReferences.getInstance().baseActivity.getAssets(), "Proxima-Nova-Regular-Italic.otf");
        return typeface;
    }

    public static Typeface getFontRobotoBoldr() {
        Typeface typeface = Typeface.createFromAsset(GlobalReferences.getInstance().baseActivity.getAssets(), "Roboto-Bold.ttf");
        return typeface;
    }
    public static Typeface getFontPoppinsLight() {
        Typeface typeface = Typeface.createFromAsset(GlobalReferences.getInstance().baseActivity.getAssets(), "Poppins-Light.ttf");
        return typeface;
    }
    public static Typeface getFontCoolventica() {
        Typeface typeface = Typeface.createFromAsset(GlobalReferences.getInstance().baseActivity.getAssets(), "coolvetica.ttf");
        return typeface;
    }
    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static String getDate(long milliSeconds, String dateFormat) {
        // Create a DateFormatter object for displaying date in specified format.
        String formatDate;
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy hh:mm a");
        formatter.setTimeZone(TimeZone.getDefault());

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);

        SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat); //this format changeable
        dateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        formatDate  = dateFormatter.format(milliSeconds);
        Log.e(TAG, "getDate: "+formatDate );
        return formatDate;
    }
}

