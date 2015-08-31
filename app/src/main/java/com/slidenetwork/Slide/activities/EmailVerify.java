package com.slidenetwork.Slide.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.slidenetwork.Slide.R;

public class EmailVerify extends Activity {

    TextView tvTotxt, tvWelcome, tvSubHeader, tvActivateAndroid;
    Button btOpenEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verify);

        tvTotxt=(TextView) findViewById(R.id.tvToTxt);
        tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        tvSubHeader = (TextView) findViewById(R.id.tvSubHeader);
        tvActivateAndroid = (TextView) findViewById(R.id.tvActivateAndroid);

        btOpenEmail =(Button) findViewById(R.id.btnOpenEmail);

        Intent intent= getIntent();
        Bundle b = intent.getExtras();
        if(b!=null)
        {
            String StrEmailAddress =(String) b.get("email");
            String StrSubject = (String) b.get("email_subject");
            String StrTitle = (String) b.get("title");
            String StrMessage = (String) b.get("message");

            tvTotxt.setText(StrEmailAddress);
            tvWelcome.setText(StrTitle);
            tvSubHeader.setText(StrMessage);
            tvActivateAndroid.setText(StrSubject);

        }

        btOpenEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open Email
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_EMAIL);
                startActivity(intent);
            }
        });

    }

}
