package io.tpourjalali.portfolio;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import io.tpourjalali.portfolio.controller.DevPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.viewPager);
        DevPagerAdapter dpa = new DevPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(dpa);

        mTabLayout = findViewById(R.id.tabLayoutId);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
