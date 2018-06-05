package com.example.administrator.idlereader.Movie.Presenter;


import com.example.administrator.idlereader.Bean.MoviesBean;
import com.example.administrator.idlereader.Movie.Model.IMoviesModel;
import com.example.administrator.idlereader.Movie.Model.IOnLoadListener;
import com.example.administrator.idlereader.Movie.Model.MoviesModel;
import com.example.administrator.idlereader.Movie.View.IMoviesView;

/**
 * Created by Administrator on 2018/5/19.
 */

public class MoviesPresenter implements IMoviesPresenter,IOnLoadListener {

    private IMoviesModel iMoviesModel;
    private IMoviesView iMoviesView;

    public MoviesPresenter(IMoviesView iMoviesView) {
        this.iMoviesView = iMoviesView;
        this.iMoviesModel =new MoviesModel();
    }


    @Override
    public void success(MoviesBean moviesBean) {
        iMoviesView.hideDialog();
        iMoviesView.showNews(moviesBean);
    }

    @Override
    public void fail(Throwable throwable) {
        iMoviesView.hideDialog();
        iMoviesView.showErrorMsg(throwable);
    }


    @Override
    public void loadMovies(String total) {
        iMoviesView.showDialog();
        iMoviesModel.loadMovies(total,this);
    }
}
