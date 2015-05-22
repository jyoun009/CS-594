package com.gorgonshank.manyfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

    private int HP = 100;
    int BLah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setPageTransformer(true, new ZoomOutPageTransformer());
        pager.setOffscreenPageLimit(2);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        private String tabtitles[] = new String[] { "Character Screen 1", "Character Screen 2", "Tab3", "Tab4", "Tab5" };
        private static final int NUMBER_OF_TABS = 5;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {
                case 0: return CharacterFragment.newInstance("Character Fragment1");
                case 1: return CharacterFragment.newInstance("Character Fragment2");
                case 2: return FirstFragment.newInstance("FirstFragment, Instance 1");
                case 3: return SecondFragment.newInstance("SecondFragment, Instance 1");
                case 4: return ThirdFragment.newInstance("ThirdFragment, Instance 1");
                default: return ThirdFragment.newInstance("ThirdFragment, Default");
            }
        }

        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public int getCount() {
            return NUMBER_OF_TABS;
        }

        public CharSequence getPageTitle(int position) {
            return tabtitles[position];
        }
    }


}