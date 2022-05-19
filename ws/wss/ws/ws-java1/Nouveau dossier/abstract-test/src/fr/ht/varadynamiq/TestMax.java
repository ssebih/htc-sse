package fr.ht.varadynamiq;

public class TestMax {

	public int max(int... values) {
		int max = 0;

		for (int value : values) {
			if (value > max) {
				max = value;
			}
		}
		return max;

	}

}
