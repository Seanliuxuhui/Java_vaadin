package com.example.group_4;

import com.example.group_4.events.OpenInfoWindowOnMarkerClickListener;
import com.example.group_4.GoogleMapUI;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.tapio.googlemaps.client.events.InfoWindowClosedListener;
import com.vaadin.tapio.googlemaps.client.events.MapClickListener;
import com.vaadin.tapio.googlemaps.client.events.MapMoveListener;
import com.vaadin.tapio.googlemaps.client.events.MarkerClickListener;
import com.vaadin.tapio.googlemaps.client.events.MarkerDragListener;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapInfoWindow;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapMarker;
import com.vaadin.ui.Label;

/**
 * This class specifies the layout for the GoogleMap
 * It contains a static method which returns a GoogleMap object
 */
public class GoogleMapUI{
	

	public static GoogleMapMarker dalhousieMarker = new GoogleMapMarker(
	            "Dalhousie University", new LatLon(44.636581, -63.591655),
	            false, null);
	
	public static GoogleMapMarker marker2 = new GoogleMapMarker("Location 2", new LatLon(45.636581, -63.591655), false, null);
	public static GoogleMapMarker marker3 = new GoogleMapMarker("Location 3", new LatLon(46.636581, -63.591655), false, null);
	
	public static GoogleMapInfoWindow dalhousieInfoWindow = new GoogleMapInfoWindow(
    		"Here is Dalhousie University", dalhousieMarker);

    
    /**
     *  This static method build and then returns a GoogleMap object
     * it adds a couple markers, defines the characteristics of the map, and adds listeners
     * @return the created googleMap object
     */
    
    public static GoogleMap setupGoogleMap(){
        final GoogleMap googleMap = new GoogleMap(null, null, null);
        googleMap.setCenter(new LatLon(44.6453300, -63.5723900));
        googleMap.setZoom(10);
        googleMap.setSizeFull();
        dalhousieMarker.setAnimationEnabled(false);
        googleMap.addMarker(dalhousieMarker);
        googleMap.addMarker(marker2);
        googleMap.addMarker(marker3);
        googleMap.setMinZoom(4);
        googleMap.setMaxZoom(16);

        dalhousieInfoWindow.setWidth("400px");
        dalhousieInfoWindow.setHeight("500px");
 
        OpenInfoWindowOnMarkerClickListener infoWindowOpener = new OpenInfoWindowOnMarkerClickListener(
                googleMap, dalhousieMarker, dalhousieInfoWindow);
        googleMap.addMarkerClickListener(infoWindowOpener);

        googleMap.addMarkerClickListener(new MarkerClickListener() {
            public void markerClicked(GoogleMapMarker clickedMarker) {
                Label consoleEntry = new Label("Marker \""
                        + clickedMarker.getCaption() + "\" at ("
                        + clickedMarker.getPosition().getLat() + ", "
                        + clickedMarker.getPosition().getLon() + ") clicked.");
            }
        });
        
        

        googleMap.addMapMoveListener(new MapMoveListener() {
            public void mapMoved(int zoomLevel, LatLon center, LatLon boundsNE,
                    LatLon boundsSW) {
                Label consoleEntry = new Label("Map moved to ("
                        + center.getLat() + ", " + center.getLon() + "), zoom "
                        + zoomLevel + ", boundsNE: (" + boundsNE.getLat()
                        + ", " + boundsNE.getLon() + "), boundsSW: ("
                        + boundsSW.getLat() + ", " + boundsSW.getLon() + ")");
            }
        });

//        googleMap.addMapClickListener(new MapClickListener() {
//            public void mapClicked(LatLon position) {
//                Label consoleEntry = new Label("Map click to ("
//                        + position.getLat() + ", " + position.getLon() + ")");
//                GoogleMapMarker temp = new GoogleMapMarker("",new LatLon(position.getLat(), position.getLon()),true, null);
//                googleMap.addMarker(temp);
//                GoogleMapInfoWindow temp_window = new GoogleMapInfoWindow("new place",temp);
//                OpenInfoWindowOnMarkerClickListener temp_info = new OpenInfoWindowOnMarkerClickListener(googleMap,temp, temp_window);
//                googleMap.addMarkerClickListener(temp_info);
//            }
//        });

        googleMap.addMarkerDragListener(new MarkerDragListener() {
            public void markerDragged(GoogleMapMarker draggedMarker,
                    LatLon oldPosition) {
                Label consoleEntry = new Label("Marker \""
                        + draggedMarker.getCaption() + "\" dragged from ("
                        + oldPosition.getLat() + ", " + oldPosition.getLon()
                        + ") to (" + draggedMarker.getPosition().getLat()
                        + ", " + draggedMarker.getPosition().getLon() + ")");
            }
        });

        googleMap.addInfoWindowClosedListener(new InfoWindowClosedListener() {

            public void infoWindowClosed(GoogleMapInfoWindow window) {
                Label consoleEntry = new Label("InfoWindow \""
                        + window.getContent() + "\" closed");
            }
        });
        return googleMap;
	}
    
    /**
     * A method which returns the info window defined as a class variable
     * @return the GoogleMapInfoWindow
     */
    
    public GoogleMapInfoWindow getInfoWindow(){
		return dalhousieInfoWindow;
	}
    
    /**
     * A method which adds a marker to the map with specific user name 
     * @param username
     * @param longitude
     * @param latitude
     */
    
}
