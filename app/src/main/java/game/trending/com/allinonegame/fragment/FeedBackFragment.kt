package game.trending.com.allinonegame.fragment

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import game.trending.com.allinonegame.R
import game.trending.com.allinonegame.racinggames.CommonFragment
import kotlinx.android.synthetic.main.feedback_fragment.*

/**
 * Created by akashyadav on 9/22/18.
 */
class FeedBackFragment :CommonFragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        screenTitle = "Send FeedBack"
        return inflater.inflate(R.layout.feedback_fragment,null);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        send_feed_back.setOnClickListener {
            openMailIntent()
        }
    }

    /**This method is responsible for sending mail***/
    private fun openMailIntent() {
        try {
            val emailIntent = Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, "logicalapphouse@gmail.com");
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Game City Feed Back");
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hello my feed back is");

            emailIntent.setType("message/rfc822");

            try {
                startActivity(Intent.createChooser(emailIntent,
                        "Send email using..."));
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(getActivity(),
                        "No email clients installed.",
                        Toast.LENGTH_SHORT).show();
            }

        }catch (e:Exception){
            e.printStackTrace()
        }

    }

    override fun onRefresh() {
        super.onRefresh()
    }
}