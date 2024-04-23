package com.nela.exploradordefarmacias.models;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.nela.exploradordefarmacias.R;
import com.nela.exploradordefarmacias.ui.farmacias.FarmaciaFragment;

import java.util.List;


public class FarmaciaAdapter extends RecyclerView.Adapter<FarmaciaAdapter.ViewHolder> {
    private List<Farmacia> lista;
    private Context context;
    private LayoutInflater li;
    private int card;
    public FarmaciaAdapter(@NonNull Context context, int card, @NonNull List<Farmacia> listado, LayoutInflater li) {
        this.lista=listado;
        this.context=context;
        this.li=li;
        this.card=card;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Farmacia farmacia=lista.get(position);
        holder.tvNombre.setText(farmacia.getNombre());
        holder.tvDireccion.setText(farmacia.getDireccion());
        holder.Foto.setImageResource(farmacia.getFoto());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("farmacia", farmacia);
                Navigation.findNavController((Activity) context,R.id.nav_host_fragment_content_main).navigate(R.id.farmaciaFragment,bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNombre;
        private TextView tvDireccion;
        private ImageView Foto;
        private ConstraintLayout card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre=itemView.findViewById(R.id.tvNombre);
            tvDireccion=itemView.findViewById(R.id.tvDireccion);
            Foto=itemView.findViewById(R.id.Foto);
            card = itemView.findViewById(R.id.card);
        }
    }
    public int getCount(){
        return lista.size();
    }
}



