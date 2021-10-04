package DSA_TimeSpace_Complexity;

public class divide_and_conquer_min_max_in_array {
        public static void main(String[] args) {
            int[] array = {4, 2, 0, 8, 20, 9, 2, -11, 100};
            int[] result = min_max_element(array, 0, array.length - 1);

            for (int value : result) {
                System.out.println(value);
            }
        }

        public static int[] min_max_element(int[] array, int low, int high) {
            int max, min;
            int mid = (low + high) / 2;

            //Base Case--only one element
            if (low == high) {
                max = min = array[low];
            }

            //recursive part
            else {
                int[] left_array = min_max_element(array, low, mid);
                int[] right_array = min_max_element(array, mid + 1, high);

                max = Math.max(left_array[0], right_array[0]);

                min = Math.min(left_array[1], right_array[1]);
            }

            return new int[]{max, min};
        }
}
