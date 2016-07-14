package com.arubaapps.idiomas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

import java.util.ArrayList;
import java.util.List;

public class Nuevo_Evento_Fragment extends DialogFragment {

    Spinner spnCountry1,spnCountry2;

    private OnFragmentInteractionListener mListener;

    public Nuevo_Evento_Fragment() {
    }

    public static Nuevo_Evento_Fragment newInstance(String param1, String param2) {
        Nuevo_Evento_Fragment fragment = new Nuevo_Evento_Fragment();
        Bundle args = new Bundle();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nuevo_evento, container, false);

        //find Spinner by id
        spnCountry1=(Spinner)view.findViewById(R.id.spnCountry1);
        spnCountry2=(Spinner)view.findViewById(R.id.spnCountry2);

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
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}