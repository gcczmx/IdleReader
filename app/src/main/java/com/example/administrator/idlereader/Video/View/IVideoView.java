package com.example.administrator.idlereader.Video.View;

import com.example.administrator.idlereader.Bean.TodayContentBean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/19.
 */

public interface IVideoView {
    void showVideo(List<TodayContentBean> todayContentBeans, List<String> videoList);
    void hideDialog();
    void showDialog();
    void showErrorMsg(Throwable throwable);
}
