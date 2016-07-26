package com.example.alin.gogogo.utils;

import com.example.alin.gogogo.bean.DBScinceBean;

import org.xutils.DbManager;
import org.xutils.ex.DbException;

import java.util.List;

/**
 * Created by Alin on 2016/7/21.
 */
//懒汉式单例类.在第一次调用的时候实例化自己
//public class Singleton {
//    private Singleton() {}
//    private static Singleton single=null;
//    //静态工厂方法
//    public static Singleton getInstance() {
//        if (single == null) {
//            single = new Singleton();
//        }
//        return single;
//    }
//}
public class ScenicDBUtil {
    public  DbManager manager;
    private ScenicDBUtil(){}
    private static ScenicDBUtil instance=null;
    public static ScenicDBUtil getInstance(){
        if(instance==null){
            instance=new ScenicDBUtil();
        }
        return instance;
    }

    public DbManager getManager() {
        return manager;
    }

    public void setManager(DbManager manager) {
        this.manager = manager;
    }

    public ScenicDBUtil(DbManager manager) {
        this.manager = manager;
    }

    //添加一个景点
    public  void addScenicBean(DBScinceBean dbScinceBean) {
        try {
            manager.save(dbScinceBean);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    //删除一条数据
    public  void deleteScenicBean(DBScinceBean dbScinceBean) {
        try {
            manager.delete(dbScinceBean);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    // 查询 表中的全部的数据
    public  List<DBScinceBean> qureyDBScinceBean() {
        try {
            return manager.findAll(DBScinceBean.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return null;
    }
}
