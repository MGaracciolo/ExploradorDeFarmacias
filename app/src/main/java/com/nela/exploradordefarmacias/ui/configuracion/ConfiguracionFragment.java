package com.nela.exploradordefarmacias.ui.configuracion;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.nela.exploradordefarmacias.R;
import com.nela.exploradordefarmacias.databinding.FragmentConfiguracionBinding;

import java.util.List;
import java.util.Objects;

public class ConfiguracionFragment extends Fragment {
    public static int configuracionMapa=1;
    private FragmentConfiguracionBinding binding;
    private RadioButton r1,r2;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ConfiguracionViewModel mv =
                new ViewModelProvider(this).get(ConfiguracionViewModel.class);

        binding = FragmentConfiguracionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        r1 = binding.rbEspanol;
        r2 = binding.rbEnglish;
        binding.rgTema.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.rbClaro.isChecked()){
                    requireActivity().setTheme(R.style.Theme_NavigationDrawer_Light);
                }
                if (binding.rbOscuro.isChecked()){
                    requireActivity().setTheme(R.style.Theme_NavigationDrawer_Night);
                }
            }
        });

        binding.rgMapa.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mv.getMutableMapa().observe(getViewLifecycleOwner(), new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer i) {
                        configuracionMapa= i;
                    }
                });
                //aca tuve que pasarle los atributos porq cuando le paso el checked id desde afuera del onchanged no me da el checkeado me da un numero re long
               mv.obtenerTipoMapa(binding.rbNormal.isChecked(),binding.rbHibrido.isChecked());

            }
        });
        binding.rgIdioma.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               mv.getMutableConfiguracion().observe(getViewLifecycleOwner(), new Observer<Configuracion>() {
                   @Override
                   public void onChanged(Configuracion configuracion) {

                       binding.tvMapa.setText(configuracion.getMapa());
                       binding.rbNormal.setText(configuracion.getNormal());
                       binding.rbHibrido.setText(configuracion.getHib());
                       binding.tvIdioma.setText(configuracion.getIdioma());
                       binding.tvTema.setText(configuracion.getTema());
                       binding.rbClaro.setText(configuracion.getClaro());
                       binding.rbOscuro.setText(configuracion.getOscuro());
                   }
               });//yo seeee que no deberia usar logica, pero me costo entender como usar los radiobutton,
                //tanto para los mapas como para todo el resto de las cosas, deberia haber usado
                //botones pero ya no me quedo tiempo para cambiar
               if (r1.isChecked()){
                   mv.elegirConfiguracion("Español");
               }
               if (r2.isChecked()){
                   mv.elegirConfiguracion("Ingles");
               }
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}