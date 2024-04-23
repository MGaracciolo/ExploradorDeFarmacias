package com.nela.exploradordefarmacias.ui.farmacias;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.nela.exploradordefarmacias.R;
import com.nela.exploradordefarmacias.models.Farmacia;

import java.util.ArrayList;
import java.util.List;

public class FarmaciasViewModel extends AndroidViewModel {
    private MutableLiveData<List<Farmacia>> mutableFarmacia;
    public FarmaciasViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Farmacia>> getMutableFarmacia(){
        if (mutableFarmacia==null){
            mutableFarmacia = new MutableLiveData<>();
        }
        return mutableFarmacia;
    }
    public void crearLista(){
        ArrayList<Farmacia> lista=new ArrayList<>();
        lista.add(new Farmacia("Farmacia Marquez","Av. Juan Héctor Jara 936","08:30 a 20:00", R.drawable.marquez, -37.97882741808184, -57.56567963750923));
        lista.add(new Farmacia("Farmacia Pereira","Av. Constitución 4375","Lunes a Viernes de 09:00 a 21:00",R.drawable.pereira,-37.966918899783884, -57.546948723673964));
        lista.add(new Farmacia("Farmacia Atlántica","Av. Independencia 514", "Lunes a Domingo de 09:00 a 22:00", R.drawable.atlantica,-37.987079982910096, -57.54514488287134));
        lista.add(new Farmacia("Farmacia del Aguila","Av. Pedro Luro 4610", "Lunes a Sábado de 08:30 a 22:00", R.drawable.aguila, -37.98822100325487, -57.56664651641362));
        lista.add(new Farmacia("Farmacia Cecilia Pereira","Av. Pedro Luro 4824","Sin información", R.drawable.cecilia,-37.98646217664994, -57.56901394689483));
        lista.add(new Farmacia("Farmacia San Juan", "Belgrano 4250", "Lunes a Sábado de 08:30 a 13:30 y de 16:00 a 20:30",R.drawable.sanjuan,-37.992314737703666, -57.564890888339505));
        lista.add(new Farmacia("Farmacia y Perfumeria Herrero","Av. Juan Héctor Jara 1842","Sin información",R.drawable.herrero,-37.98817830446293, -57.57178140186162));
        lista.add(new Farmacia("Farmacia Oliveri","Av. Pedro Luro 4102", "Lunes a Sábado de 08:30 a 20:00",R.drawable.oliveri,-37.99072056115874, -57.561413675719606));
        lista.add(new Farmacia("Farmacia Molina","San Juan 1299", "Lunes a Viernes de 09:00 a 21:30",R.drawable.molina,-37.987411346749326, -57.56059079234988));

        mutableFarmacia.setValue(lista);


    }

}