package com.example.administrator.idlereader.News.Model;


import com.example.administrator.idlereader.Bean.NewsBean;

/**
 * Created by Administrator on 2018/5/19.
 */

public interface IOnLoadListener {
    void success(NewsBean newsBean);
    void fail(String error);
}
