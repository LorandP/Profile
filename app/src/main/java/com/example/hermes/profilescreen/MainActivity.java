package com.example.hermes.profilescreen;

import android.os.Handler;
import android.os.Looper;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity{
    private Toolbar mToolbar;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.customToolbar);
        setSupportActionBar(mToolbar);
        setTitle("");
        mToolbar.setNavigationIcon(R.mipmap.back_icon);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewShiftDisable.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.profile:
                        fragment = new FirstFragment();
                        break;
                    case R.id.friends:
                        fragment = new SecondFragment();
                        break;
                    case R.id.circle:
                        fragment = new ThirdFragment();
                        break;
                    case R.id.settings:
                        fragment = new ForthFragment();
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, fragment);
                transaction.commitNow();
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        setMenuIconsInMiddle(bottomNavigationView);
                    }
                });
                return true;
            }

        });
        bottomNavigationView.setSelectedItemId(R.id.profile);
    }

    /**
     *  This method is used to set margins for all the icons in the menu that is used in the
     * bottom navigation view.
     * @param navigationView an instance of the Bottom navigation view that holds the menu with
     *                       the icons.
     */
    public void setMenuIconsInMiddle(BottomNavigationView navigationView){
        // Luam o instanta de meniu si returnam view-ul in care el se afla
        BottomNavigationMenuView menuView = (BottomNavigationMenuView)navigationView.getChildAt(0);

        // Cu getChildCount luam cate view-uri de tip meniu sunt in view-ul in care ele se afla
        for(int index = 0; index <menuView.getChildCount(); index++){
            // Tinem cate o icoana din meniu
            final View iconView = menuView.getChildAt(index).findViewById(android.support.design.R.id.icon);

            // Luam parametri de margini din viewGroup-ul in care se afla icoana din meniu
            final ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams)iconView.getLayoutParams();

            // Setam parametri pentru margins
            layoutParams.setMargins(0,0,0,0);

            // Facem re-draw la layout
            navigationView.requestLayout();
        }
    }

}
