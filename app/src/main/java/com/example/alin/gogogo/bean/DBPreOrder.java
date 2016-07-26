package com.example.alin.gogogo.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2016/7/25.
 */
@Table(name="DBPreOrder")
public class DBPreOrder {
    @Column(name = "pre_name",isId = true)
    private String pre_name;
    @Column(name = "pre_price")
    private String pre_price;
    @Column(name ="pre_count" )
    private String pre_count;
    @Column(name = "pre_username")
    private String pre_username;
    @Column(name = "pre_phone")
    private String pre_phone;
    @Column(name = "pre_paymoney")
    private String pre_paymoney;

    public DBPreOrder(String pre_name, String pre_price, String pre_count, String pre_username, String pre_phone, String pre_paymoney) {
        this.pre_name = pre_name;
        this.pre_price = pre_price;
        this.pre_count = pre_count;
        this.pre_username = pre_username;
        this.pre_phone = pre_phone;
        this.pre_paymoney = pre_paymoney;
    }
    public DBPreOrder() {
    }

    public String getPre_name() {
        return pre_name;
    }

    public void setPre_name(String pre_name) {
        this.pre_name = pre_name;
    }

    public String getPre_price() {
        return pre_price;
    }

    public void setPre_price(String pre_price) {
        this.pre_price = pre_price;
    }

    public String getPre_count() {
        return pre_count;
    }

    public void setPre_count(String pre_count) {
        this.pre_count = pre_count;
    }

    public String getPre_username() {
        return pre_username;
    }

    public void setPre_username(String pre_username) {
        this.pre_username = pre_username;
    }

    public String getPre_phone() {
        return pre_phone;
    }

    public void setPre_phone(String pre_phone) {
        this.pre_phone = pre_phone;
    }

    public String getPre_paymoney() {
        return pre_paymoney;
    }

    public void setPre_paymoney(String pre_paymoney) {
        this.pre_paymoney = pre_paymoney;
    }
}
