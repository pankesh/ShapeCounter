package com.pankesh.shapecounter;

import java.util.Arrays;
import java.util.stream.IntStream;

public class InputReceiver {

    private int rowCounter = 0;

    public ShapeMatrix readShape(int[][] inputShape) {
        System.out.println("Input has Rows [" + inputShape.length + "] Cols [" + inputShape[0].length + "]");

        ShapeMatrix shapeMatrix = new ShapeMatrix(inputShape.length, inputShape[0].length);

        // @formatter:off
        Arrays.stream(inputShape)
            .forEach(row -> {
                               IntStream
                                    .range(0, row.length)
                                    .forEach(col -> {
                                        if (row[col] == 1) {
                                            shapeMatrix.setCell(rowCounter, col, new ShapeCell());
                                        }
                                    });
                                rowCounter++;
                            }
            );
        // @formatter:on

        return shapeMatrix;
    }

}
