package com.bawei.xionghaoyu1503a20170630;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Effect :
 * <p>
 * Created by Administrator
 * Time by 2017/6/30 0030
 */

class RightBaseA extends BaseAdapter {

    Context context;
    List<LeftBean.LayoutsBean.ListBean> list;

    public RightBaseA(Context context,List<LeftBean.LayoutsBean.ListBean> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public Object getItem(int position) {
        return list.get(position);
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

        vh.title.setText(list.get(position).getTitle());

        return convertView;
    }

    class ViewHolder{
        TextView title;
    }
}
