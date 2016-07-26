package com.example.alin.gogogo.utils;

import com.example.alin.gogogo.bean.DBPreOrder;

import org.xutils.DbManager;
import org.xutils.ex.DbException;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class PreOrderDBUtils {
    public DbManager manager;
    private PreOrderDBUtils(){}
    private static PreOrderDBUtils instance=null;

    public static PreOrderDBUtils getInstance(){
        if(instance==null){
            instance=new PreOrderDBUtils();
        }
        return instance;
    }

    public DbManager getManager() {
        return manager;
    }

    public void setManager(DbManager manager) {
        this.manager = manager;
    }

    //添加预约订单

    public void addPreGift(DBPreOrder dbPreOrder){
        try {
            manager.save(dbPreOrder);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
    public void deletePreGift(DBPreOrder dbPreOrder){
        try {
            manager.delete(dbPreOrder);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public List<DBPreOrder> qureyDBPreGift(){
        try {
            return manager.findAll(DBPreOrder.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return null;
    }

}
