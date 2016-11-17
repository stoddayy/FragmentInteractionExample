package com.apposing.fragmentinteractionexample;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements FragmentInteractionListener{

    FrameLayout frameLayout;
    FragmentManager fragMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout) findViewById(R.id.activity_main);
        fragMan = getSupportFragmentManager();
        setFragOne();

    }

    @Override
    public void setFragOne() {
        FragmentTransaction transaction = fragMan.beginTransaction();
        transaction.replace(frameLayout.getId(), FragOne.newInstance("", ""));
        transaction.commit();
    }

    @Override
    public void setFragTwo() {
        FragmentTransaction transaction = fragMan.beginTransaction();
        transaction.replace(frameLayout.getId(), FragTwo.newInstance("", ""));
        transaction.commit();
    }
}
