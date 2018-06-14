package com.example.administrator.idlereader.News.View;


import com.example.administrator.idlereader.Bean.NewsBean;

/**
 * Created by Administrator on 2018/5/19.
 */

public interface INewsView {
    void showNews(NewsBean newsBean);
    void hideDialog();
    void showDialog();
    void showErrorMsg(Throwable throwable);
}
