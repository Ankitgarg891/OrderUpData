package com.example.food.orderup;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);

        setupPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

    }

    void setupPager(ViewPager viewPager) {
        PagerFunctionality pagerFunctionality = new PagerFunctionality(getSupportFragmentManager());
        pagerFunctionality.addFragment(new AppetizerFragment(), "Appetizer");
        pagerFunctionality.addFragment(new DessertFragment(), "Dessert's");
        pagerFunctionality.addFragment(new Main_CourseFragment(), "Main Course");
        pagerFunctionality.addFragment(new BeveragesFragment(), "Beverages");
        viewPager.setAdapter(pagerFunctionality);
    }

    class PagerFunctionality extends FragmentPagerAdapter {

        ArrayList<Fragment> fragmentList = new ArrayList();
        ArrayList<String> titles = new ArrayList();

        public PagerFunctionality(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            titles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}