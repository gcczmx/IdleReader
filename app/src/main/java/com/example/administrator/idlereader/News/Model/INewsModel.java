package com.example.administrator.idlereader.News.Model;

/**
 * Created by Administrator on 2018/5/19.
 */

public interface INewsModel {
    void loadNews(String hostType,
                  int startPage,
                  String id,
                  INewsLoadListener iNewsLoadListener);
}
