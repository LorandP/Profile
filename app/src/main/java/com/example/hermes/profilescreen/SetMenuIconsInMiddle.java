package com.example.hermes.profilescreen;

import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Hermes on 12/06/2017.
 *
 * This class is used to set margins for all the icons in the menu that is used in the
 * bottom navigation view.
 */

public class SetMenuIconsInMiddle {

    public static void setMenuIconsInMiddle(BottomNavigationView view){
        // Luam o instanta de meniu si returnam view-ul in care el se afla
        BottomNavigationMenuView menuView = (BottomNavigationMenuView)view.getChildAt(0);

        // Cu getChildCount luam cate view-uri de tip meniu sunt in view-ul in care ele se afla
        for(int index = 0; index <menuView.getChildCount(); index++){

            // Tinem cate o icoana din meniu
            final View iconView = menuView.getChildAt(index).findViewById(android.support.design.R.id.icon);

            // Luam parametri de margini din viewGroup-ul in care se afla icoana din meniu
            final ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams)iconView.getLayoutParams();

            // Setam parametri pentru margins
            layoutParams.setMargins(0,50,0,0);

            // Facem re-draw la layout
            view.requestLayout();
        }
    }
}
