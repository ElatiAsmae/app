package ma.ensaf.calculatorapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap gmap;
    FrameLayout map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_maps, container, false);
        map = rootView.findViewById(R.id.map);

        // Get the SupportMapFragment from the layout
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            getChildFragmentManager().beginTransaction().replace(R.id.map, mapFragment).commit();
        }

        // Set up the OnMapReadyCallback to be notified when the map is ready to be used
        mapFragment.getMapAsync(this);

        return rootView;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.gmap = googleMap;

        // ENSA locations in Morocco
        LatLng ensaCasablanca = new LatLng(33.5731, -7.5898);
        LatLng ensaRabat = new LatLng(34.0209, -6.8416);
        LatLng ensaAgadir = new LatLng(30.4220, -9.5595);
        LatLng ensaFes = new LatLng(34.0347, -5.0060);
        LatLng ensaOujda = new LatLng(34.6901, -1.8663);

        // Add markers for each ENSA campus
        gmap.addMarker(new MarkerOptions().position(ensaCasablanca).title("ENSA Casablanca"));
        gmap.addMarker(new MarkerOptions().position(ensaRabat).title("ENSA Rabat"));
        gmap.addMarker(new MarkerOptions().position(ensaAgadir).title("ENSA Agadir"));
        gmap.addMarker(new MarkerOptions().position(ensaFes).title("ENSA Fes"));
        gmap.addMarker(new MarkerOptions().position(ensaOujda).title("ENSA Oujda"));

        // Move the camera to a suitable position (e.g., the first ENSA location)
        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(ensaCasablanca, 6.0f));
    }
}