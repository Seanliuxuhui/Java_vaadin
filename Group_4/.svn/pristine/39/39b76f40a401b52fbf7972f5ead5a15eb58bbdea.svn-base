package com.example.group_4;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapMarker;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

/**This class defines the canvas page associated with a location that is passed in
 * It creates a label which displays the current location
 * and a canvas for the user to draw on
 */
public class CanvasView extends VerticalLayout {

	public GoogleMapMarker location;
	public Button returnButton;
	public Button saveButton;
	public CanvasBL canvas;
	public String savePath;
	
	/**
	 * Class constructor, creates a CanvasView for the specified marker
	 * The view has a canvas component, an eraser button, and a return button
	 * @param the marker that was clicked on
	 */

	public CanvasView(GoogleMapMarker location) {
		this.location = location;
		savePath = "C:/Users/Liu/Desktop/winter term course/software engineering/graffiti/" + location.getCaption() + ".png";
	    canvas = new CanvasBL();
		addComponent(createLabel());
		addComponent(canvas.canvas);
		addComponent(canvas.eraser);
		
		returnButton = createReturnButton();
		returnButton.setId("return");
		addComponent(returnButton);
		
		saveButton = createSaveButton();	
		saveButton.setId("save");
		addComponent(saveButton);
		
		try {
			String[] a  = {savePath};
			canvas.canvas.loadImages(a);
			canvas.canvas.drawImage(savePath, 0.0, 0.0);
			BufferedImage image = null;
			try {
				image = ImageIO.read(new File(savePath));
				canvas.draw.drawImage(image, null, 0, 0);
			} catch (IOException e) {
			}
		}
		catch (NullPointerException e){
			
		}
	}
	
	/**
	 * Creates a Label which displays the location information
	 * @return the Label created
	 */
	
	private Label createLabel() {
		Label label = new Label("Now Drawing for location: " + location.getCaption());
		return label;
	}
	/**
	 * Creates a Button that will return the user to the main view
	 * @return the Button created
	 */
	private Button createReturnButton() {
		Button returnButton = new Button("Return");
		return returnButton;
	}
	
	/**
	 * Creates the save button, and adds a listener to it
	 * @return the save button
	 */
	private Button createSaveButton() {
		Button save = new Button("Save");
		save.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				try {
					ImageIO.write(canvas.image, "png", new File(savePath));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		return save;
	}
}
