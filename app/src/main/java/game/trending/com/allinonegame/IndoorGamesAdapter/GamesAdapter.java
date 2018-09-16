package game.trending.com.allinonegame.IndoorGamesAdapter;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import game.trending.com.allinonegame.R;
import game.trending.com.allinonegame.kidsgame.BaseActivity;
import game.trending.com.allinonegame.puzzlegames.WebViewFragment;

/**
 * Created by akashyadav on 9/16/18.
 */

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.MyHolder> {
    private ArrayList<String> websites;
    private Context context;

    public GamesAdapter(Context context,ArrayList<String> websites){
        this.context  = context;
        this.websites =websites;
    }
    @NonNull
    @Override
    public GamesAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_game,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
       try{

           String url = websites.get(position);

           new LoadImage(holder.appCompatImageView,holder.game_name).execute(url);

           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   WebViewFragment webViewFragment=new WebViewFragment();
                   Bundle bundle=new Bundle();
                   bundle.putString("url",websites.get(position));
                   bundle.putString("title","Play Games");
                   webViewFragment.setArguments(bundle);
                   ((BaseActivity)context).addFragmentWithBackStack(webViewFragment,true);
               }
           });

       }catch (Exception e){
           e.printStackTrace();
       }
    }

    @Override
    public int getItemCount() {
        return websites.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        AppCompatImageView appCompatImageView;

        AppCompatTextView game_name;
        public MyHolder(View itemView) {
            super(itemView);
            appCompatImageView = itemView.findViewById(R.id.game_image);
            game_name  = itemView.findViewById(R.id.game_name);
        }
    }

    public class LoadImage extends AsyncTask<String,String,String > {
        String websiteTitle,websiteDescription,imgurl;

        private AppCompatImageView imageView;
        AppCompatTextView gameName;

        public LoadImage(AppCompatImageView imageView,AppCompatTextView gameName){
            this.imageView = imageView;
            this.gameName = gameName;
        }

        @Override
        protected String doInBackground(String... strings) {
            Document doc= null;
            String imageUrl = "";
            String UserAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36";
            try {
                // Connect to website
                Document document = Jsoup.connect(strings[0]).userAgent(UserAgent).get();
                // Get the html document title

                websiteTitle = document.title();
                Elements description = document.select("meta[name=description]");
                // Locate the content attribute
                websiteDescription = description.attr("content");
                String ogImage = null;
                Elements metaOgImage = document.select("meta[property=og:image]");
                if (metaOgImage != null) {
                    try {
                        imgurl = metaOgImage.first().attr("content");
                    }catch (Exception e){

                    }
                    System.out.println("src :<<<------>>> " + ogImage+"");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            return imageUrl;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                gameName.setText(websiteTitle+"");
                Glide.with(context).applyDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.default_game_image).error(R.drawable.default_game_image)).load(s).into(imageView);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
