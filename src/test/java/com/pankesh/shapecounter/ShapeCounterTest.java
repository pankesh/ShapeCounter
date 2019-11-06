package com.pankesh.shapecounter;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShapeCounterTest {

    private InputReceiver inputReceiver;

    @Before
    public void setUp() throws Exception {
        inputReceiver = new InputReceiver();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAllOnes() {
        ShapeMatrix shapeMatrix = inputReceiver.readShape(
        // @formatter:off
        new int[][] {   { 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1 }, 
                        { 1, 1, 1, 1, 1 }, 
                        { 1, 1, 1, 1, 1 }, 
                        { 1, 1, 1, 1, 1 } });
        // @formatter:on
        
        assertEquals(1, ShapeCounter.countShapes(shapeMatrix));
    }

    @Test
    public void testAllZeros() {
        ShapeMatrix shapeMatrix = inputReceiver.readShape(
        // @formatter:off
        new int[][] {   { 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0 }, 
                        { 0, 0, 0, 0, 0 }, 
                        { 0, 0, 0, 0, 0 }, 
                        { 0, 0, 0, 0, 0 } });
        // @formatter:on
        
        assertEquals(0, ShapeCounter.countShapes(shapeMatrix));
    }
    
    @Test
    public void testTriangularMatrix() {
        ShapeMatrix shapeMatrix = inputReceiver.readShape(
        // @formatter:off
        new int[][] {   { 0, 1, 1, 1, 1 },
                        { 1, 0, 1, 1, 1 }, 
                        { 1, 1, 0, 1, 1 }, 
                        { 1, 1, 1, 0, 1 }, 
                        { 1, 1, 1, 1, 0 } });
        // @formatter:on
        
        assertEquals(2, ShapeCounter.countShapes(shapeMatrix));
    }
    
    @Test
    public void testIsland() {
        ShapeMatrix shapeMatrix = inputReceiver.readShape(
        // @formatter:off
        new int[][] {   { 1, 1, 0, 1, 1 },
                        { 1, 1, 0, 1, 1 }, 
                        { 0, 0, 0, 0, 0 }, 
                        { 1, 1, 0, 1, 1 }, 
                        { 1, 1, 0, 1, 1 } });
        // @formatter:on 
        
        assertEquals(4, ShapeCounter.countShapes(shapeMatrix));
    }
    
    @Test
    public void testIslandWithDiagonal() {
        ShapeMatrix shapeMatrix = inputReceiver.readShape(
        // @formatter:off
        new int[][] {   { 1, 1, 0, 1, 1 },
                        { 1, 1, 0, 1, 1 }, 
                        { 0, 0, 1, 0, 0 }, 
                        { 1, 1, 1, 1, 1 }, 
                        { 1, 1, 0, 1, 1 } });
        // @formatter:on 
        
        assertEquals(3, ShapeCounter.countShapes(shapeMatrix));
    }
    
    @Test
    public void testALargeMatrix() {
        ShapeMatrix shapeMatrix = inputReceiver.readShape(
        // @formatter:off
        new int[][] {   { 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                        { 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0 }, 
                        { 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1 }, 
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
                        { 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0 }, 
                        { 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1 }, 
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
                        { 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0 }, 
                        { 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1 }, 
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
                        { 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0 }, 
                        { 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1 }, 
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
                        { 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0 }, 
                        { 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1 }, 
                        { 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0 } });
        // @formatter:on         
        assertEquals(16, ShapeCounter.countShapes(shapeMatrix));
    }
    
    @Test
    public void testRealWorldExample() {
        ShapeMatrix shapeMatrix = inputReceiver.readShape(
        // @formatter:off
        new int[][] {   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                        { 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 }, 
                        { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 }, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                        { 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                        { 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, 
                        { 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, 
                        { 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, 
                        { 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, 
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } });
        // @formatter:on 
        assertEquals(5, ShapeCounter.countShapes(shapeMatrix));
    }
    



}
