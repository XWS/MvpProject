package com.zhaoh.mvp.test.test1.presenter;

/**
 * Created by 19208 on 2017/6/14.
 */

public interface ITestPresenter {

    void clear();

    void doLogin(String name, String password);

    void setProgressBarVisiblity(int visiblity);
}
