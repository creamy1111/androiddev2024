package vn.edu.usth.weather;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class ForecastFragment extends Fragment {

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view = new View(getContext());


        //set the background color
        int color = Color.parseColor("#D1E9F6");
        view.setBackgroundColor(color);

        TextView day = new TextView(getContext());
        day.setText("Thursday");
        ImageView icon = new ImageView(getContext());
        icon.setImageResource(R.drawable.a_weather_icon);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(day);
        linearLayout.addView(icon);
        linearLayout.addView(view);


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forecast, container, false);


    }
}

