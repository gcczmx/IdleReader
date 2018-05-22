package com.example.administrator.idlereader.Movie.Model;

import com.example.administrator.idlereader.Bean.MoviesBean;

/**
 * Created by Administrator on 2018/5/19.
 */

public interface IOnLoadListener {
    void success(MoviesBean moviesBean);
    void fail(Throwable throwable);
}
