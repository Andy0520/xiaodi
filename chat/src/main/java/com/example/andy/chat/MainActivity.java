package com.example.andy.chat;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
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
                Msg ms1g=new Msg(bean.getText(),Msg.TYPE_RECEIVED);
                msgList.add(ms1g);
                adapter.notifyDataSetChanged();
            }
        };
//        initMsgs();//初始化消息数据
        Msg msg=new Msg("Hello guy! Are you逗比思密达？",Msg.TYPE_RECEIVED);
        msgList.add(msg);
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
                    adapter.notifyDataSetChanged();//当有新消息时，刷新ListView中的显示
                    msgListView.setSelection(msgList.size()); //将ListView定位到最后一行
                    inputText.setText(""); //清空输入框中的内容
                    InputMethodManager imm = (InputMethodManager) getApplicationContext()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm.isActive())  //一直是true
                        imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
                                InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        });
    }

//    private void initMsgs() {
//        Msg msg1=new Msg("Hello guy",Msg.TYPE_RECEIVED);
//        msgList.add(msg1);
//    }
}
