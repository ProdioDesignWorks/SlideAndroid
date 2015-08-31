package com.slidenetwork.Slide.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.slidenetwork.Slide.R;
import com.slidenetwork.Slide.api.APIGetToken;
import com.slidenetwork.Slide.api.entities.APIPatchToken;
import com.slidenetwork.Slide.api.entities.email_token_response.EmailTokenResponse;
import com.slidenetwork.Slide.api.entities.patch_token.PatchTokenResponse;
import com.slidenetwork.Slide.utils.Constants;
import com.slidenetwork.Slide.utils.SharedPreferencesManager;
import com.slidenetwork.Slide.utils.Toolbox;
import com.slidenetwork.Slide.utils.Utility;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Header;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;


public class SigninWithEmailActivity extends Activity {


    EditText emailValidate;
    Callback<EmailTokenResponse> emailTokenResponseCallback = new Callback<EmailTokenResponse>() {
        @Override
        public void success(EmailTokenResponse o, Response response) {
            Toolbox.writeToLog("Retrofit response success" + response.getBody());
            String token_id = o.getData().getId();
            SharedPreferencesManager.writeString(SigninWithEmailActivity.this, Constants.PREFS_TOKENID, token_id);
            printHeaders(response.getHeaders());
            JSONObject ResponseData = new JSONObject();
            JSONObject metaObj = new JSONObject();
            JSONArray messageArr = new JSONArray();
            JSONObject messageObj = new JSONObject();
            JSONObject userDetailsObj = new JSONObject();


            try {
                ResponseData = new JSONObject(new String(((TypedByteArray) response.getBody()).getBytes()));
                Toolbox.writeToLog("Retrofit response Status " + ResponseData);
                metaObj = ResponseData.getJSONObject("meta");
                messageArr = metaObj.getJSONArray("messages");
                messageObj = messageArr.getJSONObject(0);


            } catch (JSONException e) {
                e.printStackTrace();
            }


            if (response.getStatus() == 202) {
                Intent intent = new Intent(getBaseContext(), EmailVerify.class);
                try {
                    userDetailsObj = messageObj.getJSONObject("user_detail");
                    intent.putExtra("email", userDetailsObj.getString("email"));
                    intent.putExtra("email_subject", userDetailsObj.getString("email_subject"));
                    intent.putExtra("title", userDetailsObj.getString("title"));
                    intent.putExtra("message", userDetailsObj.getString("message"));
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else if (response.getStatus() == 201) {

                SharedPreferencesManager.writeString(SigninWithEmailActivity.this, Constants.PREFS_AUTHTOKEND, o.getData().getAccess_token());
                SharedPreferencesManager.writeString(SigninWithEmailActivity.this, Constants.PREFS_TOKEN_CREATED_AT, o.getData().getCreated_at());
                SharedPreferencesManager.writeString(SigninWithEmailActivity.this, Constants.PREFS_TOKEN_EXPIRES_AT, o.getData().getExpires_at());
                SharedPreferencesManager.writeString(SigninWithEmailActivity.this, Constants.PREFS_REFRESH_TOKEN, o.getData().getRefresh_token());

                GotoHomeActivity();
            }

        }

        @Override
        public void failure(RetrofitError error) {
            Toolbox.writeToLog("Retrofit errror " + error);
            printHeaders(error.getResponse().getHeaders());
        }
    };
    Callback<PatchTokenResponse> patchTokenResponseCallback = new Callback<PatchTokenResponse>() {
        @Override
        public void success(PatchTokenResponse patchTokenResponse, Response response) {
            Toolbox.writeToLog("Retrofit response success" + response.getStatus());
            printHeaders(response.getHeaders());
            SharedPreferencesManager.writeString(SigninWithEmailActivity.this, Constants.PREFS_AUTHTOKEND, patchTokenResponse.getData().getAccess_token());
            SharedPreferencesManager.writeString(SigninWithEmailActivity.this, Constants.PREFS_TOKEN_CREATED_AT, patchTokenResponse.getData().getCreated_at());
            SharedPreferencesManager.writeString(SigninWithEmailActivity.this, Constants.PREFS_TOKEN_EXPIRES_AT, patchTokenResponse.getData().getExpires_at());
            SharedPreferencesManager.writeString(SigninWithEmailActivity.this, Constants.PREFS_REFRESH_TOKEN, patchTokenResponse.getData().getRefresh_token());

            GotoHomeActivity();


        }

        @Override
        public void failure(RetrofitError error) {
            Toolbox.writeToLog("Retrofit errror " + error);
            printHeaders(error.getResponse().getHeaders());

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_signin);

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        Intent in = getIntent();
        String data = in != null ? in.getStringExtra(Constants.DEEPLINK_TOKEN) : null;
        if (data != null) {
            Toolbox.writeToLog("Token from browser 3 " + data);
            String token_id = SharedPreferencesManager.getString(this, Constants.PREFS_TOKENID, null);
            if (token_id != null)
                APIPatchToken.patchAuthToken(token_id, Toolbox.getPatchRequest(data), patchTokenResponseCallback);
        } else {
            emailValidate = (EditText) findViewById(R.id.etEmail);

            Button btnClose = (Button) findViewById(R.id.btnClose);
            btnClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

            final Button btnNext = (Button) findViewById(R.id.btnNext);
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = emailValidate.getText().toString().trim();
                    if (Utility.isEmailValid(email)) {
                        APIGetToken.getAuthToken(Toolbox.getTokenRequest(SigninWithEmailActivity.this, email), emailTokenResponseCallback);
                    } else {
                        Toast.makeText(getApplicationContext(), "Please enter valid email Id.", Toast.LENGTH_LONG).show();
                    }
                }
            });


            emailValidate.addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable arg0) {
                    boolean isReady = emailValidate.getText().toString().length() > 0;
                    btnNext.setEnabled(isReady);
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }
            });
        }

    }

    private void printHeaders(List<Header> headers){
        for(Header h:headers){
            Toolbox.writeToLog("Retro Headers "+h.getName()+":"+h.getValue());
        }
    }


    public void GotoHomeActivity() {
        Intent homeIntent = new Intent(getBaseContext(), HomeActivity.class);
        homeIntent.putExtra("walletState", "WalletStateCheckUser");
        startActivity(homeIntent);
    }

}

