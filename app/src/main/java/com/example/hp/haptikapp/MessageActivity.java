package com.example.hp.haptikapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends ActionBarActivity {

    ListView listView;
    MessageAdapter messageAdapter;

    ArrayList list=new ArrayList();
   String userName;
    List<String> messageList=new ArrayList<>();
    List<String> timeList=new ArrayList<>();
    UILApplication appState;
    TextView nameTextVw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        listView=(ListView)findViewById(R.id.listVw);
        nameTextVw=(TextView)findViewById(R.id.nameTextVw);
        appState=(UILApplication)getApplicationContext();
        list  =appState.getJsondataList();
        userName=getIntent().getExtras().get("USERNAME").toString();

        nameTextVw.setText(userName);

        // messageAdapter=new MessageAdapter(getApplicationContext());
        for(int i=0;i<list.size();i++){
            JSONObject jsonObject=(JSONObject)list.get(i);

            try {
                if (userName.equalsIgnoreCase(jsonObject.getString(FileUtils.USERNAME_KEY))) {

                    messageList.add(jsonObject.getString(FileUtils.BODY_KEY));
                    timeList.add(jsonObject.getString(FileUtils.MESSAGETIME_KEY));

                }
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
        messageAdapter=new MessageAdapter(getApplicationContext(),messageList,timeList);
        listView.setAdapter(messageAdapter);
    }


}
