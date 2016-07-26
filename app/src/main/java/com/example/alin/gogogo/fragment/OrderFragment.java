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
import android.widget.Toast;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.fragment.order_inner_fragment.OrderedFragment;
import com.example.alin.gogogo.fragment.order_inner_fragment.PreOrderFragment;
import com.example.alin.gogogo.myinterface.SlindingOnClickCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alin on 2016/7/18.
 */
public class OrderFragment extends Fragment {

    private RadioGroup group;
    private RadioButton[] buttons;
    private FragmentManager manager;
    private List<Fragment> list;
    private int current = 0;
    private SlindingOnClickCallback callback;
    private ImageView iv;
    public void setCallback(SlindingOnClickCallback callback) {
        this.callback = callback;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_fragment_layout,null);
        group = (RadioGroup) view.findViewById(R.id.rg_order);
        buttons = new RadioButton[group.getChildCount()];
        iv= (ImageView) view.findViewById(R.id.iv_order_sliding);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.togOnClick();
            }
        });
        list = new ArrayList<>();
        initView();

        initFragment();
        return view;
    }

    private void initFragment() {
        OrderedFragment orderedFragment = new OrderedFragment();
        PreOrderFragment preOrderFragment = new PreOrderFragment();
        list.add(orderedFragment);
        list.add(preOrderFragment);

        manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.order_second_fragment_rl, list.get(0));
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
                    ft.add(R.id.order_second_fragment_rl, list.get(i));
                    ft.hide(currentFragment);
                    ft.commit();
                }
                current = i;
            }
        });
    }
}
