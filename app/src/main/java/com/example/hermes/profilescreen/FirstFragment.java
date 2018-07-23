package com.example.hermes.profilescreen;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by Hermes on 08/06/2017.
 * Here we create a fragment for the second bottom navigation button and we inflate it with the
 * proper layout.
 */

public class FirstFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.profile_layout,null,false);
        //Here we set a view to the fragment
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toolbar mToolbar;
        mToolbar = (Toolbar)view.findViewById(R.id.customToolbar);
        mToolbar.setNavigationIcon(R.mipmap.back_icon);
        ListView listView = (ListView)view.findViewById(R.id.list_of_infromation);

        //The fragment doesn't have a context so we have to sepcify getContext
        CustomAdapter customAdapter = new CustomAdapter(arrayOfData(), getContext());
        listView.setAdapter(customAdapter);
    }

    public ArrayList<DataObject> arrayOfData (){
        ArrayList<DataObject> arrayList = new ArrayList<DataObject>();

        DataObject webPageText = new DataObject();
        webPageText.setmWebpage("www.thearktech.com");
        webPageText.setmEmail("lorand.palfalvi@thearktech.eu");
        webPageText.setmBirthday("January 18, 1991");
        arrayList.add(webPageText);

        return arrayList;
    }
}
