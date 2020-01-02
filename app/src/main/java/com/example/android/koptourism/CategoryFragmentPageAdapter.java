package com.example.android.koptourism;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by meets on 12/2/2017.
 */

/**
 * {@link CategoryFragmentPageAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link PlacesInfo} objects.
 */
public class CategoryFragmentPageAdapter extends FragmentPagerAdapter {
    private Context mContext;

    /**
     * Create a new {@link CategoryFragmentPageAdapter} object.
     *
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public CategoryFragmentPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ParksFragment();
        } else if (position == 1) {
            return new AttractionsFragment();
        } else if (position == 2) {
            return new ShoppingFragment();
        } else {
            return new RestaurantsFragment();
        }
    }

    /**
     * Returns the Page Title
     */
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.parks_category_name);
        } else if (position == 1) {
            return mContext.getString(R.string.attractions_category);
        } else if (position == 2) {
            return mContext.getString(R.string.shopping_category);
        } else {
            return mContext.getString(R.string.restaurants_category);
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }
}
