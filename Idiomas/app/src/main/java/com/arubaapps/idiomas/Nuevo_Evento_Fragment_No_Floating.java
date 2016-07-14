package com.arubaapps.idiomas;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;

import java.util.ArrayList;
import java.util.List;

public class Nuevo_Evento_Fragment_No_Floating extends Fragment {

    Spinner spnCountry1,spnCountry2;
    private PlaceAutocompleteFragment placeAutocompleteFragment;
    private TextView calendarTextView;
    private ImageView imgCancelar;

    private OnFragmentInteractionListener mListener;

    public Nuevo_Evento_Fragment_No_Floating() {
    }

    public static Nuevo_Evento_Fragment_No_Floating newInstance(String param1, String param2) {
        Nuevo_Evento_Fragment_No_Floating fragment = new Nuevo_Evento_Fragment_No_Floating();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_nuevo_evento, menu);
        super.onCreateOptionsMenu(menu, inflater);
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
        View view = inflater.inflate(R.layout.fragment_nuevo_evento_no_floating, container, false);

        //find Spinner by id
        spnCountry1=(Spinner)view.findViewById(R.id.spnCountry1);
        spnCountry2=(Spinner)view.findViewById(R.id.spnCountry2);

        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment) getActivity().getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        calendarTextView = (TextView)view.findViewById(R.id.calendarTextView);
        calendarTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogHandler newFragment = new DialogHandler();
                newFragment.setContext(getContext());
                newFragment.show(getFragmentManager() , "time_Picker");
            }
        });


        // Create array for spinner image icon
        final Integer[] images = { R.drawable.es,R.drawable.us,R.drawable.jp,R.drawable.cn};

        final List listImages;

        // add data in listRowItems;
        listImages = new ArrayList();
        for (int i = 0; i < images.length; i++) {
            SpinnerRowFlags item = new SpinnerRowFlags(images[i]);
            listImages.add(item);
        }

        // create object of CustomSpinnerAdapter
        CustomSpinnerFlagAdapter customSpinnerAdapter= new CustomSpinnerFlagAdapter(getContext(), R.layout.spinner_item_row, listImages);

        //set adapter on spinner
        spnCountry1.setAdapter(customSpinnerAdapter);
        spnCountry2.setAdapter(customSpinnerAdapter);

        //Spinner setOnItemSelectedListener
        spnCountry1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView parent) {

            }
        });
        //Spinner setOnItemSelectedListener
        spnCountry2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView parent) {

            }
        });

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();

        android.app.Fragment fragment = getActivity().getFragmentManager()
                .findFragmentById(R.id.place_autocomplete_fragment);
        if (null != fragment) {
            android.app.FragmentTransaction ft = getActivity()
                    .getFragmentManager().beginTransaction();
            ft.remove(fragment);
            ft.commit();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}