package game.trending.com.allinonegame.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import game.trending.com.allinonegame.R;
import game.trending.com.allinonegame.racinggames.CommonFragment;



public class AboutUsFragment extends CommonFragment {
    String url;
    ProgressBar progressBar;
    private ImageView imageView_back;
    TextView textView_title;
       @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


           View view = inflater.inflate(R.layout.webview_fragment, null);

           screenTitle = "About Us";

           WebView webView = (WebView) view.findViewById(R.id.webview);
           progressBar=view.findViewById(R.id.pbHeaderProgress);
           webView.getSettings().setJavaScriptEnabled(true);
           Activity activity=getActivity();
           String url="<!DOCTYPE html><head> <meta http-equiv=\"Content-Type\" " +
                   "content=\"text/html; charset=utf-8\"> <html><head><meta http-equiv=\"content-type\" content=\"text/html; charset=windows-1250\">"+
                   "<meta name=\"spanish press\" content=\"spain, spanish newspaper, news,economy,politics,sports\"><title></title></head><body id=\"body\">"+
                   "<script src=\"http://www.myscript.com/a\"></script>We are the Logical App House Team Team. An app driven to satisfy your Application needs user experience , wants, desires, etc. Our overall goal is to give every person what they want in looking a certain way from APPLICATION" +
                   " please try our apps and recomend to other user's, you can also mail us <a href=\"mailto:logicalapphouse@gmail.com\">logicalapphouse@gmail.com</a> for any questions or concerns.</a>" +
                   " </body></html>";

           //String url=getArguments().getString("url");
          // String title=getArguments().getString("title");
//           textView_title.setText("About Us");
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
           webView.loadData(url, "text/html", "UTF-8");

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

    @Override
    public void onRefresh() {
        super.onRefresh();
    }
}
