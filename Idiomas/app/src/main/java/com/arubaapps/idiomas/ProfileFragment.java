package com.arubaapps.idiomas;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class ProfileFragment extends Fragment {

    private static final String KEY_POSITION="position";
    private ActionBar.Tab tabLayout;
    android.support.v7.app.ActionBar.Tab tabMyLanguage, tabAll;

    ActionBar.Tab tab1,tab2;
    android.app.Fragment search1, search2;

    public ProfileFragment() {
    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home ) {
            super.getActivity().onBackPressed();
        }
        // other menu select events may be present here

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View result=inflater.inflate(R.layout.fragment_profile, container, false);

        return(result);

    }

    static ProfileFragment newInstance(int position) {
        ProfileFragment frag=new ProfileFragment();
        Bundle args=new Bundle();
        args.putInt(KEY_POSITION, position);
        frag.setArguments(args);
        return(frag);
    }

}