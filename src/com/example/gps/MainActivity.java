package com.example.gps;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements LocationListener{
	  private LocationManager locationManager;
	  TextView t;
      
      @Override
      protected void onCreate(Bundle savedInstanceState) {
       
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          
          
           
          /********** get Gps location service LocationManager object ***********/
          
           
          /* CAL METHOD requestLocationUpdates */
             
            // Parameters :
            //   First(provider)    :  the name of the provider with which to register 
            //   Second(minTime)    :  the minimum time interval for notifications, 
            //                         in milliseconds. This field is only used as a hint 
            //                         to conserve power, and actual time between location 
            //                         updates may be greater or lesser than this value. 
            //   Third(minDistance) :  the minimum distance interval for notifications, in meters 
            //   Fourth(listener)   :  a {#link LocationListener} whose onLocationChanged(Location) 
            //                         method will be called for each location update 
          
locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    	  
    	  locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER,
                  15000,   // 3 sec
                  10, this);
          
           
          /********* After registration onLocationChanged method  ********/
          /********* called periodically after each 3 sec ***********/
      }
       
     
      
      /************* Called after each 3 sec **********/
      @Override
      public void onLocationChanged(Location location) {
              
          String str = "Latitude: "+location.getLatitude()+" Longitude: "+location.getLongitude();
          t.setText(str);
          
          Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
      }
   
      @Override
      public void onProviderDisabled(String provider) {
           
          /******** Called when User off Gps *********/
           
          Toast.makeText(getBaseContext(), "Gps turned off ", Toast.LENGTH_LONG).show();
      }
   
      @Override
      public void onProviderEnabled(String provider) {
           
          /******** Called when User on Gps  *********/
           
          Toast.makeText(getBaseContext(), "Gps turned on ", Toast.LENGTH_LONG).show();
      }
   
      @Override
      public void onStatusChanged(String provider, int status, Bundle extras) {
          // TODO Auto-generated method stub
           
      }
}
