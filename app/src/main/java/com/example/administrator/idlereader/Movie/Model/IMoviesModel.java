package com.example.administrator.idlereader.Movie.Model;

/**
 * Created by Administrator on 2018/5/19.
 */

public interface IMoviesModel {
    void loadMovies(String total, IOnLoadListener iOnLoadListener);
}
