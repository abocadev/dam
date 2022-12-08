package dev.boca.tabnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText("Frios"));
        tabLayout.addTab(tabLayout.newTab().setText("Calientes"));
        tabLayout.addTab(tabLayout.newTab().setText("Entrantes"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        
    }
}