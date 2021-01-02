package com.example.projectandroid.risandio;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adapter2 extends FragmentPagerAdapter {
    public Adapter2(FragmentManager fm){
        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                desc2 tab1 = new desc2();
                return tab1;
            case 1:
                fasilitas2 tab2 = new fasilitas2();
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
