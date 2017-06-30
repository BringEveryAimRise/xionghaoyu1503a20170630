package com.bawei.xionghaoyu1503a20170630;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Effect :
 * <p>
 * Created by Administrator
 * Time by 2017/6/30 0030
 */

public class Fragments extends Fragment {

    private String path;

    public Fragments(){}

    public Fragments(String picUrl) {
        path=picUrl;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_item,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageView iv = (ImageView) getView().findViewById(R.id.frag_iv);
        Picasso.with(getActivity()).load(path).placeholder(R.mipmap.a1).into(iv);
    }
}
