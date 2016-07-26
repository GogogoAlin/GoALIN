package com.example.alin.gogogo.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alin on 2016/7/21.
 */
@Table(name = "DBScinceBean")
public class DBScinceBean {
    @Column(name = "shopId", isId = true, autoGen = true)
    private String shopId;
    @Column(name = "goodAppraiseNum")
    private String goodAppraiseNum;
    @Column(name = "shopHours")
    private String shopHours;
    @Column(name = "shopName")
    private String shopName;
    @Column(name = "imgList")
    private String imgList;

    public DBScinceBean() {
    }

    public String getImgList() {
        return imgList;
    }

    public void setImgList(String imgList) {
        this.imgList = imgList;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getGoodAppraiseNum() {
        return goodAppraiseNum;
    }

    public void setGoodAppraiseNum(String goodAppraiseNum) {
        this.goodAppraiseNum = goodAppraiseNum;
    }

    public String getShopHours() {
        return shopHours;
    }

    public void setShopHours(String shopHours) {
        this.shopHours = shopHours;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
