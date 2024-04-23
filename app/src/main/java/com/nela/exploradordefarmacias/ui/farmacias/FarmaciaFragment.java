package com.nela.exploradordefarmacias.ui.farmacias;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.nela.exploradordefarmacias.databinding.FragmentFarmaciaBinding;
import com.nela.exploradordefarmacias.models.Farmacia;

public class FarmaciaFragment extends Fragment {
    private FarmaciaViewModel mv;
    private FragmentFarmaciaBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
            binding = FragmentFarmaciaBinding.inflate(inflater,container,false);
            View root = binding.getRoot();
            mv = new ViewModelProvider(this).get(FarmaciaViewModel.class);
            mv.getMutableFarmacia().observe(getViewLifecycleOwner(), new Observer<Farmacia>() {
                @Override
                public void onChanged(Farmacia farmacia) {
                    binding.NombreFarmacia.setText(farmacia.getNombre());
                    binding.direccionFarmacia.setText(farmacia.getDireccion());
                    binding.tvHorarios.setText(farmacia.getHorarios());
                    binding.fotoFarmacia.setImageResource(farmacia.getFoto());
                }
            });
        mv.recuperarFarmacia(getArguments());
        return root;
    }


}