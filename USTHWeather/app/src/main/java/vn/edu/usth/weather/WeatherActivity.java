package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG="FunctionTracing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState == null) {
            setContentView(R.layout.activity_weather);

            ForecastFragment forecastFragment = new ForecastFragment();
            WeatherFragment weatherFragment = new WeatherFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.add(R.id.ForecastFragment, forecastFragment);
            transaction.add(R.id.WeatherFragment, weatherFragment);

            transaction.commit();

            Log.i(TAG, "Create the process: ");
        }
    }



    @Override
    public void onStart(){
        super.onStart();
        Log.i(TAG, "Let start the process: ");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i(TAG, "Resume: ");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i(TAG, "Pause the process: ");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.i(TAG, "Stop the process: ");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "Destroy the process: ");
    }
}

