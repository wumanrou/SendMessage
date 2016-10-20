package com.example.sendmessage;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText edTnum,edTMess;
	Button  btnsend;

	@Override
	public  void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//获取发送按钮
		btnsend=(Button)findViewById(R.id.btnsend);
		edTnum=(EditText)findViewById(R.id.edTnum);
		edTMess=(EditText)findViewById(R.id.edTMess);
		btnsend.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//获取收件人号码
				String mobile=edTnum.getText().toString();
				//获取短信内容
				String content=edTMess.getText().toString();
				Intent intent=new Intent();
				//设置Intent数据
				intent.setData(Uri.parse("smsto:"+mobile));
				//存放短信内容
				intent.putExtra("sms_body",content);
				startActivity(intent);
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
