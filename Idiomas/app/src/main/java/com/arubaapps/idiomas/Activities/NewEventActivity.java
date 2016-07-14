package com.arubaapps.idiomas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.arubaapps.idiomas.InicioActivity;
import com.arubaapps.idiomas.Nuevo_Evento_Fragment_No_Floating;
import com.arubaapps.idiomas.R;

public class NewEventActivity extends ActionBarActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.primaryColor));
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_white_48dp);
        setSupportActionBar(toolbar);

        if (getSupportFragmentManager().findFragmentById(android.R.id.content) == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentNewEvent,
                            new Nuevo_Evento_Fragment_No_Floating()).commit();
        }
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home ) {
            Intent intent = new Intent(NewEventActivity.this, InicioActivity.class);
            startActivity(intent);
        }
        // other menu select events may be present here

        return super.onOptionsItemSelected(item);
    }
}