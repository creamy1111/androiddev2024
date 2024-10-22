package vn.edu.usth.weather;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class WeatherActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private MediaPlayer mediaPlayer;
    private static final String TAG = "WeatherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        HomeFragmentPagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        extractFile();

        Log.i(TAG, "Create the process: ");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.refresh_button){
            Toast.makeText(this, "Refresing", Toast.LENGTH_SHORT);
            simulateNetworkRequest();
            return true;
        } else if (id == R.id.setting_button) {
            Intent intent = new Intent(this,PrefActivity.class);
            startActivity(intent);
            return  true;
        }
        return  super.onOptionsItemSelected(item);
    }

    final Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            String content = msg.getData().getString("server_response");
            Toast.makeText(WeatherActivity.this, content, Toast.LENGTH_SHORT).show();
        }
    };

    private void simulateNetworkRequest() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Bundle bundle = new Bundle();
                bundle.putString("server_response", "some sample json here");
                Message msg = new Message();
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        });
        t.start();
    }

    private void extractFile() {
        File musicFile = new File(Environment.getExternalStorageDirectory(), "sample.mp3");
        if (!musicFile.exists()) {
            try {
                InputStream is = getResources().openRawResource(R.raw.audio1);  // Replace 'audio' with your MP3 file name
                FileOutputStream fos = new FileOutputStream(musicFile);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
                fos.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(musicFile.getAbsolutePath());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
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
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
        Log.i(TAG, "Destroy the process: ");
    }
}

