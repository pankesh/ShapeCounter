package com.pankesh.shapecounter;

public class ShapeCounter {
    public static void main(String[] args) {
        InputReceiver inputReceiver = new InputReceiver();
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

        countShapes(shapeMatrix);
    }

    public static int countShapes(ShapeMatrix shapeMatrix) {
        int shapesFound = 0;
        for (int row = 0; row < shapeMatrix.getMaxRows(); row++) {
            for (int col = 0; col < shapeMatrix.getMaxCols(); col++) {
                if (findShapes(shapeMatrix, row, col)) {
                    shapesFound++;
                    System.out.println("----------");
                }
            }
        }
        System.out.println("Total Shapes found " + shapesFound);
        return shapesFound;
    }

    private static boolean findShapes(ShapeMatrix shapeMatrix, int row, int col) {
        boolean foundShape = false;

        ShapeCell cell = shapeMatrix.getCell(row, col);
        if (cell != null && cell.value == 1 && !cell.visisted) {
            System.out.println("found connected shape at (" + row + "," + col + ")");
            cell.visisted = true;
            foundShape = true;
            lookForCellToBelow(shapeMatrix, row, col);
            lookForCellAbove(shapeMatrix, row, col);
            lookForCellToRight(shapeMatrix, row, col);
            lookForCellToLeft(shapeMatrix, row, col);
        }
        return foundShape;
    }

    private static void lookForCellToLeft(ShapeMatrix shapeMatrix, int row, int col) {
        if (col >= 1) {
            findShapes(shapeMatrix, row, col - 1);
        }
    }

    private static void lookForCellToRight(ShapeMatrix shapeMatrix, int row, int col) {
        if (col < shapeMatrix.getMaxCols() - 1) {
            findShapes(shapeMatrix, row, col + 1);
        }
    }

    private static void lookForCellAbove(ShapeMatrix shapeMatrix, int row, int col) {
        if (row >= 1) {
            findShapes(shapeMatrix, row - 1, col);
        }
    }

    private static void lookForCellToBelow(ShapeMatrix shapeMatrix, int row, int col) {
        if (row < shapeMatrix.getMaxRows() - 1) {
            findShapes(shapeMatrix, row + 1, col);
        }
    }

}
