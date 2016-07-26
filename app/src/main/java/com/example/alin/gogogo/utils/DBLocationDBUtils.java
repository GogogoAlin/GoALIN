package com.example.alin.gogogo.utils;

import android.content.Intent;

import com.example.alin.gogogo.bean.DBGift;
import com.example.alin.gogogo.bean.DBPreOrder;

import org.xutils.DbManager;
import org.xutils.ex.DbException;

import java.util.List;

/**
 * Created by Alin on 2016/7/22.
 */
public class DBLocationDBUtils {
    public DbManager manager;
    private DBLocationDBUtils(){}
    private static DBLocationDBUtils instance=null;
    public static DBLocationDBUtils getInstance(){
        if(instance==null){
            instance=new DBLocationDBUtils();
        }
        return instance;
    }

    public DbManager getManager() {
        return manager;
    }

    public void setManager(DbManager manager) {
        this.manager = manager;
    }
//添加一个礼物
    public void addGift(DBGift dbGift){
        try {
            manager.save(dbGift);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public void deleteGift(DBGift dbGift){
        try {
            manager.delete(dbGift);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public List<DBGift> qureyDBGift(){
        try {
            return manager.findAll(DBGift.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return null;
    }

}
