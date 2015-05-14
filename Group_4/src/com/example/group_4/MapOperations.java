package com.example.group_4;

import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Button.ClickEvent;

/**
 * This class builds the MapOperations panel that is added to the main page
 * Creates a couple buttons, and adds listeners for them
 */

public class MapOperations extends HorizontalLayout{
	
	/**
	 * The Class constructor
	 * Takes in a GoogleMap instance as a parameter, as the buttons modify the map
	 * @param GoogleMap
	 */
	public MapOperations(final GoogleMap googleMap){
		setSizeFull();
		setMargin(true);
		final Button ZoomIn = new Button("Zoom In");
		final Button ZoomOut=  new Button("Zoom Out");
		
		ZoomIn.addClickListener(new Button.ClickListener() {
			
			public void buttonClick(ClickEvent event) {
//				double zoom_indicator = 10 ;
//				googleMap.setVisibleAreaBoundLimits(new LatLon(location.getLat() + zoom_indicator/2, location.getLon()+zoom_indicator),new LatLon(location.getLat() - zoom_indicator/2,location.getLon()- zoom_indicator));
				googleMap.setZoom(googleMap.getZoom() + 1);
			}
		});
		
		ZoomOut.addClickListener(new Button.ClickListener() {
			
			public void buttonClick(ClickEvent event) {
//				double zoom_indicator = -10;
//				googleMap.setVisibleAreaBoundLimits(new LatLon(location.getLat() + zoom_indicator/2,location.getLon() + zoom_indicator),new LatLon(location.getLat()-zoom_indicator/2,location.getLon() - zoom_indicator));
				googleMap.setZoom(googleMap.getZoom() - 1);
			}
		});
		addComponent(ZoomIn);
		ZoomIn.setId("zoomin");
		setComponentAlignment(ZoomIn, Alignment.BOTTOM_CENTER);
		
		addComponent(ZoomOut);
		ZoomOut.setId("zoomout");
		setComponentAlignment(ZoomOut, Alignment.BOTTOM_CENTER);
	}
}
