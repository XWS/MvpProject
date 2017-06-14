package com.zhaoh.mvp.test.test1.model;

/**
 * Created by 19208 on 2017/6/14.
 */

public interface IUser {

    String getName();

    String getPassWord();

    int checkUserValidity(String name, String password);
}
