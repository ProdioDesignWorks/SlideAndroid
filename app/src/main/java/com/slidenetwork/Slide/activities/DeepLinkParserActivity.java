package com.slidenetwork.Slide.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.slidenetwork.Slide.R;
import com.slidenetwork.Slide.utils.Constants;
import com.slidenetwork.Slide.utils.Toolbox;


public class DeepLinkParserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dummy_layout_deeplink);
        Intent intent=getIntent();
        String action=intent.getAction();
        String data=intent.getDataString();
        Toolbox.writeToLog("Token from browser " + data);
        Intent out=new Intent(DeepLinkParserActivity.this,SigninWithEmailActivity.class);
        out.putExtra(Constants.DEEPLINK_TOKEN,data=parseLinkData(data));
        Toolbox.writeToLog("Token from browser after " + data);
        startActivity(out);
        finish();
    }

    private String parseLinkData(String data){
        if(data==null) return data;
        if(data.contains("activate")){
            String[] split=data.split("/");
            int index=split.length>0?split.length-1:-1;
            if(index>-1) return split[index];
        }
        return null;
    }
}
