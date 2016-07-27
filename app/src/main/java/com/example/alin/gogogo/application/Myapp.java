package com.example.alin.gogogo.application;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.example.alin.gogogo.utils.DBLocationDBUtils;
import com.example.alin.gogogo.utils.PreOrderDBUtils;
import com.example.alin.gogogo.utils.ScenicDBUtil;

import org.xutils.DbManager;
import org.xutils.x;

/**
 * Created by macbookair on 16/7/19.
 */
public class Myapp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
        loadDB();

    }
    private void loadDB() {
        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig();
        daoConfig.setDbName("XutilDB");
        daoConfig.setDbVersion(1); //  设置数据库版本号
        DbManager dbManager = x.getDb(daoConfig);// 获取 数据库操作对象
        ScenicDBUtil.getInstance().setManager(dbManager);
        DBLocationDBUtils.getInstance().setManager(dbManager);
        PreOrderDBUtils.getInstance().setManager(dbManager);
    }

}
