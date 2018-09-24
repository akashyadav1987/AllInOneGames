package game.trending.com.allinonegame.puzzlegames;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import game.trending.com.allinonegame.R;
import game.trending.com.allinonegame.racinggames.CommonFragment;


/**
 * Created by ashish on 07/10/17.
 */

public class WebViewFragment extends CommonFragment {
    String url;
    ProgressBar progressBar;
    WebView webView;
       @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.webview_fragment, null);

       // screenTitle = "WebView";
         webView = (WebView) view.findViewById(R.id.webview);
           progressBar=view.findViewById(R.id.pbHeaderProgress);
           webView.getSettings().setJavaScriptEnabled(true);
           
           Activity activity=getActivity();
           Bundle bundle=getArguments();
           String url=bundle.getString("url");

           //String url=getArguments().getString("url");
           screenTitle = getArguments().getString("title");
           webView.setWebChromeClient(new WebChromeClient() {
               public void onProgressChanged(WebView view, int progress) {
                   progressBar.setProgress(progress);
                   if (progress == 100) {
                       progressBar.setVisibility(View.GONE);

                   } else {
                       progressBar.setVisibility(View.VISIBLE);

                   }
               }
           });
           webView.loadUrl(url);
           //webView.loadUrl(url);

        return view;
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);

        }
    }

}
