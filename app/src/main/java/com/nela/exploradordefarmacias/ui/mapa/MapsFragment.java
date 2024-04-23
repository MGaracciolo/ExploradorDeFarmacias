package com.nela.exploradordefarmacias.ui.mapa;

import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_NORMAL;
import static com.nela.exploradordefarmacias.ui.configuracion.ConfiguracionFragment.configuracionMapa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nela.exploradordefarmacias.R;
import com.nela.exploradordefarmacias.databinding.FragmentMapsBinding;
import com.nela.exploradordefarmacias.models.Farmacia;
import com.nela.exploradordefarmacias.ui.configuracion.ConfiguracionFragment;
import com.nela.exploradordefarmacias.ui.configuracion.ConfiguracionViewModel;
import com.nela.exploradordefarmacias.ui.farmacias.FarmaciasViewModel;

import java.util.List;

public class MapsFragment extends Fragment {
    private FragmentMapsBinding binding;
    private GoogleMap mapa;
    private MapsFragmentViewModel vm;
    private OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap googleMap) {
            mapa=googleMap;
            mapa.setMapType(ConfiguracionFragment.configuracionMapa);
            //googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,18));
        }
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(MapsFragmentViewModel.class);
        binding = FragmentMapsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        vm.getMLocation().observe(getViewLifecycleOwner(), new Observer<Location>() {
            @Override
            public void onChanged(Location location) {
                if(mapa!=null){
                    ///podria haber hecho una lista de LatLng? si
                    ///podria haber hecho una funcion mas abajo para que no se vea tan cargado? tambien
                    LatLng farmaciaDelAguila = new LatLng(-37.98822100325487, -57.56664651641362);
                    LatLng farmaciaCecilia= new LatLng(-37.98680041581002, -57.56866353764716);
                    LatLng farmaciaHerrero = new LatLng(-37.98796098709565, -57.57173883359667);
                    LatLng farmaciaSanJuan = new LatLng(-37.992414780043546, -57.56469431309199);
                    LatLng farmaciaOliveri = new LatLng(-37.99082240707737, -57.56177100829541);
                    LatLng farmaciaMarquez = new LatLng(-37.97882741808184, -57.56567963750923);
                    LatLng farmaciaPereira = new LatLng(-37.966918899783884, -57.546948723673964);
                    LatLng farmaciaAtlantica = new LatLng(-37.987079982910096, -57.54514488287134);
                    LatLng miUbi = new LatLng(location.getLatitude(), location.getLongitude());
                    mapa.addMarker(new MarkerOptions()
                            .position(miUbi)
                            .title("Marcador de mi ubicacion"));
                    mapa.addMarker(new MarkerOptions()
                            .position(farmaciaDelAguila)
                            .title("farmacia")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
                    mapa.addMarker(new MarkerOptions()
                            .position(farmaciaCecilia)
                            .title("farmacia")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
                    mapa.addMarker(new MarkerOptions()
                            .position(farmaciaHerrero)
                            .title("farmacia")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
                    mapa.addMarker(new MarkerOptions()
                            .position(farmaciaSanJuan)
                            .title("farmacia")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
                    mapa.addMarker(new MarkerOptions()
                            .position(farmaciaOliveri)
                            .title("farmacia")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
                    mapa.addMarker(new MarkerOptions()
                            .position(farmaciaAtlantica)
                            .title("farmacia")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
                    mapa.addMarker(new MarkerOptions()
                            .position(farmaciaPereira)
                            .title("farmacia")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
                    mapa.addMarker(new MarkerOptions()
                            .position(farmaciaMarquez)
                            .title("farmacia")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
                    mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(miUbi,15));
                }
                else{
                    Log.d("Errorcito","El mapa es nulo");
                }
            }
        });
        vm.obtenerUbicacion();
        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }


}