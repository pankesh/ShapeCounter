package com.pankesh.shapecounter;
import java.util.Arrays;
import java.util.stream.IntStream;

public class InputReceiver {

	public void readShape(int[][] inputShape) {
		Arrays.stream(inputShape)
			.forEach(row -> IntStream
							.range(0, row.length).forEach(col -> System.out.println(row[col])));
	}

	// private class ShapeCell {
	// private String address;
	// private boolean visisted;
	// private int
	// }
}
