package com.movieapp.abeer;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {

    private final Context mContext;
    private List<String> titleList= new ArrayList<>();

    public TabAdapter(Context context, FragmentManager fm, List<String> titleList) {
        super(fm);
        mContext = context;
        this.titleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Log.e("adapter", titleList.get(position));
        return titleList.get(position);//mContext.getResources().getString(TAB_TITLES[position]);//
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 4;//titleList.size();
    }
}