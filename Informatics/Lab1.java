import java.util.Scanner;

public class Lab1 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the code");
		/*
		Test codes with no errors: https://en.wikipedia.org/wiki/Hamming(7,4)#All_codewords
		*/
		char[] code = scanner.nextLine().toCharArray();
		/*
		C - Parity bit
		I - Information bit

		C C I C I I I
		0 0 0 0 0 0 0

		   0 1 2 3 4 5 6
		C1 X   X   X   X
		C2   X X     X X
		C3       X X X X
		*/
		int errorBit = 0;
		char[] parityBits = new char[3];
		for (int i = 0; i < parityBits.length; i++){
			parityBits[i] = '0';
			int n = (int)Math.pow(2, i);
			//This cycle goes through every starting index of sets of bits this parity bit overlaps
			for (int j = n - 1; j < code.length; j += n * 2){
				//This cycle goes through every bit in a set of bits this parity bit overlaps
				for (int k = j; k < j + n; k++){
					if (k != n - 1) {
						parityBits[i] = parityBits[i] != code[k] ? '1' : '0';
					}
				}
			}
			if (code[n - 1] != parityBits[i]) {
				errorBit += n;
			}
		}
		if (errorBit != 0) {
			System.out.printf("%nThere was an error in bit %d%n", errorBit);
			code[errorBit - 1] = code[errorBit - 1] == '0' ? '1' : '0';
		}
		System.out.printf("The code is: %c%c%c%c", code[2], code[4], code[5], code[6]);
	}
}