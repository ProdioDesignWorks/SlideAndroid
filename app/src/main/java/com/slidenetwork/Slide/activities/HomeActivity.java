package com.slidenetwork.Slide.activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.slidenetwork.Slide.R;
import com.slidenetwork.Slide.fragments.SignupFragment;
import com.slidenetwork.Slide.utils.Constants;
import com.slidenetwork.Slide.utils.SharedPreferencesManager;
import com.slidenetwork.Slide.utils.Toolbox;

public class HomeActivity extends Activity {

    Button btnGetStarted, btnAddCard;
    private WalletState walletstate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnGetStarted = (Button) findViewById(R.id.btnGetStarted);
        btnGetStarted.setVisibility(View.GONE);
        btnAddCard = (Button) findViewById(R.id.btnAddCard);
        btnAddCard.setVisibility(View.GONE);

        String Token = SharedPreferencesManager.getString(HomeActivity.this, Constants.PREFS_AUTHTOKEND, "");
        Toolbox.writeToLog("Home Activity Token " + Token);

        walletstate = WalletState.WalletStateInitial;
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b != null) {
            String StrWalletState = (String) b.get("walletState");
            if (StrWalletState.equalsIgnoreCase("WalletStateCheckUser")) {
                walletstate = WalletState.WalletStateCheckUser;
                btnAddCard.setVisibility(View.VISIBLE);
                setNextState();
            }
        } else {
            //If Token is Available then Change the Wallet State else show Default Screen
            if (Token.length() > 0) {
                walletstate = WalletState.WalletStateFetchUser;
                btnAddCard.setVisibility(View.VISIBLE);
                setNextState();
            } else {
                setNextState();
            }
        }


        // On Get Started Click Open the ActionSheeet for Login Type
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SignupFragment sf = new SignupFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.SignInActionSheet, sf);
                transaction.commit();
            }
        });

    }

    public  void setNextState(){

        if(walletstate == WalletState.WalletStateInitial || walletstate == WalletState.WalletStateNonSecure){
            btnGetStarted.setVisibility(View.VISIBLE);
        } else if (walletstate == WalletState.WalletStateCheckUser) {
            String Token = SharedPreferencesManager.getString(HomeActivity.this, Constants.PREFS_AUTHTOKEND, "");
            if (Token.length() > 0) {
                walletstate = WalletState.WalletStateFetchUser;
                setNextState();
            }
        } else if (walletstate == WalletState.WalletStateFetchUser) {


        } else if (walletstate == WalletState.WalletStateFetchAndCheckCards) {


        }

    }


    public enum WalletState {
        WalletStateInitial,
        WalletStateCheckSlideToken,
        WalletStateNonSecure,
        WalletStateFetchFacebookAccessToken,
        WalletStateFetchGoogleAccessToken,
        WalletStateRefreshToken,
        WalletStateCheckUser,
        WalletStateFetchUser,
        WalletStateFetchAndCheckCards,
        WalletStateEmptyWallet,
        WalletStateShowWallet,
        WalletStateCardDetail,
        WalletStatePayNow,
        WalletStateShowTerms
    }


}
