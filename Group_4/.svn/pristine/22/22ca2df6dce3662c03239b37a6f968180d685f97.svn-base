package com.example.group_4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.alsnightsoft.vaadin.widgets.canvasplus.CanvasPlus;

public class CanvasBLTest {

	CanvasBL canvas;
	
	@Before
	public void setup(){
		canvas = new CanvasBL();
	}
	
	@Test
	public void canvasExists(){
		assertTrue(canvas.canvas!=null);
	}
	
	@Test
	public void canvasHasClickDownListener() {
		assertTrue(canvas.canvas.getListeners(CanvasPlus.CanvasClickDownListener.class)!=null);
	}
	
	@Test
	public void canvasHasMouseMoveListener() {
		assertTrue(canvas.canvas.getListeners(CanvasPlus.CanvasMouseMoveListener.class)!=null);
	}
	
	@Test
	public void canvasHasClickUpListener() {
		assertTrue(canvas.canvas.getListeners(CanvasPlus.CanvasClickUpListener.class)!=null);
	}
}
