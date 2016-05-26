package com.arubaapps.idiomas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class SearchMyResultFragment extends Fragment {

    private static final String KEY_POSITION="position";

    public SearchMyResultFragment() {
    }

    public static SearchMyResultFragment newInstance(String param1, String param2) {
        SearchMyResultFragment fragment = new SearchMyResultFragment();
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
        View result=inflater.inflate(R.layout.fragment_search_my_result, container, false);
        EditText editor=(EditText)result.findViewById(R.id.editor);
        int position=getArguments().getInt(KEY_POSITION, -1);
        editor.setHint(String.format("Prueba", position + 1));
        return(result);

    }

    static SearchMyResultFragment newInstance(int position) {
        SearchMyResultFragment frag=new SearchMyResultFragment();
        Bundle args=new Bundle();
        args.putInt(KEY_POSITION, position);
        frag.setArguments(args);
        return(frag);
    }

}