package game.trending.com.allinonegame.bestgames;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import game.trending.com.allinonegame.R;
import game.trending.com.allinonegame.kidsgame.BaseActivity;
import game.trending.com.allinonegame.puzzlegames.WebViewFragment;
import game.trending.com.allinonegame.racinggames.CommonFragment;

/**
 * Created by akashyadav on 9/16/18.
 */

public class AwesomeGameListFragment extends CommonFragment implements View.OnClickListener
{
    private RecyclerView game_list;
    private ArrayList<String> gamesUrl = null;
    
    CardView custom_tetris,hextris,two_four_eight,ohh1,pappu_pakia,spashal,coil,the_pond,pop_win,
            sudoku,maze_3d,the_house,open_lara,elemental_one;
    
   // http://orb.enclavegames.com/
    //https://tetris-90067.firebaseapp.com
    //http://pacman.platzh1rsch.ch/
    //https://sigill.github.io/dontyoufillit/play.html
    //http://ellisonleao.github.io/clumsy-bird/
    //http://cykod.github.io/AlienInvasion/
    //https://ballandwall.com/
    //https://shapex.org/
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.temp_layout,null);
        custom_tetris=view.findViewById(R.id.cyber_orb);
        hextris=view.findViewById(R.id.tetris);
        two_four_eight=view.findViewById(R.id.two_four_eight);
        ohh1=view.findViewById(R.id.pacman);
        pappu_pakia=view.findViewById(R.id.dont_you);
        spashal=view.findViewById(R.id.spashal);
        coil=view.findViewById(R.id.coil);
        the_pond=view.findViewById(R.id.pond);
        pop_win=view.findViewById(R.id.pop_win);
        sudoku=view.findViewById(R.id.sudoku);
        maze_3d=view.findViewById(R.id.maze);
        the_house=view.findViewById(R.id.the_house);
        open_lara=view.findViewById(R.id.open_lara);
        elemental_one=view.findViewById(R.id.clumsy_bird);
        
        screenTitle = "Game City";
        
        
        custom_tetris.setOnClickListener(this);
        hextris.setOnClickListener(this);
        two_four_eight.setOnClickListener(this);
        ohh1.setOnClickListener(this);
        pappu_pakia.setOnClickListener(this);
        spashal.setOnClickListener(this);
        coil.setOnClickListener(this);
        the_pond.setOnClickListener(this);
        pop_win.setOnClickListener(this);
        sudoku.setOnClickListener(this);
        maze_3d.setOnClickListener(this);
        the_house.setOnClickListener(this);
        open_lara.setOnClickListener(this);
        elemental_one.setOnClickListener(this);
        
        
        

//        game_list = view.findViewById(R.id.game_list);
//        game_list.addItemDecoration(new SpacesItemDecoration(8));
//        /**Initialize url*/
//        gamesUrl = new ArrayList<>();
//        gamesUrl.add("http://ondras.github.io/custom-tetris/");
//        gamesUrl.add("http://hextris.io/");
//        gamesUrl.add("https://gamejolt.com/games/beatrix/27454");
//        gamesUrl.add("http://gabrielecirulli.github.io/2048/");
//        gamesUrl.add("http://0hh1.com/");
//        gamesUrl.add("http://khele.in/pappu-pakia/");
//        gamesUrl.add("http://mrrar.github.io/spashal/");
//        gamesUrl.add("https://lab.hakim.se/coil/");
//        gamesUrl.add("http://play.bci.im/nedetlesmaki/");
//        gamesUrl.add("https://thepond.zolmeister.com/");
//        gamesUrl.add("http://dart-lang.github.io/sample-pop_pop_win/");
//        gamesUrl.add("http://baruchel.insomnia247.nl/sudoku-js/sudoku.html");
//        gamesUrl.add("http://demonixis.github.io/Maze3D/");
//        gamesUrl.add("https://the-house.arturkot.pl/");
//        gamesUrl.add("http://xproger.info/projects/OpenLara/");
//        gamesUrl.add("http://voithos.io/elemental-one/");
//
//
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
//        game_list.setLayoutManager(linearLayoutManager);
//
//        GamesAdapter gamesAdapter = new GamesAdapter(getActivity(),gamesUrl);
//        game_list.setAdapter(gamesAdapter);

        return view;

    }
    
    @Override
    public void onClick(View v) {
        
        
        switch (v.getId()){
            case R.id.cyber_orb:
                openUrl("http://orb.enclavegames.com/","Cyber orb");
            break;
            
            case R.id.tetris:
                openUrl("https://tetris-90067.firebaseapp.com","Tetris");
                break;
            case R.id.two_four_eight:
                openUrl("http://gabrielecirulli.github.io/2048/","Two Four Eight");
                break;
            case R.id.pacman:
                openUrl("http://pacman.platzh1rsch.ch/","Pacman");
                break;
            case R.id.dont_you:
                openUrl("https://sigill.github.io/dontyoufillit/play.html","Dont You");
                break;
            case R.id.spashal:
                openUrl("http://mrrar.github.io/spashal/","Spashal");
                break;
            case R.id.coil:
                openUrl("https://lab.hakim.se/coil/","Coil");
                break;
            case R.id.pond:
                openUrl("https://thepond.zolmeister.com/","Pond");
                break;
            case R.id.pop_win:
                openUrl("http://dart-lang.github.io/sample-pop_pop_win/","Pop Win");
                break;
            case R.id.sudoku:
                openUrl("http://baruchel.insomnia247.nl/sudoku-js/sudoku.html","Sudoku");
                break;
            case R.id.maze:
                openUrl("http://demonixis.github.io/Maze3D/","Maze");
                break;
            case R.id.the_house:
                openUrl("https://the-house.arturkot.pl/","The House");
                break;
            case R.id.open_lara:
                openUrl("http://xproger.info/projects/OpenLara/","Open Lara");
                break;
            case R.id.clumsy_bird:
                openUrl("http://ellisonleao.github.io/clumsy-bird/","Clumsy Bird");
                break;
        }
        
    }
    
    
    private void openUrl(String url,String title){
        WebViewFragment webViewFragment=new WebViewFragment();
        Bundle bundle=new Bundle();
        bundle.putString("url",url);
        bundle.putString("title",title);
        webViewFragment.setArguments(bundle);
        if (((BaseActivity)getActivity()) != null) {
            ((BaseActivity)getActivity()).addFragmentWithBackStack(webViewFragment,true);
        }

    }

    @Override
    public void onRefresh() {
        super.onRefresh();
    }
}
