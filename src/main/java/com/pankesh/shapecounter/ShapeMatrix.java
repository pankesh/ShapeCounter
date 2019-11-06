package com.pankesh.shapecounter;

public class ShapeMatrix {

    private ShapeCell[][] shapeMatrix;
    
    public ShapeMatrix(int rows, int cols) {
        shapeMatrix = new ShapeCell[rows][cols];
    }

    public ShapeCell getCell(int row, int col) {
        ShapeCell shapeCell = getShapeMatrix()[row][col];
        if (shapeCell != null) {
            shapeCell.touched++;
        }
        return shapeCell;
    }
    
    public void setCell(int row, int col, ShapeCell aShapeCell) {
        getShapeMatrix()[row][col] = aShapeCell;
    }
    
    public int getMaxRows() {
        return getShapeMatrix().length;
    }

    public int getMaxCols() {
        return getShapeMatrix()[0].length;
    }

    public ShapeCell[][] getShapeMatrix() {
        return shapeMatrix;
    }    

}

