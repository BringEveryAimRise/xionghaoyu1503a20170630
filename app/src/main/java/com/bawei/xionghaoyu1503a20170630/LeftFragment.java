package com.bawei.xionghaoyu1503a20170630;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

import static android.R.attr.manageSpaceActivity;
import static android.R.attr.path;

/**
 * Effect :
 * <p>
 * Created by Administrator
 * Time by 2017/6/30 0030
 */

public class LeftFragment extends Fragment{
    int[] rID=new int[]{R.mipmap.a1,R.mipmap.a2,R.mipmap.a3};
    String path="http://h5test.newaircloud.com/api/getLayouts?sid=xkycs&cid=10024&date";

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            String str= (String) msg.obj;
            LeftBean leftBean = gson.fromJson(str, LeftBean.class);
            tv.setText(leftBean.getDate());
            layouts = leftBean.getLayouts();


            LeftFragmentAdapter leftFragmentAdapter = new LeftFragmentAdapter(getChildFragmentManager(),layouts);
            viewPager.setAdapter(leftFragmentAdapter);
        }
    };

    private ViewPager viewPager;
    private TextView tv;
    private Gson gson;
    private List<LeftBean.LayoutsBean> layouts;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_left,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gson = new Gson();
        viewPager = (ViewPager) getView().findViewById(R.id.left_viewpager);
        tv = (TextView) getView().findViewById(R.id.left_tv);
        
        initData();
    }

    private void initData() {

        OkHttpClient client=new OkHttpClient();

        Request request=new Request.Builder().url(path ).build();

        client.newCall(request).enqueue(new Callback() {
            private List<LeftBean.LayoutsBean> layouts;

            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

                Message message = new Message();
                message.obj=response.body().string();
                handler.sendMessage(message);
            }
        });
    }




}
