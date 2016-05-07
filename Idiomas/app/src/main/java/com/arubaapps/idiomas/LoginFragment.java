package com.arubaapps.idiomas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class LoginFragment extends Fragment implements
        View.OnClickListener{

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View result=inflater.inflate(R.layout.fragment_login, container, false);
        result.findViewById(R.id.buttonLogin).setOnClickListener(this);

        return result;
    }

    @Override
    public void onClick(View v) {
        Context context = getActivity().getApplicationContext();
        Toast.makeText(context, "Hello toast!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
