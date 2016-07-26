package com.example.alin.gogogo.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

import java.util.List;

/**
 * Created by Alin on 2016/7/22.
 */
@Table(name = "DBGift")
public class DBGift {
    //    * goodsId : SP1420160127142101001101
    //    * goodsName : 发光头箍
//    * price : 15.00
//    * imgList : ["http://file.zhfzm.com/zouyizou_bss/group1/M00/00/01/rBABkVaoYZaAY-pjAAaw4Iw_AgU110.jpg?r=0.44008460195196586"]
//    * goodAppraiseNum : 0
//    * shopName : 秦淮礼物
    @Column(name = "goodsId", isId = true, autoGen = true)
    private String goodsId;
    @Column(name = "goodsName")
    private String goodsName;
    @Column(name = "price")
    private String price;
    @Column(name = "goodAppraiseNum")
    private String goodAppraiseNum;
    @Column(name = "shopName")
    private String shopName;
    @Column(name = "imgList")
    private String imgList;

    public DBGift(String goodsId, String goodsName, String price, String goodAppraiseNum, String shopName, String imgList) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.price = price;
        this.goodAppraiseNum = goodAppraiseNum;
        this.shopName = shopName;
        this.imgList = imgList;
    }

    public DBGift() {
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGoodAppraiseNum() {
        return goodAppraiseNum;
    }

    public void setGoodAppraiseNum(String goodAppraiseNum) {
        this.goodAppraiseNum = goodAppraiseNum;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getImgList() {
        return imgList;
    }

    public void setImgList(String imgList) {
        this.imgList = imgList;
    }
}
