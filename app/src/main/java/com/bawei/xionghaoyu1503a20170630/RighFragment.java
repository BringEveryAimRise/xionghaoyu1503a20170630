package com.bawei.xionghaoyu1503a20170630;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.name;

/**
 * Effect :
 * <p>
 * Created by Administrator
 * Time by 2017/6/30 0030
 */

public class RighFragment extends Fragment{
    String path="http://h5test.newaircloud.com/api/getLayouts?sid=xkycs&cid=10024&date";

    Handler handler=new Handler(){
        private List<LeftBean.LayoutsBean> layouts;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            LeftBean leftBean = gson.fromJson((String) msg.obj, LeftBean.class);
            /**
             * 获取数据
             */
            layouts = leftBean.getLayouts();

            list1 = new ArrayList<>();
            for (int i = 0; i < layouts.size(); i++) {
                if (layouts.get(i).getList() != null && layouts.get(i).getList().size() != 0) {
                    LeftBean.LayoutsBean.ListBean listBean = new LeftBean.LayoutsBean.ListBean();
                    listBean.setTitle(layouts.get(i).getName());
                    list1.add(listBean);
                    list1.addAll(layouts.get(i).getList());
                }
            }



            tv.setText(leftBean.getDate());
            /**
             * 设置pop数据
             */
            RightBaseAdapter rightBaseAdapter = new RightBaseAdapter(getActivity(), layouts);
            lv.setAdapter(rightBaseAdapter);

            rightBaseA = new RightBaseA(getActivity(), list1);
            listView.setAdapter(rightBaseA);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getActivity(), RighFragment.this.list.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                }
            });

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (popupWindow.isShowing()){
                        popupWindow.dismiss();
                    }
                    String name = layouts.get(position).getName();

                    int index=-1;
                    for (int i = 0; i < list1.size(); i++) {
                        if (name.equals(list1.get(i).getTitle())){
                            index=i;
                            break;
                        }
                    }

                    listView.setSelection(index);

                }
            });

        }
    };
    private TextView tv;
    private TextView menu;
    private ListView listView;
    private ListView lv;
    private PopupWindow popupWindow;
    private Gson gson;
    private List<LeftBean.LayoutsBean> layouts;
    private RightBaseA rightBaseA;
    private List<LeftBean.LayoutsBean.ListBean> list;
    private List<LeftBean.LayoutsBean.ListBean> list1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_righ,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gson = new Gson();
        final View view=View.inflate(getActivity(),R.layout.item,null);
        lv = (ListView) view.findViewById(R.id.item_listv);

        listView = (ListView) getView().findViewById(R.id.right_listv);
        tv = (TextView) getView().findViewById(R.id.right_tv);
        menu = (TextView) getView().findViewById(R.id.right_menu);

        initData();






        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow = new PopupWindow(view, 300, WindowManager.LayoutParams.WRAP_CONTENT);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.setTouchable(true);
                if (popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
                popupWindow.showAsDropDown(v);
            }
        });
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
