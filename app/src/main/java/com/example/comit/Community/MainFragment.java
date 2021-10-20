package com.example.comit.Community;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.comit.Community.listfragments.MyPostsFragment;
import com.example.comit.Community.listfragments.MyTopPostsFragment;
import com.example.comit.Community.listfragments.RecentPostsFragment;
import com.example.comit.R;
import com.example.comit.databinding.FragmentMainBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;

    @Nullable
    public ConstraintLayout onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        // Create the adapter that will return a fragment for each section
        FragmentStateAdapter mPagerAdapter = new FragmentStateAdapter(getParentFragmentManager(),
                getViewLifecycleOwner().getLifecycle()) {
            private final Fragment[] mFragments = new Fragment[]{
                    new RecentPostsFragment(),
                    new MyPostsFragment(),
                    new MyTopPostsFragment(),
            };

            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return mFragments[position];
            }

            @Override
            public int getItemCount() {
                return mFragments.length;
            }
        };
        // Set up the ViewPager with the sections adapter.
        binding.container.setAdapter(mPagerAdapter);
        String[] mFragmentNames = new String[]{
                getString(R.string.heading_recent),
                getString(R.string.heading_my_posts),
                getString(R.string.heading_my_top_posts)
        };
        new TabLayoutMediator(binding.tabs, binding.container,
                (tab, position) -> tab.setText(mFragmentNames[position])
        ).attach();
    }


}
