package com.bizploy.cprogram;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.bizploy.cprogram.fragments.HomeFragment;
import com.bizploy.cprogram.fragments.ProgrammFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private int[] tabIcons = {
            R.drawable.ic_code_black_24dp,
            R.drawable.ic_library_books_black_24dp,
            R.drawable.ic_live_help_black_24dp,
            R.drawable.ic_group_add_black_24dp,
            R.drawable.ic_notifications_active_black_24dp
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(5);
        setupViewPager(viewPager);


        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    tabLayout.getTabAt(0).setIcon(R.drawable.ic_code_white_24dp);
                    tabLayout.getTabAt(0).setText(getResources().getString(R.string.bottom_tab1));

                } else if (tab.getPosition() == 1) {
                    tabLayout.getTabAt(1).setIcon(R.drawable.ic_library_books_white_24dp);
                    tabLayout.getTabAt(1).setText(getResources().getString(R.string.bottom_tab2));

                } else if (tab.getPosition() == 2) {
                    tabLayout.getTabAt(2).setIcon(R.drawable.ic_live_help_white_24dp);
                    tabLayout.getTabAt(2).setText(getResources().getString(R.string.bottom_tab3));

                } else if (tab.getPosition() == 3) {
                    tabLayout.getTabAt(3).setIcon(R.drawable.ic_group_add_white_24dp);
                    tabLayout.getTabAt(3).setText(getResources().getString(R.string.bottom_tab4));

                } else if (tab.getPosition() == 4) {
                    tabLayout.getTabAt(4).setIcon(R.drawable.ic_notifications_active_white_24dp);
                    tabLayout.getTabAt(4).setText(getResources().getString(R.string.bottom_tab5));

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                if (tab.getPosition() == 0) {
                    tabLayout.getTabAt(0).setIcon(R.drawable.ic_code_black_24dp);
                    tabLayout.getTabAt(0).setText("");

                } else if (tab.getPosition() == 1) {
                    tabLayout.getTabAt(1).setIcon(R.drawable.ic_library_books_black_24dp);
                    tabLayout.getTabAt(1).setText("");

                } else if (tab.getPosition() == 2) {
                    tabLayout.getTabAt(2).setIcon(R.drawable.ic_live_help_black_24dp);
                    tabLayout.getTabAt(2).setText("");

                } else if (tab.getPosition() == 3) {
                    tabLayout.getTabAt(3).setIcon(R.drawable.ic_group_add_black_24dp);
                    tabLayout.getTabAt(3).setText("");

                } else if (tab.getPosition() == 4) {
                    tabLayout.getTabAt(4).setIcon(R.drawable.ic_notifications_active_black_24dp);
                    tabLayout.getTabAt(4).setText("");

                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        setupTabIcons();


    }

    private void setupTabIcons() {

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_code_white_24dp);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
        tabLayout.getTabAt(0).setText(getResources().getString(R.string.bottom_tab1));
        tabLayout.getTabAt(1).setText("");
        tabLayout.getTabAt(2).setText("");
        tabLayout.getTabAt(3).setText("");
        tabLayout.getTabAt(4).setText("");

    }


    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment(), "ONE");
        adapter.addFrag(new ProgrammFragment(), "TWO");
        adapter.addFrag(new ProgrammFragment(), "THREE");
        adapter.addFrag(new ProgrammFragment(), "FOUR");
        adapter.addFrag(new ProgrammFragment(), "FIVE");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 200) {
            setupViewPager(viewPager);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }




}
