package com.example.android.koptourism;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends Fragment {
    //Member variable to hold the object of PlacesInfo class
    private ArrayList<PlacesInfo> mPlacesInfo = new ArrayList<PlacesInfo>();
    //Member variable to hold mRootView so that we can check if mRootView is null before inflating a layout.
    private View mRootView;

    /**
     * Constructor
     */
    public ShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.page_list_view, container, false);
            // Create a list of PlacesInfo
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.shopping1_name).toString(), getResources().getText(R.string.shopping1_address).toString(), getResources().getText(R.string.shopping1_hrs).toString(), R.drawable.shopping1, getResources().getText(R.string.shopping1_stars).toString(), getResources().getText(R.string.shopping1_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.shopping2_name).toString(), getResources().getText(R.string.shopping2_address).toString(), getResources().getText(R.string.shopping2_hrs).toString(), R.drawable.shopping2, getResources().getText(R.string.shopping2_stars).toString(), getResources().getText(R.string.shopping2_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.shopping3_name).toString(), getResources().getText(R.string.shopping3_address).toString(), getResources().getText(R.string.shopping3_hrs).toString(), R.drawable.shopping3, getResources().getText(R.string.shopping3_stars).toString(), getResources().getText(R.string.shopping3_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.shopping4_name).toString(), getResources().getText(R.string.shopping4_address).toString(), getResources().getText(R.string.shopping4_hrs).toString(), R.drawable.shopping4, getResources().getText(R.string.shopping4_stars).toString(), getResources().getText(R.string.shopping4_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.shopping5_name).toString(), getResources().getText(R.string.shopping5_address).toString(), getResources().getText(R.string.shopping5_hrs).toString(), R.drawable.shopping5, getResources().getText(R.string.shopping5_stars).toString(), getResources().getText(R.string.shopping5_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.shopping6_name).toString(), getResources().getText(R.string.shopping6_address).toString(), getResources().getText(R.string.shopping6_hrs).toString(), R.drawable.shopping6, getResources().getText(R.string.shopping6_stars).toString(), getResources().getText(R.string.shopping6_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.shopping7_name).toString(), getResources().getText(R.string.shopping7_address).toString(), getResources().getText(R.string.shopping7_hrs).toString(), R.drawable.shopping7, getResources().getText(R.string.shopping7_stars).toString(), getResources().getText(R.string.shopping7_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.shopping8_name).toString(), getResources().getText(R.string.shopping8_address).toString(), getResources().getText(R.string.shopping8_hrs).toString(), R.drawable.shopping8, getResources().getText(R.string.shopping8_stars).toString(), getResources().getText(R.string.shopping8_location).toString()));
            // Create an {@link PlacesInfoAdapter}, whose data source is a list of {@link PlacesInfo}s. The
            // adapter knows how to create list items for each item in the list.
            PlacesInfoAdapter itemsAdapter = new PlacesInfoAdapter(getActivity(), mPlacesInfo, R.color.dark_green);
            // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
            // There should be a {@link ListView} with the view ID called list, which is declared in the
            // page_list.xml layout file.
            ListView listView = (ListView) mRootView.findViewById(R.id.list);
            // Make the {@link ListView} use the {@link PlacesInfoAdapter} we created above, so that the
            // {@link ListView} will display list items for each {@link PlacesInfo} in the list.
            listView.setAdapter(itemsAdapter);
            // Set a click listener to play the audio when the list item is clicked on
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    openMaps(mPlacesInfo.get(position).getmLocation());
                }
            });
        }
        return mRootView;
    }

    /**
     * Method to Open maps intent when necessary URI is passed as parameter
     *
     * @param location: URI value in String format.
     */
    public void openMaps(String location) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(location));
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
