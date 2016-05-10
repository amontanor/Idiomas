package com.arubaapps.idiomas;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;


public class InicioFragment extends Fragment {
    private ImageView imagenPequeña;
    private ImageView imagenGrande;
    private Activity actividad;
    private FloatingActionButton buttonNewEvento;

    RecyclerView recyclerView;
    Card_Eventos_Adapter adapter;
    List<Evento> eventos;

    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        actividad = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View result = inflater.inflate(R.layout.fragment_inicio, container, false);

        buttonNewEvento = (FloatingActionButton) result.findViewById(R.id.newEvent);
        buttonNewEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create new fragment and transaction
                Fragment newFragment = new Nuevo_Evento_Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.contentInicio, newFragment);

                transaction.commit();
            }
        });

        imagenPequeña = (ImageView) result.findViewById(R.id.imageFotoPequeña);
        imagenPequeña.setImageBitmap(Herramientas.redondearImagen(BitmapFactory.decodeResource(actividad.getResources(),
                R.drawable.cara)));

        imagenGrande = (ImageView) result.findViewById(R.id.imageFotoGrande);
        imagenGrande.setImageDrawable(getResources().getDrawable(R.drawable.fondo));

        //Iniciamos las tarjetas
        recyclerView = (RecyclerView) result.findViewById(R.id.cardList);

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

