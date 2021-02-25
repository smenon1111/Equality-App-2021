package com.example.informationapp2021;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.Sanitizer;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.LatLngBounds;


import androidx.fragment.app.FragmentActivity;


public class MapOfCharacters extends FragmentActivity implements OnMapReadyCallback, OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker sanAntonio;
    private Marker sanFrancisco;
    private Marker losAngeles;
    private Marker Soweto;
    private Marker Mingora;
    private Marker Mims;
    private Marker Hope;
    private Marker Antipolo;
    private Marker Sacramento;
    private Marker Mobile;

    //Assigning all the birthplace cities of the activists Lat and Lang
    private static final LatLng SANANTONIO = new LatLng(29.4241, -98.4936);
    private static final LatLng SANFRANCISCO = new LatLng(37.7749, -122.4194);
    private static final LatLng LOSANGELES = new LatLng(34.0522, -118.2437);
    private static final LatLng SOWETO = new LatLng(-26.2485, 27.8540);
    private static final LatLng MINGORA = new LatLng(34.7717, 72.3602);
    private static final LatLng MIMS = new LatLng(28.6656, -80.8450);
    private static final LatLng HOPE = new LatLng(33.6671, -93.5916);
    private static final LatLng ANTIPOLO = new LatLng(14.6255, 121.1245);
    private static final LatLng SACRAMENTO = new LatLng(38.5816, -121.4944);
    private static final LatLng MOBILE = new LatLng(30.6954, -88.0399);








   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapofcharacters);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.


    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapofcharacters);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(this);

        LatLngBounds bounds = new LatLngBounds.Builder()
                //Including only the cities in the U.S. on the starting map
                .include(SANANTONIO)
                .include(SANFRANCISCO)
                .include(LOSANGELES)
                .include(MIMS)
                .include(HOPE)
                .include(SACRAMENTO)
                .include(MOBILE)
                .build();
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100));

        sanAntonio = mMap.addMarker(new MarkerOptions()
                .position(SANANTONIO)
                .title("Simran Jeet Singh")
                .snippet("San Antonio, TX" + "Activist advocating for religious equality in America")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        sanFrancisco = mMap.addMarker(new MarkerOptions()
                .position(SANFRANCISCO)
                .title("Alice Wong")
                .snippet("San Francisco, CA" + "Activist for the rights of disabled people")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        losAngeles = mMap.addMarker(new MarkerOptions()
                .position(LOSANGELES)
                .title("Thandiwe Abdullah")
                .snippet("Los Angeles, CA" + " Anti-Racism Activist")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        Soweto = mMap.addMarker(new MarkerOptions()
                .position(SOWETO)
                .title("Beverly Palesa Ditsie")
                .snippet("Soweto, South Africa" + " LGBTQ+ Activist")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        Mingora = mMap.addMarker(new MarkerOptions()
                .position(MINGORA)
                .title("Malala Yousafzai")
                .snippet("Mingora Swat Valley, Pakistan" + " Activist for Education")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        Mims = mMap.addMarker(new MarkerOptions()
                .position(MIMS)
                .title("Melanie Campbell")
                .snippet("Mims, FL" + " Anti-Racism & Equal Rights Activist")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        Hope = mMap.addMarker(new MarkerOptions()
                .position(HOPE)
                .title("Chad Griffin")
                .snippet("Hope, AK" + "LGTBQ+ Rights Activist")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        Antipolo = mMap.addMarker(new MarkerOptions()
                .position(ANTIPOLO)
                .title("Jose Antonio Vargas")
                .snippet("Antipolo, Phillipines" + " Advocating for immigrants and the Latinx community")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        Sacramento = mMap.addMarker(new MarkerOptions()
                .position(SACRAMENTO)
                .title("Jamey Jesperson")
                .snippet("Sacramento, CA" + " LGBTQ+ Activist")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        Mobile = mMap.addMarker(new MarkerOptions()
                .position(MOBILE)
                .title("Laverne Cox")
                .snippet("Mobile, AL" + " Trans Representation and Rights Activist")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));



    }

    public boolean onMarkerClick(final Marker marker) {
        if (marker.equals(sanAntonio)) {
            startActivity(new Intent(MapOfCharacters.this, SimranJeetSingh.class));

        }else if (marker.equals(sanFrancisco)){
            startActivity(new Intent(MapOfCharacters.this, AliceWong.class));

        }else if (marker.equals(losAngeles)) {
            startActivity(new Intent(MapOfCharacters.this, ThandiweAbdullah.class));

        }else if (marker.equals(Soweto)) {
            startActivity(new Intent(MapOfCharacters.this, BeverlyPalesaDitsie.class));

        }else if (marker.equals(Mingora)) {
            startActivity(new Intent(MapOfCharacters.this, MalalaYousafzai.class));

        }else if (marker.equals(Mims)) {
            startActivity(new Intent(MapOfCharacters.this, MelanieCampbell.class));

        }else if (marker.equals(Hope)) {
            startActivity(new Intent(MapOfCharacters.this, ChadGriffin.class));

        }else if (marker.equals(Antipolo)) {
            startActivity(new Intent(MapOfCharacters.this, JoseAntonioVargas.class));

        }else if (marker.equals(Sacramento)) {
            startActivity(new Intent(MapOfCharacters.this, JameyJesperson.class));

        }else if (marker.equals(Mobile)) {
            startActivity(new Intent(MapOfCharacters.this, LaverneCox.class));

        }
    return false;
    }
}
