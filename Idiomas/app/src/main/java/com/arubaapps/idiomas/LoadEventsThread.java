package com.arubaapps.idiomas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoadEventsThread extends AsyncTask<String, String, String> {

    HttpURLConnection urlConnection;
    String urlJson = "http://s425938729.mialojamiento.es/webs/idiomas/" + actividad.getResources().getString(R.string.API).toString() + "events/" + getUserId();
    private String Content;
    private boolean existEvents;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int userId;
    private static Activity actividad;

    ProgressDialog mProgress;

    public boolean isExistEvent() {
        return existEvents;
    }

    public void setActividad(Activity actividad) {
        this.actividad = actividad;
    }

    public void onPreExecute() {
        mProgress = ProgressDialog.show(actividad, actividad.getString(R.string.cargando), actividad.getString(R.string.espere), true);
        mProgress.show();
    }

    @Override
    protected String doInBackground(String... args) {

        StringBuilder result = new StringBuilder();

        try {
            //URL url = new URL(urlJson+"&mail="+mail+"&password="+password);
            URL url = new URL(urlJson);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;

            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            /****************** Start Parse Response JSON Data *************/

            String OutputData = "";
            JSONObject jsonResponse;

            /****** Creates a new JSONObject with name/value mappings from the JSON string. ********/
            jsonResponse = new JSONObject(result.toString());

            /***** Returns the value mapped by name if it exists and is a JSONArray. ***/
            /*******  Returns null otherwise.  *******/
            JSONArray jsonMainNode = jsonResponse.optJSONArray("Events");

            /*********** Process each JSON Node ************/

            int lengthJsonArr = jsonMainNode.length();

            if (jsonMainNode.length() == 0) {
                existEvents = false;
            } else {
                existEvents = true;
            }

            if (!existEvents) {
                return null;
            }

            for (int i = 0; i < lengthJsonArr; i++) {
                /****** Get Object for each JSON node.***********/
                JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);

                Log.v(i + "AdsId", jsonMainNode.getJSONObject(i)
                        .getString("AdsId"));

            }
            /****************** End Parse Response JSON Data *************/

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }


        return result.toString();
    }

    @Override
    protected void onPostExecute(String result) {

        mProgress.dismiss();

        if (!existEvents) {
            Toast.makeText(actividad, actividad.getString(R.string.noLogin),
                    Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(actividad, InicioActivity.class);
            actividad.startActivity(intent);
        }
    }

}