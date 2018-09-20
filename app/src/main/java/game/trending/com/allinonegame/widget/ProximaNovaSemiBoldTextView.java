package game.trending.com.allinonegame.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by akashyadav on 9/20/18.
 */

public class ProximaNovaSemiBoldTextView extends AppCompatTextView {
    public ProximaNovaSemiBoldTextView(Context context) {
        super(context);
        setTypeface(Utility.getFontsNovaSemiBold());
    }

    public ProximaNovaSemiBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(Utility.getFontsNovaSemiBold());

    }

    public ProximaNovaSemiBoldTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(Utility.getFontsNovaSemiBold());

    }
}
