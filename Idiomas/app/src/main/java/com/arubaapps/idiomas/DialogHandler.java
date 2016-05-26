package com.arubaapps.idiomas;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.view.ContextThemeWrapper;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Antonio_2 on 23/05/2016.
 */
public class DialogHandler extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    public void setContext(Context context) {
        this.context = context;
    }

    Context context;

    public DialogHandler(){
    }



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        TimePickerDialog dialog= new TimePickerDialog(new ContextThemeWrapper(getActivity(),R.style.AppTheme), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
        // Create a new instance of TimePickerDialog and return it
        return dialog;
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user
        Toast.makeText(context, "your time is selected", Toast.LENGTH_LONG).show();
    }
}