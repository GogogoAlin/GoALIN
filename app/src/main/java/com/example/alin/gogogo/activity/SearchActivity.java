package com.example.alin.gogogo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import com.example.alin.gogogo.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private ListView listview;
    private GridView gridview;
    private SearchView searchView;
    private SlidingMenu menu;

    private List<String>currentlist=new ArrayList<>();

    private String []Scene={"热门搜素","夫子庙","江南贡院","画廊","李香君","王写故居","老门东"};
    private List<String>list_lv=new ArrayList<>();


    private ListView rightmenu_lv;
    private ArrayAdapter<String>adapter_right_menu;
    private ArrayAdapter<String>adapter_main_lv;
    private ArrayAdapter<String>adapter_main_gv;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        listview=(ListView)findViewById(R.id.history_Listview);
        gridview= (GridView) findViewById(R.id.gridview);
        searchView=(SearchView)findViewById(R.id.search);
        intent=new Intent(this,ScenicspotTicket.class);

        adapter_main_lv=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,currentlist);
        listview.setAdapter(adapter_main_lv);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              startActivity(intent);


            }
        });





        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                currentlist.add(query);
                startActivity(intent);


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }

        });

        // rightmenulistview填充数据,即监听事件
        initMenu();

        //热门景点搜索
        adapter_main_gv=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Scene);
        gridview.setAdapter(adapter_main_gv);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                list_lv.clear();
                list_lv.add(Scene[i]);
                currentlist.addAll(list_lv);

                adapter_main_lv.notifyDataSetChanged();

                startActivity(intent);


            }
        });















    }





    public void Clickbt(View view){
        switch (view.getId()){

            case R.id.clear:

                currentlist.clear();
                adapter_main_lv.notifyDataSetChanged();

                break;
            case R.id.homecatory_back:
                finish();
                break;
            case R.id.more:
                menu.toggle();
                break;

        }
    }

    private void initMenu() {
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.RIGHT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offse);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.7f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.rightmenu);

        Button b = (Button) menu.findViewById(R.id.button1);
        Button b1 = (Button) menu.findViewById(R.id.button2);
        Button b2 = (Button) menu.findViewById(R.id.button3);
        Button b3 = (Button) menu.findViewById(R.id.button4);
        Button b4= (Button) menu.findViewById(R.id.button5);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });



    }
}
