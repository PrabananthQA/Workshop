package qa.programs;

import java.util.Scanner;

import org.testng.annotations.Test;

public class OddOrEven {
	@SuppressWarnings({ "resource" })
	@Test
	private void findeven() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = sc.nextInt();
		if(n%2==0) {
			System.out.println("even");
		}
		else {
			System.out.println("odd");
		}
	}
}
