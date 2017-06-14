package com.zhaoh.mvp.test.test1.presenter;

import android.os.Handler;
import android.os.Looper;

import com.zhaoh.mvp.test.test1.model.IUser;
import com.zhaoh.mvp.test.test1.model.UserModel;
import com.zhaoh.mvp.test.test1.view.ITestView;

/**
 * Created by 19208 on 2017/6/14.
 */

public class TestPresenterCompl implements ITestPresenter {

    private IUser user;
    private ITestView testView;
    private Handler handler;

    public TestPresenterCompl(ITestView testView) {
        this.testView = testView;
        user = new UserModel("mvp", "mvp");
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void clear() {
        testView.clearTest();
    }

    @Override
    public void doLogin(String name, String password) {
        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(name, password);
        if (code != 0) isLoginSuccess = false;
        final Boolean finalIsLoginSuccess = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                testView.onLoginResult(finalIsLoginSuccess, code);
            }
        }, 5000);
    }

    @Override
    public void setProgressBarVisiblity(int visiblity) {
        testView.onSetProgressBarVisibility(visiblity);
    }
}
