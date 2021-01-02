package com.example.projectandroid.risandio;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adapter3 extends FragmentPagerAdapter {
    public Adapter3(FragmentManager fm){
        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                desc3 tab1 = new desc3();
                return tab1;
            case 1:
                fasilitas3 tab2 = new fasilitas3();
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
