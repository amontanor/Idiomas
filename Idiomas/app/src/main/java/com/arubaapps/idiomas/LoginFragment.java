package com.arubaapps.idiomas;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class LoginFragment extends Fragment implements
        View.OnClickListener{

    private LoginThread task;
    private String mail;
    private String password;
    private EditText editMail;
    private EditText editPass;


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

        editMail =(EditText)result.findViewById(R.id.editUser);
        editPass =(EditText)result.findViewById(R.id.editPass);

        return result;
    }

    @Override
    public void onClick(View v) {
        mail = editMail.getText().toString();
        password = editPass.getText().toString();

        task=new LoginThread();
        task.setMail(mail);
        task.setPassword(md5(password));
        task.setActividad(getActivity());
        task.execute();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    public static final String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}

