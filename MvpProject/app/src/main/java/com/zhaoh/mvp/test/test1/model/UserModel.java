package com.zhaoh.mvp.test.test1.model;

import android.text.TextUtils;

/**
 * Created by 19208 on 2017/6/14.
 */

public class UserModel implements IUser {

    private String Name;
    private String PassWord;

    public UserModel(String name, String passWord) {
        Name = name;
        PassWord = passWord;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public String getPassWord() {
        return PassWord;
    }

    @Override
    public int checkUserValidity(String name, String password) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password) || !name.equals(getName()) || !password.equals(getPassWord())) {
            return -1;
        }
        return 0;
    }
}
