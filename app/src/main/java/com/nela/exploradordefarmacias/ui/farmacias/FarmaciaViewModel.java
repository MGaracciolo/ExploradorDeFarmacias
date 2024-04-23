package com.nela.exploradordefarmacias.ui.farmacias;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nela.exploradordefarmacias.models.Farmacia;

import java.util.List;

public class FarmaciaViewModel extends AndroidViewModel {
    private MutableLiveData<Farmacia> mutableFarmacia;
    public FarmaciaViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Farmacia> getMutableFarmacia(){
        if (mutableFarmacia==null){
            mutableFarmacia = new MutableLiveData<>();
        }
        return mutableFarmacia;
    }
    public void recuperarFarmacia(Bundle bundle){
        Farmacia farmacia= null;
        if (bundle != null) {
            farmacia = (Farmacia) bundle.getSerializable("farmacia");
        }
        if (farmacia != null){
            mutableFarmacia.setValue(farmacia);
        }
    }
}