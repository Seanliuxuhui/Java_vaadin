package com.example.group_4.events;

import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.events.MarkerClickListener;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapInfoWindow;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapMarker;

/**
 * Listener that opens info window when a marker is clicked.
 */
public class OpenInfoWindowOnMarkerClickListener implements MarkerClickListener {

    private static final long serialVersionUID = 646386541641L;

    private final GoogleMap map;
    private final GoogleMapMarker marker;
    private final GoogleMapInfoWindow window;

    /**Class constructor, creates an instance of the class for the input
     * @param GoogleMap instance that the marker is on
     * @param Marker which is clicked to trigger the event
     * @param window that opens when the event happens
     */
    public OpenInfoWindowOnMarkerClickListener(GoogleMap map,
            GoogleMapMarker marker, GoogleMapInfoWindow window) {
        this.map = map;
        this.marker = marker;
        this.window = window;
    }
    /**
     * A method to define what happens when the marker is clicked
     * @param Marker which is clicked
     */

    public void markerClicked(GoogleMapMarker clickedMarker) {
        if (clickedMarker.equals(marker)) {
            map.openInfoWindow(window);
        }
    }

}
