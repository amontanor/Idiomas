package com.arubaapps.idiomas;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arubaapps.idiomas.Activities.NewEventActivity;
import com.arubaapps.idiomas.Activities.SearchActivity;

import java.util.ArrayList;
import java.util.List;


public class InicioFragment extends Fragment {
    private ImageView imagenPequeña;
    private ImageView imagenGrande;
    private Activity actividad;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private DrawerLayout drawerLayout;
    private NavigationView navView;

    RecyclerView recyclerView;
    Card_Eventos_Adapter adapter;
    List<Evento> eventos;
    private LoadEventsThread task;

    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        actividad = activity;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_inicio, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.buttonSearch) {
           /* Create new fragment and transaction
            SearchFragment newFragment = new SearchFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.setCustomAnimations(R.anim.cien_cero,R.anim.cero_menos_cien);
            transaction.replace(R.id.contentInicio, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();*/

            Intent intent = new Intent(getActivity(), SearchActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View result = inflater.inflate(R.layout.fragment_inicio, container, false);

        //imagenPequeña = (ImageView) result.findViewById(R.id.imageFotoPequeña);
        //imagenPequeña.setImageBitmap(Herramientas.redondearImagen(BitmapFactory.decodeResource(actividad.getResources(),
                //R.drawable.cara)));

        imagenGrande = (ImageView) getActivity().findViewById(R.id.imageFotoGrande);
        imagenGrande.setImageDrawable(getResources().getDrawable(R.drawable.fondo));

        //Iniciamos las tarjetas
        recyclerView = (RecyclerView) result.findViewById(R.id.cardList);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(result.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);

        //Insertamos las tarjetas
        initializeData();
        adapter = new Card_Eventos_Adapter(eventos);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {

                eventos.remove(viewHolder.getAdapterPosition());
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }

            @Override
            public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int fromPos, RecyclerView.ViewHolder target, int toPos, int x, int y) {
                super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        return result;
    }

    private void initializeData() {
        eventos = new ArrayList<>();

        /*task=new LoadEventsThread();
        task.setUserId(1);
        task.setActividad(getActivity());
        task.execute();
*/
        eventos.add(new Evento("Eventaco 1"));
        eventos.add(new Evento("Eventaco 2"));
        eventos.add(new Evento("Eventaco 3"));
        eventos.add(new Evento("Eventaco 4"));
        eventos.add(new Evento("Eventaco 5"));
        eventos.add(new Evento("Eventaco 6"));
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}

