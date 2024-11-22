package common;

public class ConvertToIntArray {

    // Helper method to convert String array to int array
    public static int[] convertToIntArray(String[] strArray) {
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }
}
