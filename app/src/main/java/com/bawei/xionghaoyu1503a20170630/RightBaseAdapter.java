package com.bawei.xionghaoyu1503a20170630;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Effect :
 * <p>
 * Created by Administrator
 * Time by 2017/6/30 0030
 */

class RightBaseAdapter extends BaseAdapter{

    Context context;
    List<LeftBean.LayoutsBean> layouts;

    public RightBaseAdapter(Context context,List<LeftBean.LayoutsBean> layouts){
        this.context=context;
        this.layouts=layouts;
    }

    @Override
    public int getCount() {
        return layouts.size();
    }


    @Override
    public Object getItem(int position) {
        return layouts.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView==null){
            vh=new ViewHolder();
            convertView=View.inflate(context,android.R.layout.simple_list_item_1,null);

            vh.title= (TextView) convertView.findViewById(android.R.id.text1);

            convertView.setTag(vh);
        }else {
            vh= (ViewHolder) convertView.getTag();
        }

        vh.title.setText(layouts.get(position).getName());

        return convertView;
    }

    class ViewHolder{
        TextView title;
    }

}
