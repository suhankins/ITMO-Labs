public class Lab0 {
	/**
	Checks if number int num is in {8, 10, 18, 20}
	*/
	public static boolean task3Check2(int num){
		int[] supportVar = new int[] {8, 10, 18, 20};
		for (int i = 0; i < supportVar.length; i++){
			if (supportVar[i] == num) return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		//Task 1
		int[] a = new int[8];
		for (int i = 0; i < a.length; i++){
			//6,8,10,12,14,16,18,20
			a[i] = 6 + i * 2;
			//System.out.printf("[%d] = %d%n", i, a[i]);
		}
		//Task 2
		double[] x = new double[14];
		for (int i = 0; i < x.length; i++){
			x[i] = Math.random() * 7.0 - 2.0;
			//System.out.printf("[%d] = %f%n", i, (float)x[i]);
		}
		//Task 3
		double[][] a1 = new double[8][14];
		for (int i = 0; i < a1.length; i++){
			for (int j = 0; j < a1[i].length; j++){
				double fancyx = x[j];
				if (a[i] == 6) {
					//I divided everything into separate variables
					//because otherwise code would be even more unreadable
					double leftSide = Math.cos(Math.pow(Math.E, fancyx)) / 2;
					double rightRightSide = 1 - Math.pow(1/3 * (1/3 - fancyx), fancyx);
					double rightSide = Math.pow(Math.cos(fancyx) / rightRightSide, 2);
					//if leftSide < 0 and rightSide has numbers after a dot,
					//result will be NaN.
					a1[i][j] = Math.pow(leftSide, rightSide);
				} else if (task3Check2(a[i])){
					double leftSide = Math.sin(Math.pow(Math.E, fancyx)) - 1;
					double rightSide = Math.cos(Math.pow(fancyx, fancyx / Math.PI));
					a1[i][j] = leftSide / rightSide;
				} else {
					double leftSide = Math.pow(Math.pow(fancyx, 0.25 / (fancyx + Math.PI)), Math.atan((fancyx + 1.5) / 7) / 2);
					double rightSide = Math.sin(Math.log(Math.abs(fancyx))) * (Math.sin(Math.asin(Math.pow((fancyx + 1.5) / 7, 2))) - 1);
					a1[i][j] = Math.pow(leftSide, rightSide);
				}
				
				System.out.printf("%6.2f", a1[i][j]);
			}
			System.out.printf("%n");
		}
	}
}