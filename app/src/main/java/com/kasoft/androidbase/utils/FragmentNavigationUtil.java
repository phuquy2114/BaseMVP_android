package com.kasoft.androidbase.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.kasoft.androidbase.R;

/**
 * Created by khanhnguyen on 10/05/2017
 */

public class FragmentNavigationUtil {

    public static void replaceFragment(FragmentManager fragmentManager, int containerId, Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(containerId, fragment, fragment.getTag())
                .addToBackStack(fragment.getTag())
                .commit();
    }

    public static void replaceFragmentWithSlideAnimation(FragmentManager fragmentManager, int containerId, Fragment fragment) {
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                .replace(containerId, fragment, fragment.getTag())
                .addToBackStack(fragment.getTag())
                .commit();
    }

    public static void replaceFragmentWithoutBackstack(FragmentManager fragmentManager, int containerId, Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(containerId, fragment, fragment.getTag())
                .commit();
    }
}
