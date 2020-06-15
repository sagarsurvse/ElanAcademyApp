package com.example.admin.elanlivelearningapp.Bottom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.elanlivelearningapp.Bottom.Fragment.OneFragment;
import com.example.admin.elanlivelearningapp.Bottom.Fragment.TwoFragment;
import com.example.admin.elanlivelearningapp.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by Belal on 1/23/2018.
 */

public class MaterialFragment extends Fragment {
    @Nullable
    TabLayout tabLayout;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View rootview = inflater.inflate(R.layout.material, null);

        ViewPager viewPager = (ViewPager) rootview.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) rootview.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        return rootview;
    }
    private void setupViewPager(ViewPager viewPager) {
        MaterialFragment.ViewPagerAdapter adapter = new MaterialFragment.ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new OneFragment(), "Video");
        adapter.addFragment(new TwoFragment(), "Documents");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
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

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
