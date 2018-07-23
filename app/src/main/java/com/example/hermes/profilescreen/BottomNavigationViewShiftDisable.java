package com.example.hermes.profilescreen;

import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;

import java.lang.reflect.Field;

/**
 * Created by Hermes on 09/06/2017.
 *
 * This class is used to disable the shifting of menu items in the bottomNavigationView
 */
 class BottomNavigationViewShiftDisable {

     static void disableShiftMode(BottomNavigationView view){
        BottomNavigationMenuView menu = (BottomNavigationMenuView)view.getChildAt(0);
        try {
            Field shiftMode = menu.getClass().getDeclaredField("mShiftingMode");
            shiftMode.setAccessible(true);
            shiftMode.setBoolean(menu,false);
            shiftMode.setAccessible(false);
            for(int index = 0; index < menu.getChildCount(); index++){
                BottomNavigationItemView itemView = (BottomNavigationItemView)menu.getChildAt(index);
                //noinspection RestrictedApi
                itemView.setShiftingMode(false);
                //noinspection RestrictedApi
                itemView.setChecked(itemView.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("Helper","Unable to get field",e);
        }
        catch (IllegalAccessException e){
            Log.e("Helper","Unable to change value of shift mode",e);
        }
    }
}
