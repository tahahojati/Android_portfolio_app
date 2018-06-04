package com.tpourjalali.portfolio;


import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.tpourjalali.portfolio.controller.DevPagerAdapter;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private CardView metInTouchCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        metInTouchCardView = findViewById(R.id.cardViewGetInTouch);

        mViewPager = findViewById(R.id.viewPager);
        DevPagerAdapter dpa = new DevPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(dpa);

        mTabLayout = findViewById(R.id.tabLayoutId);
        mTabLayout.setupWithViewPager(mViewPager);

        metInTouchCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:8082328467"));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    String[] permissions = new String[]{Manifest.permission.CALL_PHONE};
                    requestPermissions(permissions, 1);
                    return;
                } else
                    startActivity(intent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(grantResults[0] == PERMISSION_GRANTED ){
            metInTouchCardView.performClick();
        }
    }
}
