package com.example.administrator.idlereader.Video.Model;


import com.example.administrator.idlereader.Bean.VideoUrlBean;
import com.example.administrator.idlereader.Bean.TodayContentBean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/19.
 */

public interface IVideoLoadListener {
    void videoUrlSuccess(List<VideoUrlBean> videoUrlBeans, List<TodayContentBean> contentBeans);
    void fail(Throwable throwable);
}
