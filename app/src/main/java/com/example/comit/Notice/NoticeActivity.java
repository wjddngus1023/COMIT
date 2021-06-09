package com.example.comit.Notice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.example.comit.ChatbotActivity;
import com.example.comit.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class NoticeActivity extends AppCompatActivity {
    private BottomNavigationView BottomNav;

    private static final int NUM_PAGES = 4;
    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice_main);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        // 상태바 제거

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //상단바 제거

        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);


//        BottomNav = findViewById(R.id.nav_view);
//        BottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                BottomNavigate(menuItem.getItemId());
//
//                return true;
//            }
//        });
//        BottomNav.setSelectedItemId(R.id.navigation_1);
//
//
//    }

//    private void BottomNavigate(int id) {
//
//        String tag = String.valueOf(id);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        Fragment currentFragment = fragmentManager.getPrimaryNavigationFragment();
//        if (currentFragment != null) {
//            fragmentTransaction.hide(currentFragment);
//        }
//
//        Fragment fragment = fragmentManager.findFragmentByTag(tag);
//        if (fragment == null) {
//            if (id == R.id.navigation_1) {
//                fragment = new Depart_Frag();
//            } else if (id == R.id.navigation_2) {
//                fragment = new Univ_Frag();
//            } else if (id == R.id.navigation_3) {
//                fragment = new Group_Frag();
//            } else if (id == R.id.navigation_4) {
//                fragment = new Bookmark_Frag();
//            }
//            fragmentTransaction.add(R.id.content_layout, fragment, tag);
//        } else {
//            fragmentTransaction.show(fragment);
//        }
//
//        fragmentTransaction.setPrimaryNavigationFragment(fragment);
//        fragmentTransaction.setReorderingAllowed(true);
//        fragmentTransaction.commitNow();
//
//
//
//    }


    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            if (position == 0) {
                return new Depart_Frag();
            } else if(position == 1) {
                return new Univ_Frag();
            } else if(position == 2) {
                return new Group_Frag();
            } else if(position ==3) {
                return new Bookmark_Frag();
            }
            return new Depart_Frag();
        }


        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}
