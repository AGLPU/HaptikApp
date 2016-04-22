package com.example.hp.haptikapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aman Goel on 05-08-2015.
 */
public class MessageAdapter extends BaseAdapter {

    Context context;

    LayoutInflater inflator;
    List vMessageList;
    List vtimeList;

    Holder holder;

    public MessageAdapter(Context ctx, List messageList,List timelist){

        context=ctx;
        this.vMessageList=messageList;

        this.vtimeList=timelist;
        inflator= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return vMessageList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, View view, ViewGroup parent) {
        holder = new Holder();

        if (view == null) {
            view = inflator.inflate(R.layout.message_row_layout, null);

            holder.textView = (TextView) view.findViewById(R.id.messageTextVw);
            holder.timetextVw = (TextView) view.findViewById(R.id.timeTextVw);

            view.setTag(holder);


        } else
            holder = (Holder) view.getTag();


        try {
            holder.textView.setText(vMessageList.get(position).toString());
            holder.timetextVw.setText(vtimeList.get(position).toString());

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }




    class Holder {

       TextView textView;
       TextView timetextVw;
   }


}
