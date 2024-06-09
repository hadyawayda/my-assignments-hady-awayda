import java.util.*;

public class Java {
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        System.out.println(Arrays.deepToString(toArray(map)));
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

	
}