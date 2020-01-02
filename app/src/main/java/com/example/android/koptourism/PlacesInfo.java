package com.example.android.koptourism;

/**
 * Created by meets on 12/1/2017.
 */

public class PlacesInfo {

    /**
     * Place Name Variable
     */
    private String mPlaceName;
    /**
     * Address of Place Variable
     */
    private String mAddress;
    /**
     * Hours of Operation Variable
     */
    private String mHours;
    /**
     * Number of stars Variable
     */
    private String mStars;
    /**
     * Place Image Resource ID Variable
     */
    private int mPlaceImageResID;
    /**
     * Stars Image Resource ID Variable
     */
    private int mStarImageResID;
    /**
     * Location in langitude and longitude Variable
     */
    private String mLocation;

    /**
     * Create a new PlacesInfo Object with following parameter
     *
     * @param placeName:  Place Name in String
     * @param address:    Address of the Place in String
     * @param hours:      Hours of Operation value in String
     * @param placeImage: Place Image resource ID
     * @param stars:      stars information in String
     * @param location:   location of langitude and longitude in String which will be later parsed by URI
     */
    public PlacesInfo(String placeName, String address, String hours, int placeImage, String stars, String location) {
        mPlaceName = placeName;
        mAddress = address;
        mHours = hours;
        mPlaceImageResID = placeImage;
        mStars = stars;
        mLocation = location;
    }

    /**
     * Get the Place Name
     */
    public String getmPlaceName() {
        return mPlaceName;
    }

    /**
     * Get the address of the Place
     */
    public String getmAddress() {
        return mAddress;
    }

    /**
     * Get the Hours of Operation of the Place
     */
    public String getmHours() {
        return mHours;
    }

    /**
     * Get the Place's Image Resource ID
     */
    public int getmPlaceImageResID() {
        return mPlaceImageResID;
    }

    /**
     * Get the number of Stars Image ID of the Place
     */
    public int getmStarImageResID() {
        return mStarImageResID;
    }

    /**
     * Get the Number of stars in String for the place
     */
    public String getmStars() {
        return mStars;
    }

    /**
     * Get the location information of the place
     */
    public String getmLocation() {
        return mLocation;
    }

}
