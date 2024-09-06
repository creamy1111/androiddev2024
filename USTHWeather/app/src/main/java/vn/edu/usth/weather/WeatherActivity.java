package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG="FunctionTracing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        }
        WeatherFragment secondFragment = new WeatherFragment();
        getSupportFragmentManager().beginTransaction().add(
                R.id.main, secondFragment).commit();
        )
//        Create a new Fragment to be placed in the activity layout
        ForecastFragment firstFragment= new ForecastFragment();
        //Add the fragment to the 'container' FrameLayout
        getSupportFragmentManager().beginTransaction().add(
                R.id.main, firstFragment).commit();
        // container: "@+id/main"

        Log.i(TAG, "Create the process: ");
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

