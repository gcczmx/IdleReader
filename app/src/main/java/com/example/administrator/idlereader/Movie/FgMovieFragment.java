package com.example.administrator.idlereader.Movie;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.idlereader.Bean.MoviesBean;
import com.example.administrator.idlereader.Movie.Presenter.MoviesPresenter;
import com.example.administrator.idlereader.Movie.View.IMoviesView;
import com.example.administrator.idlereader.R;


public class FgMovieFragment extends Fragment implements IMoviesView {

    private MoviesPresenter moviesPresenter;
    private RecyclerView rv_movie_on;
    private SwipeRefreshLayout srl_movie;
    private ItemMovieOnAdapter movieOnAdapter;
    private ItemMovieTop250Adapter movieTop250Adapter;
    private RecyclerView rv_movie_top250;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fg_movie, null);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        moviesPresenter = new MoviesPresenter(this);
        srl_movie = view.findViewById(R.id.srl_movie);
        rv_movie_on = view.findViewById(R.id.rv_movie_on);
        rv_movie_top250=view.findViewById(R.id.rv_movie_top250);
        movieOnAdapter = new ItemMovieOnAdapter(getActivity());
        movieTop250Adapter = new ItemMovieTop250Adapter(getActivity());
        srl_movie.setColorSchemeColors(Color.parseColor("#ffce3d3a"));
        moviesPresenter.loadMovies("in_theaters");
        moviesPresenter.loadMovies("top250");
        srl_movie.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                moviesPresenter.loadMovies("in_theaters");
                moviesPresenter.loadMovies("top250");
            }
        });
    }

    @Override
    public void showNews(MoviesBean moviesBean) {
        if (moviesBean.getTotal()==250){
            movieTop250Adapter.setData(moviesBean.getSubjects());
            rv_movie_top250.setLayoutManager(new LinearLayoutManager(getActivity(),
                    LinearLayoutManager.HORIZONTAL,false));
            rv_movie_top250.setHorizontalScrollBarEnabled(true);
            rv_movie_top250.setAdapter(movieTop250Adapter);
        }else {
            movieOnAdapter.setData(moviesBean.getSubjects());
            rv_movie_on.setLayoutManager(new LinearLayoutManager(getActivity()));
            rv_movie_on.setAdapter(movieOnAdapter);
        }
    }

    @Override
    public void hideDialog() {
        srl_movie.setRefreshing(false);
    }

    @Override
    public void showDialog() {
        srl_movie.setRefreshing(true);
    }

    @Override
    public void showErrorMsg(Throwable throwable) {
        Toast.makeText(getContext(), "加载出错:"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
