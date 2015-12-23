package com.chheang.chuunibyou;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;

import com.chheang.chuunibyou.Framents.WelcomeFragment;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        //nothing
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        //clear backstack
        FragmentManager fm = getFragmentManager();
        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }

        //make a new fragment
        switch(tab.getPosition()){
            case 0:
                break;
            default:
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        //nothing
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            Log.i("MainActivity", "popping backstack");
            fm.popBackStack();
        } else {
            Log.i("MainActivity", "nothing on backstack, calling super");
            super.onBackPressed();
        }
    }

    private void initialize(){
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_bar);
        tabLayout.addTab(tabLayout.newTab().setText("Stories"));
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_story);
        tabLayout.addTab(tabLayout.newTab().setText("Me"));
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_user);
        tabLayout.addTab(tabLayout.newTab().setText("Friends"));
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_friends);
        tabLayout.addTab(tabLayout.newTab().setText("Sounds"));
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_sounds);
        tabLayout.addTab(tabLayout.newTab().setText("Videos"));
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_videos);
        tabLayout.setOnTabSelectedListener(this);

        //make welcome screen
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        WelcomeFragment welcome = new WelcomeFragment();
        ft.add(R.id.fragment_view, welcome, "Welcome");
        ft.commit();
    }
}
