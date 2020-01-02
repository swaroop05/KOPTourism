package com.example.android.koptourism;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by meets on 12/1/2017.
 */

/**
 * {@link PlacesInfoAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link PlacesInfo} objects.
 */
public class PlacesInfoAdapter extends ArrayAdapter<PlacesInfo> {
    /**
     * Resource ID for the background color for this list of Places
     */
    int mColorResID;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_view, parent, false);
        }
        // Get the {@link PlacesInfo} object located at this position in the list
        PlacesInfo currentInstance = getItem(position);
        // Set the theme color for the list item
        View linearLayout = listItemView.findViewById(R.id.place_info_linear_layout);
        int color = ContextCompat.getColor(getContext(), mColorResID);
        linearLayout.setBackgroundColor(color);
        // Find the TextView in the list_item_view.xml layout with the ID place_name.
        TextView placeTextView = (TextView) listItemView.findViewById(R.id.place_name);
        // Get the PlaceName from the current PlaceInfo object and set this text on
        // the placeTextView.
        placeTextView.setText(currentInstance.getmPlaceName());
        // Find the TextView in the list_item_view.xml layout with the ID address.
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address);
        // Get the Address from the current PlaceInfo object and set this text on
        // the addressTextView.
        addressTextView.setText(currentInstance.getmAddress());
        // Find the TextView in the list_item_view.xml layout with the ID hours.
        TextView hoursTextView = (TextView) listItemView.findViewById(R.id.hours);
        // Get the Hours of Operation from the current PlaceInfo object and set this text on
        // the hoursTextView.
        hoursTextView.setText(currentInstance.getmHours());
        // Find the TextView in the list_item_view.xml layout with the ID stars_image_view.
        TextView starsTextView = (TextView) listItemView.findViewById(R.id.stars_image_view);
        // Get the number of stars from the current PlaceInfo object and set this text on
        // the starsTextView.
        starsTextView.setText(currentInstance.getmStars());
        // Find the ImageView in the list_item_view.xml layout with the ID place_image_view.
        ImageView placeImageView = (ImageView) listItemView.findViewById(R.id.place_image_view);
        //If there is no imageResID for current instance of PlaceInfo Object, then make that view disappear else
        //set that View with PlaceInfo Object's current image res ID.
        if (currentInstance.getmPlaceImageResID() > 0) {
            placeImageView.setImageResource(currentInstance.getmPlaceImageResID());
            placeImageView.setVisibility(View.VISIBLE);
        } else {
            placeImageView.setVisibility(View.GONE);
        }
        return listItemView;
    }

    /**
     * Create a new {@link PlacesInfoAdapter} object.
     *
     * @param context      is the current context (i.e. Activity) that the adapter is being created in.
     * @param PlaceInfoObj is the list of {@link PlacesInfo}s to be displayed.
     * @param colorResID   is the resource ID for the background color for this list of PlacesInfo
     */
    public PlacesInfoAdapter(Context context, ArrayList<PlacesInfo> PlaceInfoObj, int colorResID) {
        super(context, 0, (ArrayList<PlacesInfo>) PlaceInfoObj);
        mColorResID = colorResID;
    }
}
