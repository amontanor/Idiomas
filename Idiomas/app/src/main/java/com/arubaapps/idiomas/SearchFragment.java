package com.arubaapps.idiomas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SearchFragment extends Fragment {


    public SearchFragment() {
    }

    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        ViewPager pager=(ViewPager)view.findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerSearch(getChildFragmentManager()));

        ((InicioActivity)getActivity()).getSupportActionBar().setTitle(R.string.Search);

        return view;
    }

}