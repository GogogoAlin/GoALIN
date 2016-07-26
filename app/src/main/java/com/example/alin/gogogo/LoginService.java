package com.example.alin.gogogo;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by macbookair on 16/7/22.
 */
public class LoginService {

    public static  boolean saveuserInfo(Context context, String userName,String passWord,String sex,String phone){
        File file = new File(context.getFilesDir(),"userinfo.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file,true);
            fos.write((userName+"##"+passWord+"##"+sex+"##"+phone+"\n").getBytes());
            fos.flush();
            fos.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }


       return false;
    }
     public static List<Map<String,String>> getSavaUserInfo(Context context){
          File file = new File(context.getFilesDir(),"userinfo.txt");
          Map<String,String> map = new HashMap<String,String>();
          List<Map<String,String>>list=new ArrayList<>();

         try {
             FileInputStream fis = new FileInputStream(file);
             BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(fis));
             String data;
             while((data=bufferedReader.readLine())!=null){

                 String[] infos = data.split("##");
                 map.put("username", infos[0]);
                 map.put("password", infos[1]);
                 map.put("sex", infos[2]);
                 map.put("phonenumber", infos[3]);
                 list.add(map);
             }

           return list;

         } catch (FileNotFoundException e) {
             e.printStackTrace();

         } catch (IOException e) {
             e.printStackTrace();

         }
         return null;


     }



}
