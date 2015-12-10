import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();

		list1.add(5);
		list1.add(10);
		list1.add(25);
		list1.add(35);
		list1.add(50);

		list2.add(3);
		list2.add(13);
		list2.add(23);
		list2.add(35);
		list2.add(56);

		list3.add(1);
		list3.add(11);
		list3.add(21);
		list3.add(31);
		list3.add(41);

		List<Integer> result = mergeArrays(list1, list2, list3);
		for (Integer i : result) {
			System.out.print(i + ",");
		}
		System.out.println();
	}

	private static List<Integer> mergeArrays(List<Integer> list1, List<Integer> list2, List<Integer> list3) {
		Scanner s = new Scanner(System.in);
		s.next();
		List<Integer> mergedArray = new ArrayList<Integer>();
		Integer i = 0, j = 0, k = 0;
		Integer size1 = list1.size(), size2 = list2.size(), size3 = list3.size();

		while (mergedArray.size() != size1 + size2 + size3) {
			if (size1 > i && size2 > j && size3 > k) {
				if (list1.get(i) <= list2.get(j)) {
					if (list1.get(i) <= list3.get(k)) {
						mergedArray.add(list1.get(i));
						i++;
					} else {
						mergedArray.add(list3.get(k));
						k++;
					}
				} else {
					if (list2.get(j) <= list3.get(k)) {
						mergedArray.add(list2.get(j));
						j++;
					} else {
						mergedArray.add(list3.get(k));
						k++;
					}
				}
			}
		}
		return mergedArray;
	}

}
