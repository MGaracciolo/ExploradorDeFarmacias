package com.nela.exploradordefarmacias.ui.configuracion;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.maps.GoogleMap;
import com.nela.exploradordefarmacias.R;
import com.nela.exploradordefarmacias.models.Farmacia;

import java.util.ArrayList;
import java.util.List;

public class ConfiguracionViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> mutableMapa;
    private MutableLiveData<Configuracion> mutableConfiguracion;
    private ArrayList<Configuracion> lista=new ArrayList<>();

    public ConfiguracionViewModel(@NonNull Application application) {
        super(application);
        lista.add(new Configuracion("Ingles","Map","Normal","Hybrid","Language","Español","English","Theme","Dark","Clear"));
        lista.add(new Configuracion("Español","Mapa","Normal","Hibrido","Lenguaje","Español","English","Tema","Oscuro","Claro"));
    }

    public LiveData<Integer> getMutableMapa(){
        if (mutableMapa==null){
            mutableMapa= new MutableLiveData<>();
        }
        return mutableMapa;
    }
    public LiveData<Configuracion> getMutableConfiguracion(){
        if (mutableConfiguracion==null){
            mutableConfiguracion= new MutableLiveData<>();
        }
        return mutableConfiguracion;
    }
    public void elegirConfiguracion(String c){
        for (Configuracion configuracion : lista){
            if(configuracion.getConf().equalsIgnoreCase(c)){
                mutableConfiguracion.setValue(configuracion);
            }
        }
    }
    public void obtenerTipoMapa(Boolean uno, Boolean dos ) {
        if(uno){
            mutableMapa.setValue(GoogleMap.MAP_TYPE_NORMAL);
        }
        if(dos){
            mutableMapa.setValue(GoogleMap.MAP_TYPE_HYBRID);
        }
        /*
        switch (checkedId) {
            case 1:
                mutableMapa.setValue(GoogleMap.MAP_TYPE_NORMAL);

                break;
            case 2:
                mutableMapa.setValue(GoogleMap.MAP_TYPE_HYBRID);
                break;
        }*/
    }
}