package com.example.hp.haptikapp;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Aman Goel on 05-08-2015.
 */
public class DamagesDescriptionAdapter extends BaseAdapter {

    Context context;

    LayoutInflater inflator;

    ImageLoader vImgLoader;


    Holder holder;
    Map<String,Object> jsonMap;
    List list=new ArrayList();

    public DamagesDescriptionAdapter(Context ctx, Map<String,Object> map,ImageLoader imgLoader){

        context=ctx;
        //this.objectList=list;

        jsonMap=map;
        vImgLoader=imgLoader;


        Set<Map.Entry<String,Object>> set=jsonMap.entrySet();
        Iterator iterator=set.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Object> me = (Map.Entry<String, Object>) iterator.next();

           list.add(me.getValue());
        }
        inflator = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return jsonMap.size();
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
            view = inflator.inflate(R.layout.user_row_layout, null);

            holder.textView = (TextView) view.findViewById(R.id.nameTextVw);
            holder.imageView = (ImageView) view.findViewById(R.id.image);
            holder.progressBar = (ProgressBar) view.findViewById(R.id.progressBarVw);

            view.setTag(holder);


        } else
            holder = (Holder) view.getTag();


        try {


                JSONObject jsonObject1=(JSONObject)list.get(position);
                holder.textView.setText(jsonObject1.getString(FileUtils.NAME_KEY));

                vImgLoader.DisplayImage(jsonObject1.getString(FileUtils.IMAGEURL_KEY), holder.imageView,holder.progressBar);




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
       ImageView imageView;
        ProgressBar progressBar;
   }


}
