package com.satya.autoslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;

import com.satya.autoslider.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private ViewPagerAdapter myAdapter;
    private Timer timer;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        List<Integer> imageList = new ArrayList<>();

        imageList.add(R.drawable.back_icon);
        imageList.add(R.drawable.ic_android_black_24dp);
        imageList.add(R.drawable.back_icon);

        myAdapter = new ViewPagerAdapter(imageList);
        mainBinding.viewpager.setAdapter(myAdapter);

        mainBinding.indicator.setViewPager(mainBinding.viewpager);
        handler = new Handler();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        int i = mainBinding.viewpager.getCurrentItem();
                        if (i == imageList.size() - 1) {
                            i = 0;
                            mainBinding.viewpager.setCurrentItem(i, true);
                        } else {
                            i++;
                            mainBinding.viewpager.setCurrentItem(i, true);
                        }
                    }
                });
            }
        }, 4000, 4000);

    }


}