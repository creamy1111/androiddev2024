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

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ForecastFragment(){
      ForecastFragment newInstance;(String param2, String param2) {
        ForecastFragment fragment = new ForecastFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;}

      @Override
      public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
          mParam1 = getArguments().getString(ARG_PARAM1);
          mParam2 = getArguments().getString(ARG_PARAM2);
        }
      }

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

