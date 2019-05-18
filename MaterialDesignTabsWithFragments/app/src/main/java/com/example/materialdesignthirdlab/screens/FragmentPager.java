package com.example.materialdesignthirdlab.screens;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.materialdesignthirdlab.R;
import com.example.materialdesignthirdlab.screens.firstcolorScreen.FirstFragment;
import com.example.materialdesignthirdlab.screens.firstcolorScreen.SecondColorFragment;
import com.example.materialdesignthirdlab.screens.firstcolorScreen.ThirdColorFragment;

public class FragmentPager extends android.support.v4.app.FragmentPagerAdapter {
    private Context mContext;
    private FirstFragment firstFragment;
    private SecondColorFragment secondColorFragment;
    private ThirdColorFragment thirdColorFragment;
    public FragmentPager(FragmentManager fm , Context mContext) {
        super(fm);
        this.mContext=mContext;
        firstFragment=new FirstFragment();
        secondColorFragment= new SecondColorFragment();
        thirdColorFragment=new ThirdColorFragment();
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return firstFragment;
        } else if (position == 1){
            return secondColorFragment;
        } else if (position == 2){
            return thirdColorFragment;
        } else {
            return firstFragment;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.firstFragment);
            case 1:
                return mContext.getString(R.string.secondFragment);
            case 2:
                return mContext.getString(R.string.thirdFragment);
            default:
                return null;
        }
    }
}
