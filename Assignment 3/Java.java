import java.util.*;

public class Java {
	public static int countTrue(Boolean[] arr) {
		int count = 0;
		for (Boolean i : arr) {
			if (i == true) {
				count++;
			}
		}
		return count;
	}
	
	public static Object[][] toArray(Map<String, Object> map) {
        if (map.isEmpty()) {
            return new Object[0][0];
        }

        Object[][] array = new Object[map.size()][2];
        int index = 0;

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            array[index][0] = entry.getKey();
            array[index][1] = entry.getValue();
            index++;
        }

        return array;
    }

	public static String luckyNumbers(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (String.valueOf(arr[i]).contains("7")) {
				return "LUCKY";
			}
		}
		return "there is no 7 in the array :(";
	}

	public static String oddishOrEvenish(int num) {
		int sum = 0;
		for (int i = 0; i < Integer.toString(num).length(); i++) {
			sum += Integer.parseInt(Integer.toString(num).charAt(i) + "");
		}
		return sum % 2 == 0 ? "Oddish" :"Evenish";
	}

	public static String reverseOdd(String str) {
        String[] arr = str.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() % 2 != 0) {
                arr[i] = new StringBuilder(arr[i]).reverse().toString();
            }
        }
        return String.join(" ", arr);
    }

	public static List<String> getHashTags(String str) {
		String[] arr = str.split(" ");
		Map<String, Integer> map = new HashMap<>();
		List<String> result = new ArrayList<>();
		String longest = "", secondLongest = "", thirdLongest = "";

		for (String word : arr) {
			word = word.replaceAll("[^a-zA-Z]", "");
			map.put(word, word.length());
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String word = entry.getKey();
			int length = entry.getValue();

			if (length > longest.length()) {
				thirdLongest = secondLongest;
				secondLongest = longest;
				longest = word;
			} else if (length > secondLongest.length()) {
				thirdLongest = secondLongest;
				secondLongest = word;
			} else if (length > thirdLongest.length()) {
				thirdLongest = word;
			}
		}

		if (!longest.isEmpty()) result.add(longest);
		if (!secondLongest.isEmpty()) result.add(secondLongest);
		if (!thirdLongest.isEmpty()) result.add(thirdLongest);

		return result;
    }
}