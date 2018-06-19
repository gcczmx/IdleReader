package com.example.administrator.idlereader.News.Presenter;


import com.example.administrator.idlereader.Bean.NewsBean;
import com.example.administrator.idlereader.Http.Api;
import com.example.administrator.idlereader.News.FgNewsFragment;
import com.example.administrator.idlereader.News.Model.INewsModel;
import com.example.administrator.idlereader.News.Model.INewsLoadListener;
import com.example.administrator.idlereader.News.Model.NewsModel;
import com.example.administrator.idlereader.News.View.INewsView;

/**
 * Created by Administrator on 2018/5/19.
 */

public class NewsPresenter implements INewsPresenter,INewsLoadListener {

    private INewsModel iNewsModel;
    private INewsView iNewsView;

    public NewsPresenter(INewsView iNewsView) {
        this.iNewsView = iNewsView;
        this.iNewsModel =new NewsModel();
    }

    @Override
    public void loadNews(int type, int startPage) {
        if (startPage==0){
            iNewsView.showDialog();
        }

        switch (type){
            case FgNewsFragment.NEWS_TYPE_TOP:
                iNewsModel.loadNews("headline",startPage, Api.HEADLINE_ID,
                        this);
                break;
            case FgNewsFragment.NEWS_TYPE_NBA:
                iNewsModel.loadNews("list",startPage, Api.NBA_ID,
                        this);
                break;
            case FgNewsFragment.NEWS_TYPE_JOKES:
                iNewsModel.loadNews("list",startPage, Api.JOKE_ID,
                        this);
                break;
        }

    }
    @Override
    public void success(NewsBean newsBean) {
        iNewsView.hideDialog();
        if (newsBean!=null){
            iNewsView.showNews(newsBean);
        }

    }

    @Override
    public void fail(Throwable throwable) {
        iNewsView.hideDialog();
        iNewsView.showErrorMsg(throwable);
    }

    @Override
    public void loadMoreSuccess(NewsBean newsBean) {
        iNewsView.hideDialog();
        iNewsView.showMoreNews(newsBean);
    }
}
