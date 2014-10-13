package com.example.espresso.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText idView = (EditText) findViewById(R.id.editText1);
        final EditText passView = (EditText) findViewById(R.id.editText2);
        final TextView statusView = (TextView) findViewById(R.id.textView3);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                statusView.setText("");
                String id = idView.getText().toString();
                if (TextUtils.isEmpty(id)) {
                    statusView.setText("ID‚ª“ü—Í‚³‚ê‚Ä‚¢‚Ü‚¹‚ñ");
                    return;
                }
                String pass = passView.getText().toString();
                if (TextUtils.isEmpty(pass)) {
                    statusView.setText("Password‚ª“ü—Í‚³‚ê‚Ä‚¢‚Ü‚¹‚ñ");
                    return;
                }

                if (check(id, pass)) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                } else {
                    statusView.setText("ID‚ÆPassword‚Ì‘g‚İ‡‚í‚¹‚ªˆá‚¢‚Ü‚·");
                }
            }
        });
    }

    boolean check(String id, String pass) {
        // dummy
        return true;
    };
}
