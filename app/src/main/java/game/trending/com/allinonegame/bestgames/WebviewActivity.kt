package game.trending.com.allinonegame.bestgames

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.ProgressBar
import game.trending.com.allinonegame.R

class WebviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        val webView = findViewById<WebView>(R.id.webview)
       val progressBar = findViewById<ProgressBar>(R.id.pbHeaderProgress)


    }
}
