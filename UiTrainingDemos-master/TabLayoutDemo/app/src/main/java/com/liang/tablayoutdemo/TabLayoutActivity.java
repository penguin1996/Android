package com.liang.tablayoutdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {

    private TabLayout download;
    private ViewPager list;

    //当标签数目小于等于4个时，标签栏不可滑动
    public static final int MOVABLE_COUNT = 3;

    private int tabCount = 2;
    private List<String> tabs;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        download = findViewById(R.id.download);
        list = findViewById(R.id.list);

        initDatas();
        initViewPager();
        initTabLayout();
    }

    private void initTabLayout() {
        //MODE_FIXED标签栏不可滑动，各个标签会平分屏幕的宽度
        download.setTabMode(tabCount <= MOVABLE_COUNT ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
        //指示条的颜色
        download.setSelectedTabIndicatorColor(getResources().getColor(android.R.color.holo_red_dark));
        //指示条的宽度
        download.setSelectedTabIndicatorHeight((int) getResources().getDimension(R.dimen.indicatorHeight));
        //关联tabLayout和ViewPager,两者的选择和滑动状态会相互影响
        download.setupWithViewPager(list);
        //自定义标签布局
        for (int i = 0; i < tabs.size(); i++) {
            TabLayout.Tab tab = download.getTabAt(i);
            //System.out.println("我想知道tab是什么："+tab);
                TextView tv = (TextView) LayoutInflater.from(this).inflate(R.layout.tabview_main, download, false);
                tv.setText(tabs.get(i));
                tab.setCustomView(tv);
        }
    }

    private void initViewPager() {
        list.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    private void initDatas() {
        tabs = new ArrayList<>();
            tabs.add("DOWNLOAD");
            tabs.add("RECYCLER LIST");

            fragments = new ArrayList<>();

            fragments.add(TabFragment.newInstance(tabs.get(0)));

            fragments.add(ListFragment.newInstance(tabs.get(1)));
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        /**
         * 如果不是自定义标签布局，需要重写该方法
         */
//        @Nullable
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return tabs.get(position);
//        }
    }

}
