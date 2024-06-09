public class Java {
	public static void main(String[] args) {
		Boolean[] arr = { true, false, true, true, false };
		System.out.println(countTrue(arr));
	}
	public static int countTrue(Boolean[] arr) {
		int count = 0;
		for (Boolean i : arr) {
			if (i == true) {
				count++;
			}
		}
		return count;
	}
}