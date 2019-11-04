package com.pankesh.shapecounter;

public class ShapeCounter {
	public static void main(String[] args) {
		InputReceiver inputReceiver = new InputReceiver();
		inputReceiver.readShape(new int[][] { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 0, 1, 1 }, { 0, 0, 0, 0 } });
	}

}
