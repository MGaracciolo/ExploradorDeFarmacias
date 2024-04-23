package com.nela.exploradordefarmacias.ui.farmacias;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nela.exploradordefarmacias.MainActivity;
import com.nela.exploradordefarmacias.R;
import com.nela.exploradordefarmacias.databinding.FragmentFarmaciasBinding;
import com.nela.exploradordefarmacias.models.Farmacia;
import com.nela.exploradordefarmacias.models.FarmaciaAdapter;

import java.util.List;


public class FarmaciasFragment extends Fragment {

    private FragmentFarmaciasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FarmaciasViewModel mv =
                new ViewModelProvider(this).get(FarmaciasViewModel.class);

        binding = FragmentFarmaciasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mv.getMutableFarmacia().observe(getViewLifecycleOwner(), new Observer<List<Farmacia>>() {
            @Override
            public void onChanged(List<Farmacia> farmacias) {
                FarmaciaAdapter pa=new FarmaciaAdapter(requireContext(), R.layout.card,farmacias,getLayoutInflater());
                RecyclerView rv= binding.vista;
                GridLayoutManager glm=new GridLayoutManager((getContext()),1,GridLayoutManager.VERTICAL,false);
                rv.setLayoutManager(glm);
                rv.setAdapter(pa);
            }
        });

        mv.crearLista();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}