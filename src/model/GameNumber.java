package model;


public class GameNumber {
	
	private String val;
	private int value;

	public GameNumber() {
		value = 0;
	}
	
	public GameNumber(String val) {
			this.val = val;
	}
	
	public String getVal() {
		return val;
	}
	
	public GameNumber(int value) {
		if (value < 0) {
			this.value = 0;
		} else {
			this.value = value;
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		if (value < 0) {
			this.value = 0;
		} else {
			this.value = value;
		}
	}


	public void increment() {
		this.value++;
	}

}