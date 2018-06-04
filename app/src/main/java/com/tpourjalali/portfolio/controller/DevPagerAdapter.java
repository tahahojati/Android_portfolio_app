package com.tpourjalali.portfolio.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tpourjalali.portfolio.views.AboutFragment;
import com.tpourjalali.portfolio.views.ContactFragment;
import com.tpourjalali.portfolio.views.SkillsFragment;
import com.tpourjalali.portfolio.views.WorkFragment;

/**
 * Created by ProfessorTaha on 2/25/2018.
 */

public class DevPagerAdapter extends FragmentPagerAdapter {
    public DevPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AboutFragment();
            case 1:
                return new WorkFragment();
            case 2:
                return new SkillsFragment();
            case 3:
                return new ContactFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "About";
            case 1:
                return "Work";
            case 2:
                return "Skills";
            case 3:
                return "Contact";
        }
        return super.getPageTitle(position);
    }
}
