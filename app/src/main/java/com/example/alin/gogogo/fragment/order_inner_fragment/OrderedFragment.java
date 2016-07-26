package com.example.alin.gogogo.fragment.order_inner_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alin.gogogo.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

/**
 * Created by Alin on 2016/7/18.
 *
 */
public class OrderedFragment extends Fragment {
    private PullToRefreshExpandableListView pullToRefreshListView;
    private List<String> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ordered_fragment_layout,null);
        pullToRefreshListView = (PullToRefreshExpandableListView) view.findViewById(R.id.pull_listView_ordered);
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);


        return view;
    }

}
