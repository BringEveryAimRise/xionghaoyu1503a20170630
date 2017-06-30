package com.bawei.xionghaoyu1503a20170630;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Effect :
 * <p>
 * Created by Administrator
 * Time by 2017/6/30 0030
 */

class FragmentAdapter extends FragmentPagerAdapter {

    Context context;
    ArrayList<Fragment> fragments;

    public FragmentAdapter(FragmentManager fragmentManager,Context context, ArrayList<Fragment> arrayList) {
        super(fragmentManager);
        this.context=context;
        this.fragments=arrayList;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }


    @Override
    public int getCount() {
        return fragments.size();
    }
}
