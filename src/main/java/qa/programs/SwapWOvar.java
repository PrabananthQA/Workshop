package qa.programs;

import java.util.Scanner;

import org.testng.annotations.Test;

public class SwapWOvar {
	@Test
	private void swapno() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter no 1");
		int n1 = sc.nextInt();
		System.out.println("enter no 2");
		int n2 = sc.nextInt();
		if(n1!=n2) {
			n1=n1+n2;
			n2=n1-n2;
			n1=n1-n2;
			System.out.println("n1 is " +n1);
			System.out.println("n2 is " +n2);
		}
		else {
			System.out.println("swap not required");
		}
	}
}
