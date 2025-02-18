package curso1;

import java.util.Scanner;

public class Soma {
	public static void main(String[] args) {
		int num1, num2, resp;
		Scanner input = new Scanner(System.in);
		System.out.println("Digite um número: ");
		num1 = input.nextInt();
		System.out.println("Digite outro número: ");
		num2 = input.nextInt();
		resp = num1 + num2;
		System.out.println("Soma = " + resp);
	}
}
 