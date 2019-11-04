import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class InputReceiver {

	public static void main(String[] args) {
		InputReceiver inputReceiver = new InputReceiver();
		inputReceiver.readShape(new int[][] { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 0, 1, 1 }, { 0, 0, 0, 0 } });
	}

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
