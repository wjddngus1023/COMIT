package com.example.comit.LectureEval;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.comit.LectureEval.listfragments.FirstFragment;
import com.example.comit.LectureEval.listfragments.FourthFragment;
import com.example.comit.LectureEval.listfragments.SecondFragment;
import com.example.comit.LectureEval.listfragments.ThirdFragment;
import com.example.comit.R;
import com.example.comit.databinding.FragmentMain2Binding;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainFragment2 extends Fragment {

    private FragmentMain2Binding binding;

    @Nullable
    public ConstraintLayout onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMain2Binding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        // Create the adapter that will return a fragment for each section
        FragmentStateAdapter mPagerAdapter = new FragmentStateAdapter(getParentFragmentManager(),
                getViewLifecycleOwner().getLifecycle()) {
            private final Fragment[] mFragments = new Fragment[]{
                    new FirstFragment(),
                    new SecondFragment(),
                    new ThirdFragment(),
                    new FourthFragment(),
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
        binding.container2.setAdapter(mPagerAdapter);
        String[] mFragmentNames = new String[]{
                getString(R.string.firstgrade),
                getString(R.string.secondgrade),
                getString(R.string.thirdgrade),
                getString(R.string.fourthgrade),
        };
        new TabLayoutMediator(binding.tabs2, binding.container2,
                (tab, position) -> tab.setText(mFragmentNames[position])
        ).attach();
    }


}
