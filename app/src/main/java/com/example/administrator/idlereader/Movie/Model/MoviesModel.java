package com.example.administrator.idlereader.Movie.Model;

import android.util.Log;

import com.example.administrator.idlereader.Bean.MoviesBean;
import com.example.administrator.idlereader.Http.Api;
import com.example.administrator.idlereader.Http.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/19.
 */

public class MoviesModel implements IMoviesModel {

    @Override
    public void loadMovies( String total, final IOnLoadListener iOnLoadListener) {
        RetrofitHelper retrofitHelper= new RetrofitHelper(Api.MOVIE_HOST);
        retrofitHelper.getMovies(total)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<MoviesBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iOnLoadListener.fail(e);
                    }

                    @Override
                    public void onNext(MoviesBean moviesBean) {
                        iOnLoadListener.success(moviesBean);
                    }
                });
    }

}
