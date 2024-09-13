package vn.edu.usth.weather;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragmentPageAdapter extends Fragment {
    private final int PAGE_COUNT = 3;
    private String titles[] = new String[] { "HANOI,VIETNAM", "PARIS,FRANCE", "TOULOUSE,FRANCE" };
    public HomeFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public int getCount() {
        return PAGE_COUNT; // number of pages for a ViewPager
    }
    @NonNull
    @Override
    public Fragment getItem(int page) {
// returns an instance of Fragment corresponding to the specified page
        switch (page) {
            case 0: new WeatherAndForecastFragment();
            case 1: new WeatherAndForecastFragment();
            case 2: new WeatherAndForecastFragment();
        }
        return new WeatherAndForecastFragment(); // failsafe
    }

    public CharSequence getPageTitle(int page) {
// returns a tab title corresponding to the specified page
        return titles[page];
    }
}}