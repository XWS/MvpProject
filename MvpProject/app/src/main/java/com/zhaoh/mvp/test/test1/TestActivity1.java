package com.zhaoh.mvp.test.test1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.zhaoh.mvp.R;
import com.zhaoh.mvp.test.test1.presenter.TestPresenterCompl;
import com.zhaoh.mvp.test.test1.view.ITestView;

/**
 * Created by 19208 on 2017/6/14.
 * 第一个mvp例子，一个简单的登录界面，点击 LOGIN 则进行账号密码验证，点击 CLEAR 则重置输入。
 */

public class TestActivity1 extends AppCompatActivity implements ITestView, View.OnClickListener {

    private EditText edit_Name, edit_Password;
    private Button btn_Login, btn_Clear;
    private ProgressBar progressBar;
    private TestPresenterCompl testPresenterCompl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        init();
    }

    private void init() {

        edit_Name = (EditText) findViewById(R.id.edit_UserName);
        edit_Password = (EditText) findViewById(R.id.edit_UserPassword);
        btn_Login = (Button) findViewById(R.id.btn_Login);
        btn_Clear = (Button) findViewById(R.id.btn_Clear);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        btn_Login.setOnClickListener(this);
        btn_Clear.setOnClickListener(this);

        testPresenterCompl = new TestPresenterCompl(this);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Clear:
                testPresenterCompl.clear();
                break;
            case R.id.btn_Login:
                testPresenterCompl.setProgressBarVisiblity(View.VISIBLE);
                testPresenterCompl.doLogin(edit_Name.getText().toString(), edit_Password.getText().toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void clearTest() {
        edit_Name.setText("");
        edit_Password.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        testPresenterCompl.setProgressBarVisiblity(View.INVISIBLE);
        if (result) {
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "登录失败，code=" + code, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }
}
