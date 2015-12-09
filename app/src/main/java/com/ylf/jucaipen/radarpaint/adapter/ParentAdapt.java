package com.ylf.jucaipen.radarpaint.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.ylf.jucaipen.radarpaint.R;
import com.ylf.jucaipen.radarpaint.base.BaseObjectListAdapter;
import com.ylf.jucaipen.radarpaint.entity.Entity;
import com.ylf.jucaipen.radarpaint.entity.ShowEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/9.
 */
public class ParentAdapt extends BaseObjectListAdapter {
    private ArrayList<ShowEntity> mChildList;
    public static int mParentItem = -1;
    public static boolean mbShowChild = false;

    public ParentAdapt(Context context, List<? extends Entity> datas) {
        super(context, datas);
        initData();
    }

    private void initData() {
        mChildList=new ArrayList<>();
        for(int i=0;i<20;i++){
            mChildList.add(new ShowEntity("title"+i,"content:"+i));
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.activity_main_list_item,null);
            holder.title= (TextView) convertView.findViewById(R.id.textView_1);
            holder.content= (TextView) convertView.findViewById(R.id.textView_2);
            holder.listViewItem= (ListView) convertView.findViewById(R.id.listView_child);
            holder.buttonStake= (Button) convertView.findViewById(R.id.button_1);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        ShowEntity showEntity=mChildList.get(position);
        holder.title.setText(showEntity.getTitle());
        holder.content.setText(showEntity.getContent());
        if(mParentItem==position&&mbShowChild){
            ChildAdapt childAdapter=new ChildAdapt(mContext,mChildList);
            holder.listViewItem.setAdapter(childAdapter);
            holder.listViewItem.setVisibility(View.VISIBLE);
            holder.listViewItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });

        }else {
            holder.listViewItem.setVisibility(View.GONE);
        }
        holder.buttonStake.setOnClickListener(new ParentButtonLisener());
        holder.buttonStake.setTag(position);
        return convertView;
    }

    class  ViewHolder{
        TextView title;
        TextView content;
        ListView listViewItem;
        Button buttonStake;
    }
    private  class  ParentButtonLisener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Integer p= (Integer) v.getTag();
        }
    }
}
