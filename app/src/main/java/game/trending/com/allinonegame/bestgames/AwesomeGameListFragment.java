package game.trending.com.allinonegame.bestgames;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import game.trending.com.allinonegame.IndoorGamesAdapter.GamesAdapter;
import game.trending.com.allinonegame.R;
import game.trending.com.allinonegame.racinggames.CommonFragment;
import game.trending.com.allinonegame.widget.SpacesItemDecoration;

/**
 * Created by akashyadav on 9/16/18.
 */

public class AwesomeGameListFragment extends CommonFragment {
    private RecyclerView game_list;
    private ArrayList<String> gamesUrl = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.game_list,null);

        game_list = view.findViewById(R.id.game_list);
        game_list.addItemDecoration(new SpacesItemDecoration(8));
        /**Initialize url*/
        gamesUrl = new ArrayList<>();
        gamesUrl.add("http://ondras.github.io/custom-tetris/");
        gamesUrl.add("http://hextris.io/");
        gamesUrl.add("https://gamejolt.com/games/beatrix/27454");
        gamesUrl.add("http://gabrielecirulli.github.io/2048/");
        gamesUrl.add("http://0hh1.com/");
        gamesUrl.add("http://khele.in/pappu-pakia/");
        gamesUrl.add("http://mrrar.github.io/spashal/");
        gamesUrl.add("https://lab.hakim.se/coil/");
        gamesUrl.add("http://play.bci.im/nedetlesmaki/");
        gamesUrl.add("https://thepond.zolmeister.com/");
        gamesUrl.add("http://dart-lang.github.io/sample-pop_pop_win/");
        gamesUrl.add("http://baruchel.insomnia247.nl/sudoku-js/sudoku.html");
        gamesUrl.add("http://demonixis.github.io/Maze3D/");
        gamesUrl.add("https://the-house.arturkot.pl/");
        gamesUrl.add("http://xproger.info/projects/OpenLara/");
        gamesUrl.add("http://voithos.io/elemental-one/");
       


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        game_list.setLayoutManager(linearLayoutManager);

        GamesAdapter gamesAdapter = new GamesAdapter(getActivity(),gamesUrl);
        game_list.setAdapter(gamesAdapter);

        return view;

    }
}
