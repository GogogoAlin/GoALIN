package com.example.alin.gogogo.fragment.picsfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.alin.gogogo.Cans.Cans;
import com.example.alin.gogogo.R;
import com.example.alin.gogogo.adapter.PicsDefaultAdaptera;
import com.example.alin.gogogo.bean.PicsDefault;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alin on 2016/7/23.
 */
public class DefaultPicsFragmentInActivity extends Fragment {
    private GridView gridView;
    private List<PicsDefault.DBean.RowsBean> list = new ArrayList<>();
    private PicsDefaultAdaptera adapter;
    private String shopId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.default_pics_fragment_layout_ac, null);
        gridView = (GridView) view.findViewById(R.id.gv_picture_show);
        Bundle arguments = getArguments();
        shopId = arguments.getString("shopId", "");
        loadData();
        return view;
    }
    private void loadData() {
        RequestParams requestParams = new RequestParams(String.format(Cans.pics,shopId));
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                PicsDefault picsDefault = new Gson().fromJson(result, PicsDefault.class);
                PicsDefault.DBean dBean = picsDefault.getD();
                list = dBean.getRows();
                adapter = new PicsDefaultAdaptera(list,getActivity());
                gridView.setAdapter(adapter);

            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }
            @Override
            public void onFinished() {

            }
        });
    }
}
