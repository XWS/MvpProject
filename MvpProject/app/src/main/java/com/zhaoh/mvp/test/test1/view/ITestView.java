package com.zhaoh.mvp.test.test1.view;

/**
 * Created by 19208 on 2017/6/14.
 */

public interface ITestView {

    void clearTest();

    void onLoginResult(Boolean result, int code);

    void onSetProgressBarVisibility(int visibility);
}
