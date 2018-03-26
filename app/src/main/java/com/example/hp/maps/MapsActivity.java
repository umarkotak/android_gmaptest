package com.example.hp.maps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hp.maps.model.GarduInduk;
import com.example.hp.maps.model.GarduIndukApi;
import com.example.hp.maps.network.GarduIndukClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private GarduIndukClient garduIndukClient = new GarduIndukClient();
    private List<GarduInduk> garduIndukList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        getAllCoordinatesFromServer();
    }

    public void getAllCoordinatesFromServer() {
        GarduIndukApi garduIndukApi = garduIndukClient.getClient();
        Call<List<GarduInduk>> call = garduIndukApi.getAllGarduInduk();
        call.enqueue(new Callback<List<GarduInduk>>() {
            @Override
            public void onResponse(Call<List<GarduInduk>> call, retrofit2.Response<List<GarduInduk>> response) {
                for (GarduInduk garduInduk : response.body()) {
                    garduIndukList.add(garduInduk);
                    LatLng garduPosition = new LatLng(garduInduk.longitude, garduInduk.latitude);
                    mMap.addMarker(new MarkerOptions().position(garduPosition).title(garduInduk.namaGi));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(garduPosition, 10));
                }
            }

            @Override
            public void onFailure(Call<List<GarduInduk>> call, Throwable t) {
                Log.e("ERROR : ", "onFailure : ", t);
            }
        });
    }
}
