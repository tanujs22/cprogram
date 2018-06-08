package com.bizploy.cprogram.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bizploy.cprogram.MainActivity;
import com.bizploy.cprogram.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(5);
        setupViewPager(viewPager);


        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
       /* tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {

                    tabLayout.getTabAt(0).setText(getResources().getString(R.string.bottom_tab1));

                } else if (tab.getPosition() == 1) {
                    tabLayout.getTabAt(1).setText(getResources().getString(R.string.bottom_tab2));

                } else if (tab.getPosition() == 2) {
                    tabLayout.getTabAt(2).setText(getResources().getString(R.string.bottom_tab3));

                } else if (tab.getPosition() == 3) {
                    tabLayout.getTabAt(3).setText(getResources().getString(R.string.bottom_tab4));

                } else if (tab.getPosition() == 4) {
                    tabLayout.getTabAt(4).setText(getResources().getString(R.string.bottom_tab5));

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                if (tab.getPosition() == 0) {
                    tabLayout.getTabAt(0).setText("");

                } else if (tab.getPosition() == 1) {
                    tabLayout.getTabAt(1).setText("");

                } else if (tab.getPosition() == 2) {
                    tabLayout.getTabAt(2).setText("");

                } else if (tab.getPosition() == 3) {
                    tabLayout.getTabAt(3).setText("");

                } else if (tab.getPosition() == 4) {
                    tabLayout.getTabAt(4).setText("");

                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/
        tabLayout.getTabAt(0).setText(getResources().getString(R.string.top_tab1));
        tabLayout.getTabAt(1).setText(getResources().getString(R.string.top_tab2));
        tabLayout.getTabAt(2).setText(getResources().getString(R.string.top_tab3));
        tabLayout.getTabAt(3).setText(getResources().getString(R.string.top_tab4));
        tabLayout.getTabAt(4).setText(getResources().getString(R.string.top_tab5));
        tabLayout.getTabAt(5).setText(getResources().getString(R.string.top_tab6));
        tabLayout.getTabAt(6).setText(getResources().getString(R.string.top_tab7));
        tabLayout.getTabAt(7).setText(getResources().getString(R.string.top_tab8));
        tabLayout.getTabAt(8).setText(getResources().getString(R.string.top_tab9));
        tabLayout.getTabAt(9).setText(getResources().getString(R.string.top_tab10));
        tabLayout.getTabAt(10).setText(getResources().getString(R.string.top_tab11));
        tabLayout.getTabAt(11).setText(getResources().getString(R.string.top_tab12));
        tabLayout.getTabAt(12).setText(getResources().getString(R.string.top_tab13));
        tabLayout.getTabAt(13).setText(getResources().getString(R.string.top_tab14));
        tabLayout.getTabAt(14).setText(getResources().getString(R.string.top_tab15));
        tabLayout.getTabAt(15).setText(getResources().getString(R.string.top_tab16));


        return view;
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFrag(new ProgrammFragment(), "ONE");
        adapter.addFrag(new ProgrammFragment(), "TWO");
        adapter.addFrag(new ProgrammFragment(), "THREE");
        adapter.addFrag(new ProgrammFragment(), "FOUR");
        adapter.addFrag(new ProgrammFragment(), "FIVE");
        adapter.addFrag(new ProgrammFragment(), "ONE");
        adapter.addFrag(new ProgrammFragment(), "TWO");
        adapter.addFrag(new ProgrammFragment(), "THREE");
        adapter.addFrag(new ProgrammFragment(), "FOUR");
        adapter.addFrag(new ProgrammFragment(), "FIVE");
        adapter.addFrag(new ProgrammFragment(), "ONE");
        adapter.addFrag(new ProgrammFragment(), "TWO");
        adapter.addFrag(new ProgrammFragment(), "THREE");
        adapter.addFrag(new ProgrammFragment(), "FOUR");
        adapter.addFrag(new ProgrammFragment(), "FIVE");
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



   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
       //  mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        mRecyclerView.setLayoutManager(mLayoutManager);
        viewPager.setAdapter(new PagerAdapter(getFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tabLayout.getTabAt(0).setText(getResources().getString(R.string.bottom_tab1));
        tabLayout.getTabAt(1).setText("vv");
        tabLayout.getTabAt(2).setText("fff");

        return view;
    }



    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }


        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new FragmentTab();
                case 1:
                    return new FragmentTab();
                case 2:
                    return new FragmentTab();

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }*/
}
