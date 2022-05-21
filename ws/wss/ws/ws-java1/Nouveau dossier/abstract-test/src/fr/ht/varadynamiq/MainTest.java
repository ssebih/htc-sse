package fr.ht.varadynamiq;

public class MainTest {

	public static void main(String... args) {
		
		TestMax maxer = new TestMax();
		
		System.out.println(maxer.max(2));
		System.out.println(maxer.max(2, 1));
		System.out.println(maxer.max(2, 1, 6));
		System.out.println(maxer.max(101, 1, 6, 100));
		System.out.println(maxer.max(11, 1, 6, 10, 95));

	}

}
