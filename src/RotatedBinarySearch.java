
public class RotatedBinarySearch {
	public int search(int[] nums, int target) {
		return binarySearch(nums, target, 0, nums.length - 1);
	}

	private int binarySearch(int[] nums, int target, int start, int end) {
		//System.out.println(start + " - " + " - " + end);
		if (end < start)
			return -1;
		else if (end == start)
			if (nums[end] == target)
				return end;
			else
				return -1;

		int mid = (end + start) / 2;
		//System.out.println(start + " - " + mid + " - " + end);
		if (nums[mid] == target)
			return mid;

		if (nums[start] < nums[mid]) {
			if (target <= nums[mid] && target >= nums[start])
				return binarySearch(nums, target, start, mid);
			else
				return binarySearch(nums, target, mid + 1, end);
		} else {
			if (target >= nums[mid + 1] && target <= nums[end])
				return binarySearch(nums, target, mid + 1, end);
			else
				return binarySearch(nums, target, start, mid);
		}
	}
	
	public static void main(String args[]) {
		RotatedBinarySearch b = new RotatedBinarySearch();
		System.out.println(b.search(new int[]{3,5,1}, 1));
	}
}
