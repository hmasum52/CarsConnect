package com.hmasum18.carsconnect;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hmasum18.carsconnect.util.GoogleMapCustomizer;

public class MyMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    public static final String TAG = "MyMapsActivity->";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        initGoogleMap();
    }

    private void initGoogleMap() {
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        Log.d(TAG, "onMapReady(): google map set up complete");

      //  googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        LatLng myHome = new LatLng(22.466200, 92.013179);
       /* googleMap.addMarker(new MarkerOptions()
                .position(myHome)
                .title("Masum's sweet home"));*/

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myHome,18f));

         /* LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(myHome);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(),10));
       */
        Bitmap bitmap = BitmapFactory.decodeResource(
                getResources(),R.drawable.car_right);
        bitmap = Bitmap.createScaledBitmap(bitmap,200,200,false);
        GoogleMapCustomizer customizer = new GoogleMapCustomizer(googleMap);
        customizer.addImageMarker(myHome,bitmap);
    }
}