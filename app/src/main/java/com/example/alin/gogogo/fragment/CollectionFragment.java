package com.example.alin.gogogo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.fragment.collection_inner_fragment.FoodFragment;
import com.example.alin.gogogo.fragment.collection_inner_fragment.HotelFragment;
import com.example.alin.gogogo.fragment.collection_inner_fragment.LocationFragment;
import com.example.alin.gogogo.fragment.collection_inner_fragment.RelaxaFragment;
import com.example.alin.gogogo.fragment.collection_inner_fragment.SenceFragment;
import com.example.alin.gogogo.myinterface.SlindingOnClickCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alin on 2016/7/18.
 */
public class CollectionFragment extends Fragment {

    private int m;
    private RadioGroup group;
    private RadioButton[] buttons;
    private FragmentManager manager;
    private List<Fragment> list;
    private int current = 0;
    private SlindingOnClickCallback callback;

    public void setCallback(SlindingOnClickCallback callback) {
        this.callback = callback;
    }

    private ImageView iv;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collection_fragment_layout, null);
        group = (RadioGroup) view.findViewById(R.id.rg_collection);
        buttons = new RadioButton[group.getChildCount()];
        iv= (ImageView) view.findViewById(R.id.iv_collection_sliding);

        list = new ArrayList<>();
        initView();
        initFragment();
        listener();
        //添加数据
        loadData();
        return view;

    }

    private void loadData() {

    }

    private void listener() {
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.togOnClick();
            }
        });
    }

    private void initFragment() {
        SenceFragment senceFragment = new SenceFragment();
        HotelFragment hotelFragment = new HotelFragment();
        FoodFragment foodFragment = new FoodFragment();
        RelaxaFragment relaxaFragment = new RelaxaFragment();
        LocationFragment locationFragment = new LocationFragment();
        list.add(senceFragment);
        list.add(hotelFragment);
        list.add(foodFragment);
        list.add(relaxaFragment);
        list.add(locationFragment);

        manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.collecction_second_fragment_rl, list.get(0));
        ft.commit();
    }

    private void initView() {
        for (int i = 0; i < group.getChildCount(); i++) {
            buttons[i] = (RadioButton) group.getChildAt(i);
        }

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                for (int j = 0; j < group.getChildCount(); j++) {
                    if (buttons[j].getId() == i) {
                        replaceFragment(j);
                    }
                }
            }

            private void replaceFragment(int i) {
                FragmentTransaction ft = manager.beginTransaction();

                Fragment targetFragment = list.get(i);
                Fragment currentFragment = list.get(current);

                if (targetFragment.isAdded()) {
                    ft.show(targetFragment);
                    ft.hide(currentFragment);
                    ft.commit();
                } else {
                    ft.add(R.id.collecction_second_fragment_rl, list.get(i));
                    ft.hide(currentFragment);
                    ft.commit();
                }
                current = i;
            }
        });
    }


}
