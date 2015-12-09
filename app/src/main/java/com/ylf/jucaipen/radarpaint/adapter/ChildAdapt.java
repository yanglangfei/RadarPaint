package com.ylf.jucaipen.radarpaint.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ylf.jucaipen.radarpaint.R;
import com.ylf.jucaipen.radarpaint.base.BaseObjectListAdapter;
import com.ylf.jucaipen.radarpaint.entity.Entity;
import com.ylf.jucaipen.radarpaint.entity.ShowEntity;

import java.util.List;

/**
 * Created by Administrator on 2015/12/9.
 */
public class ChildAdapt extends BaseObjectListAdapter {

    public ChildAdapt(Context context, List<? extends Entity> datas) {
        super(context, datas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.activity_main_list_item_1,null);
            holder.title= (TextView) convertView.findViewById(R.id.textView_1);
            holder.content= (TextView) convertView.findViewById(R.id.textView_2);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        ShowEntity showEntity= (ShowEntity) mDatas.get(position);
        holder.title.setText(showEntity.getTitle());
        holder.content.setText(showEntity.getContent());
        return convertView;
    }

    class  ViewHolder{
        TextView title;
        TextView content;
    }
}
