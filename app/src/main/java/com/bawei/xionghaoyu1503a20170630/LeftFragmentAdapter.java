package com.bawei.xionghaoyu1503a20170630;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Effect :
 * <p>
 * Created by Administrator
 * Time by 2017/6/30 0030
 */

public class LeftFragmentAdapter extends FragmentPagerAdapter{

    private List<LeftBean.LayoutsBean> layouts;

    public LeftFragmentAdapter(FragmentManager fm,List<LeftBean.LayoutsBean> layouts) {
        super(fm);
        this.layouts=layouts;
    }


    @Override
    public Fragment getItem(int position) {
        return new Fragments(layouts.get(position).getPicUrl());
    }


    @Override
    public int getCount() {
        return layouts.size();
    }
}
