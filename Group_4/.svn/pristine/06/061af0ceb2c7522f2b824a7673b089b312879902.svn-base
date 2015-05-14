package com.example.group_4;


import java.io.File;

import javax.servlet.annotation.WebServlet;

import com.alsnightsoft.vaadin.widgets.canvasplus.CanvasPlus;
import com.example.group_4.events.OpenInfoWindowOnMarkerClickListener;
import com.example.group_4.GoogleMapUI;
import com.example.group_4.LoginView;
import com.example.group_4.UserInformation;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.GoogleMapControl;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.tapio.googlemaps.client.events.InfoWindowClosedListener;
import com.vaadin.tapio.googlemaps.client.events.MapClickListener;
import com.vaadin.tapio.googlemaps.client.events.MapMoveListener;
import com.vaadin.tapio.googlemaps.client.events.MarkerClickListener;
import com.vaadin.tapio.googlemaps.client.events.MarkerDragListener;
import com.vaadin.tapio.googlemaps.client.layers.GoogleMapKmlLayer;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapInfoWindow;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapMarker;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapPolygon;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapPolyline;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This is the UI class for the project
 * It builds a layout for the main page
 * There is a login button component, which has a click listener that triggers the LoginView
 * There is a GoogleMap component, which has a click listener that triggers the CanvasView
 * There is a MapOperations component, which adds some buttons for map control
 */
@SuppressWarnings("serial")
@Theme("group_4")
public class Group_4UI extends UI {
	
	private UserInformation userinfo;
	private static GoogleMap googlemap;
	
	/**
	 * The Class constructor for a logged in user
	 * @param UserInformation of the user
	 */
    public Group_4UI(UserInformation user){
    	this.userinfo = user;
    }
    /**
     * The Class constructor for a non-logged in user
  	 * sets the user information to be blank
     */
    public Group_4UI(){
    	this.userinfo = new UserInformation("","");
    }
    private final String apiKey = "";
    
    /**
     * The method which defines the servlet and widgetset
     */
    
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Group_4UI.class, widgetset="com.example.group_4.widgetset.Group_4Widgetset")
	public static class Servlet extends VaadinServlet {
	}

		/**
		 * initiates the view
		 */
	    @Override
	    protected void init(VaadinRequest request) {
	    	final VerticalLayout container = setUpStartPage();
	    }
	    /**
	     * The method which creates the startUpPage Layout
	     * @return The Layout created
	     */
	    
	    public VerticalLayout setUpStartPage() {
	    	//container for all the components
	    	final VerticalLayout container = new VerticalLayout();
	    	setContent(container);
	    	container.setSizeFull();
	    	//section for the navigation section
	    	if(this.userinfo.getUsername() ==""){
	        	//section for the login info
	        	 Panel nav_bar = new Panel();
	        	 nav_bar.setCaption("Hello world");
	             Button login = new Button("Login");
	             login.setId("login");
	             nav_bar.setContent(login);
	             container.addComponent(login);
	             login.addClickListener(new ClickListener(){

	     			public void buttonClick(ClickEvent event) {
	     				LoginView loginview = new LoginView();
	     				container.removeAllComponents();
	     				container.addComponent(loginview);
	     			}
	             });
	             
	        }else{
	        	Panel nav_bar = new Panel();
	        	Label welcome = new Label("Welcome\n" + this.userinfo.getUsername());
	        	welcome.setId("welcome_label");
	        	nav_bar.setContent(welcome);
	        	container.addComponent(nav_bar);
	        }
	        //section for the google map
	        googlemap = GoogleMapUI.setupGoogleMap();
	        googlemap.setId("googlemap");
	    
	        container.addComponent(googlemap);
	        container.setExpandRatio(googlemap, 1.0f);
	        
	        googlemap.addMarkerClickListener(new MarkerClickListener() {
	        	//this is a click listener which engages the canvas view when a location is clicked
	            public void markerClicked(GoogleMapMarker clickedMarker) {
	            	CanvasView canvasView = new CanvasView(clickedMarker);
	            	container.removeAllComponents();
	            	container.addComponent(canvasView);
	            	canvasView.returnButton.addClickListener(new Button.ClickListener() {
						//a click listener applied to a button in the canvas view that returns to the start up page
						public void buttonClick(ClickEvent event) {
							setUpStartPage();
						}
					});
	            }
	        });
	        
	        Panel google_map_operations_panel  = new Panel();
	        MapOperations map_operations = new MapOperations(googlemap);
	        google_map_operations_panel.setContent(map_operations);
	        container.addComponent(google_map_operations_panel);
	       
	        return container;
	    }
	    /**
	     *A method which returns the instance of GoogleMap that is running
	     * @return GoogleMap
	     */
	    public GoogleMap instance(){
	    	return googlemap;
	    }
		
		
	    
		
	
}