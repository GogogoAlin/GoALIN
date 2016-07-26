package com.example.alin.gogogo.fragment.collection_inner_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alin.gogogo.R;

/**
 * Created by Alin on 2016/7/18.
 */
public class HotelFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hotel_fragment_layout,null);

        return view;
    }
}
