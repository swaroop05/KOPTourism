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
public class AttractionsFragment extends Fragment {

    //Member variable to hold the object of PlacesInfo class
    private ArrayList<PlacesInfo> mPlacesInfo = new ArrayList<PlacesInfo>();
    //Member variable to hold rootView so that we can check if rootView is null before inflating a layout.
    private View mRootView;

    //Constructor
    public AttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.page_list_view, container, false);
            // Create a list of PlacesInfo
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.attraction1_name).toString(), getResources().getText(R.string.attraction1_address).toString(), getResources().getText(R.string.attraction1_hrs).toString(), R.drawable.attractions1, getResources().getText(R.string.attraction1_stars).toString(), getResources().getText(R.string.attraction1_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.attraction2_name).toString(), getResources().getText(R.string.attraction2_address).toString(), getResources().getText(R.string.attraction2_hrs).toString(), R.drawable.attractions2, getResources().getText(R.string.attraction2_stars).toString(), getResources().getText(R.string.attraction2_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.attraction3_name).toString(), getResources().getText(R.string.attraction3_address).toString(), getResources().getText(R.string.attraction3_hrs).toString(), R.drawable.attractions3, getResources().getText(R.string.attraction3_stars).toString(), getResources().getText(R.string.attraction3_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.attraction4_name).toString(), getResources().getText(R.string.attraction4_address).toString(), getResources().getText(R.string.attraction4_hrs).toString(), R.drawable.attractions4, getResources().getText(R.string.attraction4_stars).toString(), getResources().getText(R.string.attraction4_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.attraction5_name).toString(), getResources().getText(R.string.attraction5_address).toString(), getResources().getText(R.string.attraction5_hrs).toString(), R.drawable.attractions5, getResources().getText(R.string.attraction5_stars).toString(), getResources().getText(R.string.attraction5_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.attraction6_name).toString(), getResources().getText(R.string.attraction6_address).toString(), getResources().getText(R.string.attraction6_hrs).toString(), R.drawable.attractions6, getResources().getText(R.string.attraction6_stars).toString(), getResources().getText(R.string.attraction6_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.attraction7_name).toString(), getResources().getText(R.string.attraction7_address).toString(), getResources().getText(R.string.attraction7_hrs).toString(), R.drawable.attractions7, getResources().getText(R.string.attraction7_stars).toString(), getResources().getText(R.string.attraction7_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.attraction8_name).toString(), getResources().getText(R.string.attraction8_address).toString(), getResources().getText(R.string.attraction8_hrs).toString(), R.drawable.attractions8, getResources().getText(R.string.attraction8_stars).toString(), getResources().getText(R.string.attraction8_location).toString()));
            mPlacesInfo.add(new PlacesInfo(getResources().getText(R.string.attraction9_name).toString(), getResources().getText(R.string.attraction9_address).toString(), getResources().getText(R.string.attraction9_hrs).toString(), R.drawable.attractions9, getResources().getText(R.string.attraction9_stars).toString(), getResources().getText(R.string.attraction9_location).toString()));
            // Create an {@link PlacesInfoAdapter}, whose data source is a list of {@link PlacesInfo}s. The
            // adapter knows how to create list items for each item in the list.
            PlacesInfoAdapter itemsAdapter = new PlacesInfoAdapter(getActivity(), mPlacesInfo, R.color.light_brown);
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
