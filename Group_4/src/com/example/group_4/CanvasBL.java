package com.example.group_4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.alsnightsoft.vaadin.widgets.canvasplus.CanvasPlus;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
/**
 * This class creates a CanvasPlus object, which it has as variable
 * The drawing is done by using a boolean 'dragging' and a mousemovelistener
 * 'dragging' is toggled on mouse down/up, so the canvas knows when to draw
 * on a mouse move event, if dragging = true, then
 * canvas draws a line from the last known position of the mouse and the current position
 * A Graphics2d Object is created and modified with the canvas to enable saving
 */
public class CanvasBL {
	
	CanvasPlus canvas;
	Button eraser;
	Button save;
	
	int mouseLastX;
	int mouseLastY;
	boolean dragging;
	boolean erasing;
	
	final static String CANVAS_HEIGHT = "300px";
	final static String CANVAS_WIDTH = "300px";

	public BufferedImage image = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
	public Graphics2D draw = (Graphics2D) image.getGraphics();

	/**
	 * Class constructor, creates a canvas and an eraser button
	 */
	public CanvasBL() {
		canvas = new CanvasPlus();
		eraser = createEraser();
		createCanvas();
	}
	
	/**
	 * sets up the values and attaches listeners for the class CanvasPlus object
	 */
	public void createCanvas() {

		canvas.setHeight(CANVAS_HEIGHT);
		canvas.setWidth(CANVAS_WIDTH);
		canvas.setFillStyle("white");
		canvas.fillRect(0.0, 0.0,(double) canvas.getWidth(),(double) canvas.getHeight());
	
		draw.setColor(Color.white);
		draw.fillRect(0, 0, 300, 300);
		draw.setColor(Color.black);
		
		canvas.addClickDownListener(new CanvasPlus.CanvasClickDownListener() {
			public void onClickDown(MouseEventDetails mouseDetails) {
				dragging = true;
				mouseLastX = mouseDetails.getRelativeX();
				mouseLastY = mouseDetails.getRelativeY();
			}
		});
		
		canvas.addMouseMoveListener(new CanvasPlus.CanvasMouseMoveListener() {
			public void onMove(MouseEventDetails mouseDetails) {
				if (dragging == true) {
					if (erasing == true) {
						canvas.fillRect((double) mouseDetails.getRelativeX(),(double) mouseDetails.getRelativeY(), 25.0, 25.0);
					} else {
						canvas.beginPath();
						canvas.moveTo(mouseLastX, mouseLastY);
						canvas.lineTo(mouseDetails.getRelativeX(), mouseDetails.getRelativeY());
						draw.drawLine(mouseLastX, mouseLastY, mouseDetails.getRelativeX(), mouseDetails.getRelativeY());
						canvas.stroke();
						mouseLastX = mouseDetails.getRelativeX();
						mouseLastY = mouseDetails.getRelativeY();
					}
				}	
			}
		});
		
		canvas.addClickUpListener(new CanvasPlus.CanvasClickUpListener() {
			public void onClickUp(MouseEventDetails mouseDetails) {
				dragging = false;	
			}
		});
	}
	/**
	 * creates the eraser button and adds a listener
	 * @return  an eraser button
	 */
	
	public Button createEraser() {
		Button eraser = new Button("Eraser");
		eraser.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				erasing = !erasing;
			}
		});
		return eraser;
	}
}