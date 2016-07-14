package com.arubaapps.idiomas;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class SearchAllEventsFragment extends Fragment {

    private static final String KEY_POSITION="position";
    private ActionBar.Tab tabLayout;
    android.support.v7.app.ActionBar.Tab tabMyLanguage, tabAll;

    ActionBar.Tab tab1,tab2;
    android.app.Fragment search1, search2;
    private ArrayList<Evento> eventos;
    private RecyclerView recyclerView;
    private Card_Eventos_Adapter adapter;
    private View result;

    public SearchAllEventsFragment() {
    }

    public static SearchAllEventsFragment newInstance(String param1, String param2) {
        SearchAllEventsFragment fragment = new SearchAllEventsFragment();
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

    private void loadAllEvents() {
        mockEvents();
    }

    private void mockEvents() {
        recyclerView = (RecyclerView) result.findViewById(R.id.events_recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(result.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);

        eventos = new ArrayList<>();
        eventos.add(new Evento("Eventaco 1"));
        eventos.add(new Evento("Eventaco 2"));
        eventos.add(new Evento("Eventaco 3"));
        eventos.add(new Evento("Eventaco 4"));
        eventos.add(new Evento("Eventaco 5"));

        adapter = new Card_Eventos_Adapter(eventos);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        result=inflater.inflate(R.layout.fragment_search_all_result, container, false);
        loadAllEvents();
        return(result);

    }

    static SearchAllEventsFragment newInstance(int position) {
        SearchAllEventsFragment frag=new SearchAllEventsFragment();
        Bundle args=new Bundle();
        args.putInt(KEY_POSITION, position);
        frag.setArguments(args);
        return(frag);
    }

}