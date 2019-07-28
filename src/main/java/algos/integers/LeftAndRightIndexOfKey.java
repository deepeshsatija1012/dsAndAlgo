package algos.integers;

import java.util.Arrays;

public class LeftAndRightIndexOfKey {
	// inserted in sorted array `nums` via binary search.
    private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public static int[] searchRange1(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }
	
	public static int[] searchRange(int[] nums, int target) {
		int l = 0, h = nums.length;
		int left = indexOf(nums, l, h, target, true);
		if (left==nums.length || nums[left] != target) {
			return new int[] { -1, -1 };
		}

		int right = indexOf(nums, l, h, target, false);
		return new int[] { left, right-1 };
	}

	public static int indexOf(int[] nums, int l, int h, int key, boolean left) {
		while (l < h) {
			int mid = (l + h) / 2;
			if (nums[mid] == key) {
				if (left)
					h = mid;
				else
					l = mid + 1;
				
			}else if (nums[mid] > key) {
				h = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}
	
	public static void main(String[] args) {
		int[] arr = searchRange(new int[] {5,7,7,8,8,10}, 8);
		System.out.println("Actual   : "+Arrays.toString(arr));
		System.out.println("Expected : "+Arrays.toString(new int[] {3,4}));
		
		arr = searchRange(new int[] {6,6,6,6,6,6,6,6,6,6}, 6);
		System.out.println("Actual   : "+Arrays.toString(arr));
		System.out.println("Expected : "+Arrays.toString(new int[] {0,9}));
	}
}
