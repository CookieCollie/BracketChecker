import java.util.Stack;

public class BracketCheck {
	private Stack<Character> BracketBuffer = new Stack<>();
	private String OpenBrakets = "{[(";
	private String ClosedBrakets = "}])";
	
	
	// Push open brackets inside equation to buffer
	private void PushOpenBrackets(String string) {
		for (Character character : string.toCharArray()) {
			for (Character openBracket : OpenBrakets.toCharArray()) {
				if (character.equals(openBracket))											// Check if character inside equation is an open bracket or not
					BracketBuffer.push(character);
			}
		}
	}
	
	
	// Check the balance of the equation
	public boolean check(String string) {
		boolean isBalanced = true;
		
		PushOpenBrackets(string);
		
		for (Character character : string.toCharArray()) {
			if (!isBalanced) {break;}														// Break outside loop if not balance
			for (Character closedBracket : ClosedBrakets.toCharArray()) {
				if (character.equals(closedBracket)) {										// Check if the character inside equation is a closed bracket or not
					if (!BracketBuffer.isEmpty() && ClosedBrakets.indexOf(character) == 	// Check if buffer is empty and the brackets are the right pairs or not
							OpenBrakets.indexOf(BracketBuffer.pop())) {						// based on index of open and closed brackets
						isBalanced = true;
					}
					else {
						isBalanced = false;
						break;
					}
				}
			}
		}
		
		if (BracketBuffer.isEmpty() == false)												// If after checking the buffer still has item => not balanced
			isBalanced = false;
		
		return isBalanced;
	}
}
