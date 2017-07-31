import java.util.HashMap;
import java.util.Scanner;

public class TrieContact {

    public static void main(String[] args) {
        Trie t = new Trie();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equals("add"))
                t.addName(contact);
            else
                System.out.println(t.findPartial(contact));
        }
    }
}

class Trie {
    TrieNode root = new TrieNode();

    public void addName(String contact) {
        TrieNode nextChildren = root;
        for (int i = 0; i < contact.length(); i++) {
            //System.out.println(contact.charAt(i));
            nextChildren.addChild(contact.charAt(i));
            nextChildren = nextChildren.children.get(contact.charAt(i));
        }
    }

    public int findPartial(String contact) {
        TrieNode nextChildren = root;
        for (int i = 0; i < contact.length(); i++) {
            nextChildren = nextChildren.children.get(contact.charAt(i));
            if (nextChildren == null)
                return 0;
        }
        return nextChildren.numberOfWords;
    }
}

class TrieNode {
    public HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    public int numberOfWords = 0;
    
    public void addChild(Character c) {
        //System.out.println("in add child: " + c);
        TrieNode n;
        if (!children.containsKey(c)) {
        	n = new TrieNode();
            children.put(c, n);
            //System.out.println("adding child: " + c);
        } else {
        	n = children.get(c);
        }
        n.numberOfWords++;
        //System.out.println("number of words: " + numberOfWords);
    }
}