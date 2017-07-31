import java.util.*;

public class RansomeNote {
    Map<String, Integer> magazineMap = new HashMap<String, Integer>();
    Map<String, Integer> noteMap = new HashMap<String, Integer>();
    
    public RansomeNote(String magazine, String note) {
        loadMap(magazine, true);
        loadMap(note, false);
    }
    
    public boolean solve() {
        for (Map.Entry entry : noteMap.entrySet()) {
            if (magazineMap.get(entry.getKey()) >= (Integer)entry.getValue())
                continue;
            else
                return false;
        }
        return true;
    }
    
    private void loadMap(String s, boolean magazine) {
        String[] words = s.split(" ");
        Map<String, Integer> map = magazine ? magazineMap : noteMap;
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            if(map.containsKey(words[i])) {
                count = map.get(words[i]);
            }
            map.put(words[i], ++count);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        RansomeNote s = new RansomeNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}

