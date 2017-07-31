class WordNode{
	String word;
	WordNode next;
}

public class LongestChainWords {

	public static void main(String[] args) {
		
		WordNode head = new WordNode();
		WordNode start = head; // deep copy the linked list here
		//WordNode next = start.next;
		WordNode innerStart = start.next;
		WordNode innerPrev = start;
		int longestChain = 0;
		int currentChainLength = 0;
		WordNode result = null;
		while (start != null){
			char lastChar = start.word.charAt(start.word.length() - 1);
			while(innerStart != null) {
				char firstChar = innerStart.word.charAt(0);
				if (lastChar == firstChar){
					innerPrev.next = innerStart.next;
					WordNode temp = start.next;
					start.next = innerStart;
					innerStart.next = temp;
					currentChainLength++;
					if(currentChainLength > longestChain) {
						longestChain = currentChainLength;
						result = start;
					}
					innerStart = innerStart.next;
					innerPrev = innerPrev.next;
					lastChar = innerPrev.word.charAt(innerPrev.word.length() - 1);
				} else {
					innerStart = innerStart.next;
				}
			}
			start = start.next; // This needs to be the first word of the list or start from first element
		}
		
	}

}
