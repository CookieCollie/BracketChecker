public class Main {
	public static void main(String[] args) {
		String equation = "4+3-(5+6-(6-7)*(5-6))";		// Change the equation here
		BracketCheck balanceChecker = new BracketCheck();
		
		System.out.print("Equation: " + equation + "\n");
		
		if (balanceChecker.check(equation))
			System.out.println("Balanced");
		else
			System.out.println("Not balanced yet");
	}
}
