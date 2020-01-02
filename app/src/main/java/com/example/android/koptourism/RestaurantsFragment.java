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
public class RestaurantsFragment extends Fragment {
    //Member variable to hold the object of PlacesInfo class
    private ArrayList<PlacesInfo> mPlacesInfo = new ArrayList<PlacesInfo>();

    //Member variable to hold mRootView so that we can check if mRootView is null before inflating a layout.
    private View mRootView;

    /**
     * Constructor
     */
    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.page_list_view, container, false);
            // Create a list of PlacesInfo
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.restaurants1_name).toString(), getResources().getText(R.string.restaurants1_address).toString(), getResources().getText(R.string.restaurants1_hrs).toString(), R.drawable.restaurant1, getResources().getText(R.string.restaurants1_stars).toString(), getResources().getText(R.string.restaurants1_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.restaurants2_name).toString(), getResources().getText(R.string.restaurants2_address).toString(), getResources().getText(R.string.restaurants2_hrs).toString(), R.drawable.restaurant2, getResources().getText(R.string.restaurants2_stars).toString(), getResources().getText(R.string.restaurants2_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.restaurants3_name).toString(), getResources().getText(R.string.restaurants3_address).toString(), getResources().getText(R.string.restaurants3_hrs).toString(), R.drawable.restaurant3, getResources().getText(R.string.restaurants3_stars).toString(), getResources().getText(R.string.restaurants3_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.restaurants4_name).toString(), getResources().getText(R.string.restaurants4_address).toString(), getResources().getText(R.string.restaurants4_hrs).toString(), R.drawable.restaurant4, getResources().getText(R.string.restaurants4_stars).toString(), getResources().getText(R.string.restaurants4_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.restaurants5_name).toString(), getResources().getText(R.string.restaurants5_address).toString(), getResources().getText(R.string.restaurants5_hrs).toString(), R.drawable.restaurant5, getResources().getText(R.string.restaurants5_stars).toString(), getResources().getText(R.string.restaurants5_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.restaurants6_name).toString(), getResources().getText(R.string.restaurants6_address).toString(), getResources().getText(R.string.restaurants6_hrs).toString(), R.drawable.restaurant6, getResources().getText(R.string.restaurants6_stars).toString(), getResources().getText(R.string.restaurants6_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.restaurants7_name).toString(), getResources().getText(R.string.restaurants7_address).toString(), getResources().getText(R.string.restaurants7_hrs).toString(), R.drawable.restaurant7, getResources().getText(R.string.restaurants7_stars).toString(), getResources().getText(R.string.restaurants7_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.restaurants8_name).toString(), getResources().getText(R.string.restaurants8_address).toString(), getResources().getText(R.string.restaurants8_hrs).toString(), R.drawable.restaurant8, getResources().getText(R.string.restaurants8_stars).toString(), getResources().getText(R.string.restaurants8_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.restaurants9_name).toString(), getResources().getText(R.string.restaurants9_address).toString(), getResources().getText(R.string.restaurants9_hrs).toString(), R.drawable.restaurant9, getResources().getText(R.string.restaurants9_stars).toString(), getResources().getText(R.string.restaurants9_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.restaurants10_name).toString(), getResources().getText(R.string.restaurants10_address).toString(), getResources().getText(R.string.restaurants10_hrs).toString(), R.drawable.restaurant10, getResources().getText(R.string.restaurants10_stars).toString(), getResources().getText(R.string.restaurants10_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.restaurants11_name).toString(), getResources().getText(R.string.restaurants11_address).toString(), getResources().getText(R.string.restaurants11_hrs).toString(), R.drawable.restaurant11, getResources().getText(R.string.restaurants11_stars).toString(), getResources().getText(R.string.restaurants11_location).toString()));
            // Create an {@link PlacesInfoAdapter}, whose data source is a list of {@link PlacesInfo}s. The
            // adapter knows how to create list items for each item in the list.
            PlacesInfoAdapter itemsAdapter = new PlacesInfoAdapter(getActivity(), mPlacesInfo, R.color.light_amber);
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
