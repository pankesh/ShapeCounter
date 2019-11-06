package com.pankesh.shapecounter;

public class ShapeCounter {
    public static void main(String[] args) {
        InputReceiver inputReceiver = new InputReceiver();
        // @formatter:off
        ShapeMatrix shapeMatrix = inputReceiver.readShape(
        // @formatter:off
        new int[][] {   { 1, 1, 0, 1, 1 },
                        { 1, 1, 0, 1, 1 }, 
                        { 0, 0, 1, 0, 0 }, 
                        { 1, 1, 1, 1, 1 }, 
                        { 1, 1, 0, 1, 1 } });
        // @formatter:on

        countShapes(shapeMatrix);
    }

    public static int countShapes(ShapeMatrix shapeMatrix) {
        int shapesFound = 0;
        // int shapesFound = findShapes(shapeMatrix,0,0);
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
            if (row < shapeMatrix.getMaxRows() - 1) {
                findShapes(shapeMatrix, row + 1, col);
            }
            if (row >= 1) {
                findShapes(shapeMatrix, row - 1, col);
            }
            if (col < shapeMatrix.getMaxCols() - 1) {
                findShapes(shapeMatrix, row, col + 1);
            }
            if (col >= 1) {
                findShapes(shapeMatrix, row, col - 1);
            }
        }
        return foundShape;
    }

}
