package com.example.espresso;

import com.example.espresso.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);

		String id = getIntent().getStringExtra("id");
		TextView tv = (TextView) findViewById(R.id.textView1);
		tv.setText("‚æ‚¤‚±‚»" + id + "‚³‚ñ");
	}
}