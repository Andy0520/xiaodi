package com.example.andy.chat;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private ListView msgListView;
    private EditText inputText;
    private Button send;
    private MsgAdapter adapter;
    private List<Msg> msgList=new ArrayList<Msg>();
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Log.d("TAG", msg.obj.toString());
                Gson gson=new Gson();
                Bean bean=gson.fromJson(msg.obj.toString(),Bean.class);
//                inputText.setText(bean.getText());
                Msg ms1g=new Msg(bean.getText(),Msg.TYPE_SENT);
                msgList.add(ms1g);
                adapter.notifyDataSetChanged();
            }
        };
//        initMsgs();//��ʼ����Ϣ����
        adapter=new MsgAdapter(MainActivity.this,R.layout.msg_item,msgList);
        inputText= (EditText) findViewById(R.id.input_text);
        send= (Button) findViewById(R.id.send);
        msgListView= (ListView) findViewById(R.id.msg_list_view);
        msgListView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content=inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg=new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    HttpUtil.doGet(handler, content);
                    adapter.notifyDataSetChanged();//��������Ϣʱ��ˢ��ListView�е���ʾ
                    msgListView.setSelection(msgList.size()); //��ListView��λ�����һ��
                    inputText.setText(""); //���������е�����
                }
            }
        });
    }

//    private void initMsgs() {
//        Msg msg1=new Msg("Hello guy",Msg.TYPE_RECEIVED);
//        msgList.add(msg1);
//    }
}
