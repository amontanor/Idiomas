package com.arubaapps.idiomas;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    Fragment fragment ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentManager fm = getSupportFragmentManager();
        fragment = fm.findFragmentByTag("fragmentLogin");
        if (fragment == null) {
            FragmentTransaction ft = fm.beginTransaction();
            fragment =new LoginFragment();
            ft.add(android.R.id.content,fragment,"fragmentLogin");
            ft.commit();
        }

    }
}
