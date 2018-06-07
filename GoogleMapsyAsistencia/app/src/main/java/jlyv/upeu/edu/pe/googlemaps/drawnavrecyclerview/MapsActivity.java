package jlyv.upeu.edu.pe.googlemaps.drawnavrecyclerview;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import jlyv.upeu.edu.pe.googlemaps.R;
import jlyv.upeu.edu.pe.googlemaps.dao.EventoDao;
import jlyv.upeu.edu.pe.googlemaps.to.EventoTO;

//import pe.edu.upeu.dao.EventoDao;
//import pe.edu.upeu.to.EventoTO;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private EventoDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        dao=new EventoDao(this);
        List<EventoTO> evento=dao.ListarEvento();
        // Add a marker in Sydney and move the camera

        for (EventoTO eventox: evento ) {
            LatLng sydney = new LatLng(eventox.getLatitud(), eventox.getLongitud());
            mMap.addMarker(new MarkerOptions().position(sydney).title(eventox.getLugarevento()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }

        //-15.507742, -70.169037
        LatLng sydnex = new LatLng(-15.507742, -70.169037);
        mMap.addMarker(new MarkerOptions().position(sydnex).title("Juliaca"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydnex));
    }
}
