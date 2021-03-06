package com.accenture.mvvmOnline.view.activities;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.accenture.mvvmOnline.view.adapters.ViewPagerAdapter;
import com.accenture.mvvmOnline.view.fragments.DownloadFragment;
import com.accenture.mvvmOnline.view.fragments.RecyclerListFragment;
import com.accenture.myapplication.R;
import com.accenture.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragment;
    private List<String> mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initTabFragment();
    }

    private void initTabFragment() {

        //初始化Fragment
        DownloadFragment downloadFragment = new DownloadFragment();
        RecyclerListFragment listFragment = new RecyclerListFragment();

        //将Fragment装进列表中
        mFragment = new ArrayList<>();
        mFragment.add(downloadFragment);
        mFragment.add(listFragment);

        //将名称添加daoTab列表
        mTitle = new ArrayList<>();
        mTitle.add("Download");
        mTitle.add("RECYCLER LIST");

        //为TabLayout添加Tab名称
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(mTitle.get(0)));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(mTitle.get(1)));

        mAdapter = new ViewPagerAdapter(this.getSupportFragmentManager(), mFragment, mTitle);
        //ViewPager加载Adapter
        binding.viewPager.setAdapter(mAdapter);
        //TabLayout加载ViewPager
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }
}

