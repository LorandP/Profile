package com.example.hermes.profilescreen;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);
        mToolbar = (Toolbar)findViewById(R.id.customToolbar);
        setSupportActionBar(mToolbar);
        setTitle("");
       mToolbar.setNavigationIcon(R.mipmap.back_icon);

        final MenuItem profile_menu = (MenuItem)findViewById(R.id.profile);
        final MenuItem friends_menu = (MenuItem)findViewById(R.id.friends);
        final MenuItem circle_menu = (MenuItem)findViewById(R.id.circle);
        final MenuItem settings_menu = (MenuItem)findViewById(R.id.settings);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                return true;
            }
        });
        /*
                switch (item.getItemId()){
                    case R.id.profile:
                        profile_menu.setIcon(R.drawable.ic_people_outline_black_24dp);
                        break;
                    case R.id.friends:
                        friends_menu.setIcon(R.drawable.ic_person_outline_black_24dp);
                        break;
                    case R.id.circle:
                        circle_menu.setIcon(R.drawable.ic_panorama_fish_eye_black_24dp);
                        break;
                    case R.id.settings:
                        settings_menu.setIcon(R.drawable.setting_black);
                        break;
                }*/


    }
}
