package com.liuting.jetpack.jetpackdemo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;


import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.Map;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.NavHostFragment;

/**
 * @author gittar
 * @desc 重写navigator，防止重复创建fragment
 */
public class BottomNavHostFragment extends NavHostFragment {
    private BottomNavigator bottomNavigator;
    @NonNull
    @Override
    protected Navigator<? extends FragmentNavigator.Destination> createFragmentNavigator() {
        this.bottomNavigator = new BottomNavigator(requireContext(), getChildFragmentManager(), getId());
        return this.bottomNavigator;
    }



    @Navigator.Name("bottom_nav_fragment")
    public class BottomNavigator extends FragmentNavigator {
        private static final String TAG = "BottomNavigator";

        private Context context;
        private FragmentManager manager;
        int containerId;

        public BottomNavigator(@NonNull Context context, @NonNull FragmentManager manager, int containerId) {
            super(context, manager, containerId);
            this.context = context;
            this.manager = manager;
            this.containerId = containerId;
        }



        @Nullable
        @Override
        public NavDestination navigate(@NonNull Destination destination, @Nullable Bundle args, @Nullable NavOptions navOptions, @Nullable Navigator.Extras navigatorExtras) {
            try {
                //反射获取mBackStack mIsPendingBackStackOperation
                Field mBackStackField = FragmentNavigator.class.getDeclaredField("mBackStack");
                mBackStackField.setAccessible(true);
                ArrayDeque<Integer> mBackStack = (ArrayDeque<Integer>) mBackStackField.get(this);

                String className = destination.getClassName();
                if (className.charAt(0) == '.') {
                    className = context.getPackageName() + className;
                }

                FragmentTransaction ft = manager.beginTransaction();
                final Fragment currentFragment = manager.getPrimaryNavigationFragment();
                if (currentFragment != null) {
                    if(!currentFragment.getClass().getName().equals(className)) {
                        ft.hide(currentFragment);
                    }else {
                        return null;
                    }
                }
                Fragment frag = manager.findFragmentByTag(className);

                if (frag == null) {

                    frag = instantiateFragment(context, manager, className, args);
                    frag.setArguments(args);
                    ft.add(containerId, frag, className);
                } else {
                    ft.show(frag);
                }

                ft.setPrimaryNavigationFragment(frag);

                @IdRes int destId = destination.getId();
                boolean initialNavigation = mBackStack.isEmpty();
                boolean isSingleTopReplacement = (navOptions != null && !initialNavigation
                        && navOptions.shouldLaunchSingleTop()
                        && mBackStack.peekLast() == destId);

                boolean isAdded;
                if (initialNavigation) {
                    isAdded = true;
                    int enterAnim = navOptions != null ? navOptions.getEnterAnim() : -1;
                    int exitAnim = navOptions != null ? navOptions.getExitAnim() : -1;
                    int popEnterAnim = navOptions != null ? navOptions.getPopEnterAnim() : -1;
                    int popExitAnim = navOptions != null ? navOptions.getPopExitAnim() : -1;
                    if (enterAnim != -1 || exitAnim != -1 || popEnterAnim != -1 || popExitAnim != -1) {
                        enterAnim = enterAnim != -1 ? enterAnim : 0;
                        exitAnim = exitAnim != -1 ? exitAnim : 0;
                        popEnterAnim = popEnterAnim != -1 ? popEnterAnim : 0;
                        popExitAnim = popExitAnim != -1 ? popExitAnim : 0;
                        ft.setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim);
                    }
                } else if (isSingleTopReplacement) {
                    // Single Top means we only want one instance on the back stack
                    if (mBackStack.size() > 1) {
                        // If the Fragment to be replaced is on the FragmentManager's
                        // back stack, a simple replace() isn't enough so we
                        // remove it from the back stack and put our replacement
                        // on the back stack in its place
                        manager.popBackStack(
                                generateMyBackStackName(mBackStack.size(), mBackStack.peekLast()),
                                FragmentManager.POP_BACK_STACK_INCLUSIVE
                        );
                        ft.addToBackStack(generateMyBackStackName(mBackStack.size(), destId));
                    }
                    isAdded = false;
                } else {
                    ft.addToBackStack(generateMyBackStackName(mBackStack.size() + 1, destId));
                    isAdded = true;
                }
                if (navigatorExtras instanceof Extras) {
                    Extras extras = (Extras) navigatorExtras;
                    for (Map.Entry<View, String> sharedElement : extras.getSharedElements().entrySet()) {
                        ft.addSharedElement(sharedElement.getKey(), sharedElement.getValue());
                    }
                }
                ft.setReorderingAllowed(true);
                ft.commitAllowingStateLoss();
                // The commit succeeded, update our view of the world
                if (isAdded) {
                    mBackStack.add(destId);
                    return destination;
                } else {
                    return null;
                }

            } catch (Exception e) {
                e.printStackTrace();
                return super.navigate(destination, args, navOptions, navigatorExtras);
            }
        }

        private String generateMyBackStackName(int backStackIndex, int destId) {
            return backStackIndex + "-" + destId;
        }
    }
}
