package com.example.hp.haptikapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    Map<String,Object> map;
    String jsonData="{\n" +
            "        \"count\": 15,\n" +
            "        \"messages\": [\n" +
            "            {\"body\": \"hello\",\n" +
            "            \"username\": \"john-t\",\n" +
            "            \"Name\": \"John\",\n" +
            "            \"image-url\": \"http://haptikdev.s3.amazonaws.com/content/06138bc5af6023646ede0e1f7c1eac75d64dd2f45a516f8746413832a94f75f3.jpeg\",\n" +
            "            \"message-time\": \"2016-01-01T05:30:34\"\n" +
            "            },\n" +
            "            {\"body\": \"Hi\",\n" +
            "            \"username\": \"ryan-a\",\n" +
            "            \"Name\": \"Ryan\",\n" +
            "            \"image-url\": \"http://haptikdev.s3.amazonaws.com/content/06138bc5af6023646ede0e1f7c1eac75d64dd2f45a516f8746413832a94f75f3.jpeg\",\n" +
            "            \"message-time\": \"2016-01-01T05:31:04\"\n" +
            "            },\n" +
            "            {\"body\": \"How is everyone?\",\n" +
            "            \"username\": \"ryan-a\",\n" +
            "            \"Name\": \"Ryan\",\n" +
            "            \"image-url\": \"http://haptikdev.s3.amazonaws.com/content/06138bc5af6023646ede0e1f7c1eac75d64dd2f45a516f8746413832a94f75f3.jpeg\",\n" +
            "            \"message-time\": \"2016-01-01T05:32:34\"\n" +
            "            },\n" +
            "            {\"body\": \"Is everone here?\",\n" +
            "            \"username\": \"shawn-t\",\n" +
            "            \"Name\": \"Shawn\",\n" +
            "            \"image-url\": \"http://haptikdev.s3.amazonaws.com/content/060ad92489947d410d897474079c1477456d6f0d6f438cd7b58021d9b23f7d6b.jpeg\",\n" +
            "            \"message-time\": \"2016-01-01T05:32:37\"\n" +
            "            },\n" +
            "            {\"body\": \"I am here\",\n" +
            "            \"username\": \"steve-t\",\n" +
            "            \"Name\": \"Steve\",\n" +
            "            \"image-url\": \"\",\n" +
            "            \"message-time\": \"2016-01-01T05:33:54\"\n" +
            "            },\n" +
            "            {\"body\": \"Okay, we should start the meeting\",\n" +
            "            \"username\": \"john-t\",\n" +
            "            \"Name\": \"John\",\n" +
            "            \"image-url\": \"http://haptikdev.s3.amazonaws.com/content/06138bc5af6023646ede0e1f7c1eac75d64dd2f45a516f8746413832a94f75f3.jpeg\",\n" +
            "            \"message-time\": \"2016-01-01T05:35:00\"\n" +
            "            },\n" +
            "            {\"body\": \"We are missing Steve and Mark\",\n" +
            "            \"username\": \"john-t\",\n" +
            "            \"Name\": \"John\",\n" +
            "            \"image-url\": \"http://haptikdev.s3.amazonaws.com/content/06138bc5af6023646ede0e1f7c1eac75d64dd2f45a516f8746413832a94f75f3.jpeg\",\n" +
            "            \"message-time\": \"2016-01-01T05:33:34\"\n" +
            "            },\n" +
            "            {\"body\": \"Is the number right?\",\n" +
            "            \"username\": \"shawn-t\",\n" +
            "            \"Name\": \"Shawn\",\n" +
            "            \"image-url\": \"http://haptikdev.s3.amazonaws.com/content/060ad92489947d410d897474079c1477456d6f0d6f438cd7b58021d9b23f7d6b.jpeg\",\n" +
            "            \"message-time\": \"2016-01-01T05:38:56\"\n" +
            "            },\n" +
            "            {\"body\": \"I have to leave, sorry I wont be able to attend\",\n" +
            "            \"username\": \"mark-t\",\n" +
            "            \"Name\": \"Mark\",\n" +
            "            \"image-url\": \"http://haptikdev.s3.amazonaws.com/content/0aa1883c6411f7873cb83dacb17b0afcd905ce2676db5aab8573d4480968c1a8.jpeg\",\n" +
            "            \"message-time\": \"2016-01-01T05:34:54\"\n" +
            "            },\n" +
            "            {\"body\": \"The conference number if +91 7501827474\",\n" +
            "            \"username\": \"john-t\",\n" +
            "            \"Name\": \"John\",\n" +
            "            \"image-url\": \"http://haptikdev.s3.amazonaws.com/content/06138bc5af6023646ede0e1f7c1eac75d64dd2f45a516f8746413832a94f75f3.jpeg\",\n" +
            "            \"message-time\": \"2016-01-01T05:36:34\"\n" +
            "            },\n" +
            "            {\"body\": \"I am unable to dial in\",\n" +
            "            \"username\": \"shawn-t\",\n" +
            "            \"Name\": \"Shawn\",\n" +
            "            \"image-url\": \"http://haptikdev.s3.amazonaws.com/content/060ad92489947d410d897474079c1477456d6f0d6f438cd7b58021d9b23f7d6b.jpeg\",\n" +
            "            \"message-time\": \"2016-01-01T05:38:12\"\n" +
            "            },\n" +
            "            {\"body\": \"The right number is +91 7501827473\",\n" +
            "            \"username\": \"steve-t\",\n" +
            "            \"Name\": \"Steve\",\n" +
            "            \"image-url\": \"\",\n" +
            "            \"message-time\": \"2016-01-01T05:39:34\"\n" +
            "            },\n" +
            "            {\"body\": \"Please use the above number\",\n" +
            "            \"username\": \"steve-t\",\n" +
            "            \"Name\": \"Steve\",\n" +
            "            \"image-url\": \"\",\n" +
            "            \"message-time\": \"2016-01-01T05:40:34\"\n" +
            "            },\n" +
            "            {\"body\": \"Great it is working now\",\n" +
            "            \"username\": \"shawn-t\",\n" +
            "            \"Name\": \"Shawn\",\n" +
            "            \"image-url\": \"http://haptikdev.s3.amazonaws.com/content/060ad92489947d410d897474079c1477456d6f0d6f438cd7b58021d9b23f7d6b.jpeg\",\n" +
            "            \"message-time\": \"2016-01-01T05:41:34\"\n" +
            "            },\n" +
            "            {\"body\": \"Sorry I had a typo in my number\",\n" +
            "            \"username\": \"john-t\",\n" +
            "            \"Name\": \"John\",\n" +
            "            \"image-url\": \"http://haptikdev.s3.amazonaws.com/content/06138bc5af6023646ede0e1f7c1eac75d64dd2f45a516f8746413832a94f75f3.jpeg\",\n" +
            "            \"message-time\": \"2016-01-01T05:41:54\"\n" +
            "            }\n" +
            "        ]\n" +
            "        }";

    ListView listVw;
    ImageLoader imgLoader;
    ArrayList list=new ArrayList();
    ArrayList userNamelist=new ArrayList();


    DamagesDescriptionAdapter adapter;
    UILApplication appState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listVw=(ListView)findViewById(R.id.listVw);


        map=new LinkedHashMap<>();
        readAndParse();
        imgLoader=new ImageLoader(getApplicationContext());

        adapter=new DamagesDescriptionAdapter(getApplicationContext(),map,imgLoader);

        listVw.setAdapter(adapter);

        appState=(UILApplication)getApplicationContext();
        listVw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent=new Intent(getApplicationContext(), MessageActivity.class);

                intent.putExtra("USERNAME", userNamelist.get(position).toString());
                startActivity(intent);
            }
        });

    }

    public void readAndParse(){

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray jsonArray=jsonObject.getJSONArray(FileUtils.MESSAGE_KEY);
            for(int i=0;i<jsonArray.length();i++){
                try {

                    JSONObject jsonObject1 = (JSONObject)jsonArray.get(i);

                    map.put(jsonObject1.getString(FileUtils.USERNAME_KEY), jsonArray.get(i));
/*
    Map<String, Object> singleUserObjectMap=new HashMap<>();
    singleUserObjectMap.put(jsonObject1.getString())*/


    list.add(jsonObject1);

    if(userNamelist.contains(jsonObject1.getString(FileUtils.USERNAME_KEY))) {
        userNamelist.add(jsonObject1.getString(FileUtils.USERNAME_KEY));
    }

    else{

    }

}
catch (Exception e){
    e.printStackTrace();
}

                appState.setJsondataList(list);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}
