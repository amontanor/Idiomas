package com.arubaapps.idiomas;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.arubaapps.idiomas.Activities.NewEventActivity;
import com.arubaapps.idiomas.Activities.ProfileActivity;
import com.arubaapps.idiomas.Activities.SearchActivity;

public class InicioActivity extends ActionBarActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private FloatingActionButton buttonNewEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Find our drawer view
        nvDrawer = (NavigationView) findViewById(R.id.nvView);

        // Setup drawer view
        setupDrawerContent(nvDrawer);

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setBackgroundColor(getResources().getColor(R.color.primaryColor));
        toolbar.setNavigationIcon(R.drawable.ic_reorder_white_48dp);
        //toolbar.getBackground().setAlpha(0);

        setSupportActionBar(toolbar);

        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //getWindow().setStatusBarColor(Color.TRANSPARENT);

        buttonNewEvento = (FloatingActionButton) findViewById(R.id.newEventButton);
        buttonNewEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), NewEventActivity.class);
                startActivity(intent);

            }
        });

        if (getSupportFragmentManager().findFragmentById(android.R.id.content) == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentInicio,
                            new InicioFragment()).commit();
        }
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        Intent intent = null;
                        switch (menuItem.getItemId()) {
                            case R.id.menu_seccion_main:
                                intent = new Intent(InicioActivity.this, InicioActivity.class);
                                break;
                            case R.id.menu_seccion_search:
                                intent = new Intent(InicioActivity.this, SearchActivity.class);
                                break;
                            case R.id.menu_seccion_new_event:
                                intent = new Intent(InicioActivity.this, NewEventActivity.class);
                                break;
                            case R.id.menu_seccion_profile:
                                intent = new Intent(InicioActivity.this, ProfileActivity.class);
                                break;
                            default:
                                intent = new Intent(InicioActivity.this, InicioActivity.class);
                        }

                        try {
                            startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        // Highlight the selected item has been done by NavigationView
                        menuItem.setChecked(true);
                        // Close the navigation drawer
                        mDrawer.closeDrawers();
                        return true;
                    }
                });
        mDrawer.closeDrawers();
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        //FragmentManager fragmentManager = getSupportFragmentManager();
        //fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // `onPostCreate` called when activity start-up is complete after `onStart()`
    // NOTE! Make sure to override the method with only a single `Bundle` argument
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }
}