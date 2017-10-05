package com.example.food.orderup;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    ListView menulist;
    ViewPager viewPager;
    Toolbar toolbar;
    TabLayout tabLayout;
    NestedScrollView scrollView;
    int icons[]={R.mipmap.apzicon,R.mipmap.dessicon,R.mipmap.mainicon,R.mipmap.bevicon};
    String name1[]={"Vegetarian Spring Rolls","Vegetable Fried Wonton","Crispy Chilli Potatoes","Chilli Paneer","Crispy Tangy Mushrooms"
    ,"Corn Pepper Salt"};
    int images1[]={R.drawable.roll,R.drawable.wonton,R.drawable.chilli,R.drawable.paneer,R.drawable.mushroom,R.drawable.corn};
    int price1[]={225,225,245,275,245,260};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        menulist=(ListView)findViewById(R.id.menulist);

        viewPager=(ViewPager)findViewById(R.id.viewpager);
        tabLayout=(TabLayout)findViewById(R.id.tabmenu);
        scrollView = (NestedScrollView) findViewById (R.id.nestedscrollview);

        tabLayout.setupWithViewPager(viewPager);
        //ATTACHING FRAGMENTS
        setUpPager(viewPager);
        setTabIcons();


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        scrollView.setFillViewport (true);

        menulist.setAdapter(new CustomAdapter(this,name1,images1,price1));
        // set for diff tabs


      /*  menulist.setOnTouchListener(new ListView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });*/

    }

    void setTabIcons(){
        tabLayout.getTabAt(0).setIcon(icons[0]);
        tabLayout.getTabAt(1).setIcon(icons[1]);
        tabLayout.getTabAt(1).setIcon(icons[2]);
        tabLayout.getTabAt(1).setIcon(icons[3]);
    }
    void setUpPager(ViewPager viewPager)
    {

        PagerFunctionality pagerFunctionality=new PagerFunctionality(getSupportFragmentManager());
        pagerFunctionality.add(new Appetizer(),"Appetizer");
        pagerFunctionality.add(new Dessert(),"Dessert");
        pagerFunctionality.add(new MainMenu(),"MainMenu");
        pagerFunctionality.add(new Beverages(),"Beverages");
        viewPager.setAdapter(pagerFunctionality);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
class PagerFunctionality extends FragmentPagerAdapter
{
    ArrayList<Fragment> fragmentList=new ArrayList();//TYPECASTING
    ArrayList<String> titleList= new ArrayList<>();
    public PagerFunctionality(FragmentManager fm) {
        super(fm);
    }

    void add(Fragment fragment,String title){

        fragmentList.add(fragment);
        titleList.add(title);
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
    public CharSequence getPageTitle(int position)
    {
        return titleList.get(position);
        //return null
    }

}
}
