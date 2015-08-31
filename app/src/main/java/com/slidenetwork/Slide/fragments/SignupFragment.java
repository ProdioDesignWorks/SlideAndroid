package com.slidenetwork.Slide.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.slidenetwork.Slide.R;
import com.slidenetwork.Slide.activities.SigninWithEmailActivity;


public class SignupFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.signuplayout, container, false);

        Button btnClose = (Button) v.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getActivity().getFragmentManager().beginTransaction().remove(SignupFragment.this).commit();
            }
        });



        Button btnEmail = (Button) v.findViewById(R.id.btnEmail);
        btnEmail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                Intent fbIntent = new Intent(getActivity(), SigninWithEmailActivity.class);
                startActivity(fbIntent);
            }
        });

        Button btnFb = (Button) v.findViewById(R.id.btnFb);
        btnFb.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        Button btnGoogle = (Button) v.findViewById(R.id.btnGoogle);
        btnGoogle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        return v;
    }

}
