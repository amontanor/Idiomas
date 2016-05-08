package com.arubaapps.idiomas;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by vrs on 3/9/15.
 */
public class Card_Eventos_Adapter extends RecyclerView.Adapter<Card_Eventos_Adapter.ViewHolder> {

    List<Evento> list = new ArrayList<>();

    public Card_Eventos_Adapter(List<Evento> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_eventos, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.evento = getItem(position);
        holder.texto.setText(list.get(position).texto);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public Evento getItem(int i) {
        return list.get(i);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView texto;
        Evento evento;

        public ViewHolder(View itemView) {
            super(itemView);
            texto = (TextView) itemView.findViewById(R.id.texto);
        }
    }
    // Remove a RecyclerView item containing a specified Data object
    public void remove(Evento evento) {
        int position = list.indexOf(evento);
        list.remove(position);
        notifyItemRemoved(position);
    }

}