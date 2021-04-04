package com.example.informationapp2021;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.MapView;




import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.GoogleMapOptions;



import androidx.fragment.app.Fragment;


public class MapOfCharacters extends Fragment implements OnMarkerClickListener, OnMapReadyCallback {

    private GoogleMap mGoogleMap;
    private MapView mMapView;
    private View mView;
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


    @Override
    public void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        mView = inflater.inflate(R.layout.mapofcharacters, container, false);
        return mView;
    }

    @Override
    public void onViewCreated ( View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        GoogleMapOptions options = new GoogleMapOptions()
                .liteMode(true);

        mMapView = (MapView)mView.findViewById(R.id.map);
        if (mMapView != null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }


    @Override
    public void onMapReady (GoogleMap googleMap){
        MapsInitializer.initialize(getContext());
        mGoogleMap = googleMap;
        mGoogleMap.setOnMarkerClickListener(this);
        mGoogleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {

            @Override
            public void onMapLoaded() {

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

                 mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds,100));


            }
        });


        sanAntonio = googleMap.addMarker(new MarkerOptions()
                .position(SANANTONIO)
                .title("Simran Jeet Singh")
                .snippet("San Antonio, TX" + "Activist advocating for religious equality in America")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.simran_jeet_singh)));

        sanFrancisco = googleMap.addMarker(new MarkerOptions()
                .position(SANFRANCISCO)
                .title("Alice Wong")
                .snippet("San Francisco, CA" + "Activist for the rights of disabled people")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.alice_wong)));

        losAngeles = googleMap.addMarker(new MarkerOptions()
                .position(LOSANGELES)
                .title("Thandiwe Abdullah")
                .snippet("Los Angeles, CA" + " Anti-Racism Activist")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.thandiwe_abdullah)));

        Soweto = googleMap.addMarker(new MarkerOptions()
                .position(SOWETO)
                .title("Beverly Palesa Ditsie")
                .snippet("Soweto, South Africa" + " LGBTQ+ Activist")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.beverly_palesa_ditsie)));

        Mingora = googleMap.addMarker(new MarkerOptions()
                .position(MINGORA)
                .title("Malala Yousafzai")
                .snippet("Mingora Swat Valley, Pakistan" + " Activist for Education")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.malala_yousafzai)));

        Mims = googleMap.addMarker(new MarkerOptions()
                .position(MIMS)
                .title("Melanie Campbell")
                .snippet("Mims, FL" + " Anti-Racism & Equal Rights Activist")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.melanie_campbell)));

        Hope = googleMap.addMarker(new MarkerOptions()
                .position(HOPE)
                .title("Chad Griffin")
                .snippet("Hope, AK" + "LGTBQ+ Rights Activist")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.chad_griffin)));

        Antipolo = googleMap.addMarker(new MarkerOptions()
                .position(ANTIPOLO)
                .title("Jose Antonio Vargas")
                .snippet("Antipolo, Phillipines" + " Advocating for immigrants and the Latinx community")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.jose_antonio_vargas)));

        Sacramento = googleMap.addMarker(new MarkerOptions()
                .position(SACRAMENTO)
                .title("Jamey Jesperson")
                .snippet("Sacramento, CA" + " LGBTQ+ Activist")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.jamey_jesperson)));

        Mobile = googleMap.addMarker(new MarkerOptions()
                .position(MOBILE)
                .title("Laverne Cox")
                .snippet("Mobile, AL" + " Trans Representation and Rights Activist")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.laverne_cox)));
    }



        public boolean onMarkerClick(final Marker marker) {
        if (marker.equals(sanAntonio)) {
            SimranJeetSingh nextFrag= new SimranJeetSingh();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(((ViewGroup)getView().getParent()).getId(), nextFrag)
                    .addToBackStack(null)
                    .commit();

        }else if (marker.equals(sanFrancisco)){
            AliceWong nextFrag= new AliceWong();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(((ViewGroup)getView().getParent()).getId(), nextFrag)
                    .addToBackStack(null)
                    .commit();


        }else if (marker.equals(losAngeles)) {
            ThandiweAbdullah nextFrag= new ThandiweAbdullah();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(((ViewGroup)getView().getParent()).getId(), nextFrag)
                    .addToBackStack(null)
                    .commit();

        }else if (marker.equals(Soweto)) {
            BeverlyPalesaDitsie nextFrag= new BeverlyPalesaDitsie();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(((ViewGroup)getView().getParent()).getId(), nextFrag)
                    .addToBackStack(null)
                    .commit();

        }else if (marker.equals(Mingora)) {
            MalalaYousafzai nextFrag= new MalalaYousafzai();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(((ViewGroup)getView().getParent()).getId(), nextFrag)
                    .addToBackStack(null)
                    .commit();

        }else if (marker.equals(Mims)) {
            MelanieCampbell nextFrag= new MelanieCampbell();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(((ViewGroup)getView().getParent()).getId(), nextFrag)
                    .addToBackStack(null)
                    .commit();

        }else if (marker.equals(Hope)) {
            ChadGriffin nextFrag= new ChadGriffin();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(((ViewGroup)getView().getParent()).getId(), nextFrag)
                    .addToBackStack(null)
                    .commit();

        }else if (marker.equals(Antipolo)) {
            JoseAntonioVargas nextFrag= new JoseAntonioVargas();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(((ViewGroup)getView().getParent()).getId(), nextFrag)
                    .addToBackStack(null)
                    .commit();

        }else if (marker.equals(Sacramento)) {
            JameyJesperson nextFrag= new JameyJesperson();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(((ViewGroup)getView().getParent()).getId(), nextFrag)
                    .addToBackStack(null)
                    .commit();

        }else if (marker.equals(Mobile)) {
            LaverneCox nextFrag= new LaverneCox();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(((ViewGroup)getView().getParent()).getId(), nextFrag)
                    .addToBackStack(null)
                    .commit();

        }
    return false;
    }
}
