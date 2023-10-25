package com.example.mapa;


import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.Polyline;


public class MainActivity_mapa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));

        //controles del mapa

        MapView mapView = findViewById(R.id.mapView);
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);

        //cordenadas de santiago centro

        double puentealtoLatitud = -33.5995701;
        double puentealtoLongitud = -70.5773717;

        double puentealto2Latitud = -33.577496;
        double puentealto2Longitud =-70.5861185;

        double puentealto3Latitud = -33.5811919;
        double puentealto3Longitud =-70.6158652;

        double puentealto4Latitud = -33.609801;
        double puentealto4Longitud =-70.6021881;

        double puentealto5Latitud = -33.6065113;
        double puentealto5Longitud =-70.5526306;

        double puentealto6Latitud = -33.5837734;
        double puentealto6Longitud =-70.5727377;





        //Crear Marcadores

        GeoPoint puentealtoPoint = new GeoPoint(puentealtoLatitud, puentealtoLongitud);

        GeoPoint puentealto2Point = new GeoPoint(puentealto2Latitud, puentealto2Longitud);

        GeoPoint puentealto3Point = new GeoPoint(puentealto3Latitud, puentealto3Longitud);

        GeoPoint puentealto4Point = new GeoPoint(puentealto4Latitud, puentealto4Longitud);

        GeoPoint puentealto5Point = new GeoPoint(puentealto5Latitud, puentealto5Longitud);

        GeoPoint puentealto6Point = new GeoPoint(puentealto6Latitud, puentealto6Longitud);

        //Marcadores en el mapa con titulo y descripcion

        Marker puentealtoMarker = new Marker(mapView);
        puentealtoMarker.setPosition(puentealtoPoint);
        puentealtoMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        puentealtoMarker.setTitle("All Food Local ");
        puentealtoMarker.setSnippet(" El mejor Pais de Chile ");

        Marker puentealto2Marker = new Marker(mapView);
        puentealto2Marker.setPosition(puentealto2Point);
        puentealto2Marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        puentealto2Marker.setTitle("All Food  ");
        puentealto2Marker.setSnippet(" La mejor gastronomia  ");

        Marker puentealto3Marker = new Marker(mapView);
        puentealto3Marker.setPosition(puentealto3Point);
        puentealto3Marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        puentealto3Marker.setTitle("All Food  ");
        puentealto3Marker.setSnippet(" La mejor gastronomia  ");

        Marker puentealto4Marker = new Marker(mapView);
        puentealto4Marker.setPosition(puentealto4Point);
        puentealto4Marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        puentealto4Marker.setTitle("All Food  ");
        puentealto4Marker.setSnippet(" La mejor gastronomia  ");

        Marker puentealto5Marker = new Marker(mapView);
        puentealto5Marker.setPosition(puentealto5Point);
        puentealto5Marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        puentealto5Marker.setTitle("All Food  ");
        puentealto5Marker.setSnippet(" La mejor gastronomia  ");

        Marker puentealto6Marker = new Marker(mapView);
        puentealto6Marker.setPosition(puentealto6Point);
        puentealto6Marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        puentealto6Marker.setTitle("All Food  ");
        puentealto6Marker.setSnippet(" La mejor gastronomia  ");

        //agrego marcadores

        mapView.getOverlays().add(puentealtoMarker);
        mapView.getOverlays().add(puentealto2Marker);
        mapView.getOverlays().add(puentealto3Marker);
        mapView.getOverlays().add(puentealto4Marker);
        mapView.getOverlays().add(puentealto5Marker);
        mapView.getOverlays().add(puentealto6Marker);

        //centrar mapas

        IMapController mapController = mapView.getController();
        mapController.setCenter(puentealtoPoint);


        mapController.setZoom(14);

        //agregar linea entre marcadores

        Polyline polyline = new Polyline();

        polyline.addPoint(puentealto2Point);
        polyline.addPoint(puentealto3Point);
        polyline.addPoint(puentealto4Point);
        polyline.addPoint(puentealto5Point);
        polyline.addPoint(puentealto6Point);
        polyline.addPoint(puentealto2Point);
        polyline.setColor(0xFF0000FF);
        polyline.setWidth(5);
        mapView.getOverlays().add(polyline);


    }

    public void Finalizar(View View){
        Intent intent = new Intent(this,Fin.class);
        startActivity(intent);
    }
}