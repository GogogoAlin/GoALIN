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
import com.example.alin.gogogo.adapter.PicsNefriendUpAdapter;
import com.example.alin.gogogo.bean.PicsNetFriendUp;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by Alin on 2016/7/23.
 */
public class NetFriendUpdateFragmentInActivity extends Fragment {

    private GridView gv;
    private String shopId="";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.default_pics_fragment_layout_ac,null);
        gv= (GridView) view.findViewById(R.id.gv_picture_show);
        Bundle arguments = getArguments();
        shopId = arguments.getString("shopId", "");
        loadData();
        return view;
    }

    private void loadData() {
        RequestParams requestParams = new RequestParams(String.format(Cans.PICS_NETFREEND_UP,shopId));
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                List<PicsNetFriendUp.DBean.RowsBean> list = new Gson().fromJson(result, PicsNetFriendUp.class).getD().getRows();
                PicsNefriendUpAdapter adapter = new PicsNefriendUpAdapter(list,getActivity());
                gv.setAdapter(adapter);
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
