package com.example.projectandroid.risandio;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adapter extends FragmentPagerAdapter {
    public Adapter(FragmentManager fm){
        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                desc1 tab1 = new desc1();
                return tab1;
            case 1:
                fasilitas1 tab2 = new fasilitas1();
                return tab2;
        }
        return null;
    }

    @Override
    public int getCount(){
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position){
        if (position==0){
            return "KALKULATOR";
        }
        if (position==1){
            return "LIST HARGA";
        }
        else return null;
    }
}
