package com.example.ks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.ks.adapter.MyadapterFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        tab = findViewById(R.id.tab);
        pager = findViewById(R.id.pager);

        ArrayList<TabList> tabLists = new ArrayList<>();
        tabLists.add(new TabList("校门"));
        tabLists.add(new TabList("关注"));

        ArrayList<Fragment> fragments = new ArrayList<>();
        XiaoFragment xiaoFragment = new XiaoFragment();
        GuanFragment guanFragment = new GuanFragment();
        fragments.add(xiaoFragment);
        fragments.add(guanFragment);

        MyadapterFragment myadapterFragment = new MyadapterFragment(getSupportFragmentManager(), fragments);

        pager.setAdapter(myadapterFragment);

        tab.setupWithViewPager(pager);

        for (int i = 0; i < fragments.size(); i++) {
            tab.getTabAt(i).setText(tabLists.get(i).getName());
        }
        
    }
}
