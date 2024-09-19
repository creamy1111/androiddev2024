package vn.edu.usth.weather;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;

public class HomeFragmentPagerAdapter extends PagerAdapter {
    private final int PAGE_COUNT = 3;
    private String titles[] = new String[]{"HANOI,VIETNAM", "PARIS,FRANCE", "TOULOUSE,FRANCE"};

    public HomeFragmentPagerAdapter(FragmentManager fm) {
        super();
    }

    @Override
    public int getCount() {
        return PAGE_COUNT; // number of pages for a ViewPager
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }

    @Override
    public Fragment getItem(int page) {
        switch (page) {
            case 0:
                new WeatherAndForecastFragment();
            case 1:
                new WeatherAndForecastFragment();
            case 2:
                new WeatherAndForecastFragment();
        }
        return new WeatherAndForecastFragment();
    }

    public CharSequence getPageTitle(int page) {
// returns a tab title corresponding to the specified page
        return titles[page];
    }
}
