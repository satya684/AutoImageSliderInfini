package com.satya.autoslider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

  List<Integer> list;

    ViewPagerAdapter(List<Integer> imageList){
        this.list = imageList;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
      View view = LayoutInflater.from(container.getContext()).inflate(R.layout.image_layout,container, false);
      ImageView imageView = view.findViewById(R.id.image_view);
      imageView.setImageResource(list.get(position));
      imageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          Snackbar.make(view,"Image "+position,Snackbar.LENGTH_LONG).show();
        }
      });
      container.addView(view);
      return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
