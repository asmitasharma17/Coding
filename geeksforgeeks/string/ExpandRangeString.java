package geeksforgeeks.string;

//https://www.geeksforgeeks.org/java-program-expand-string-range-given/
public class ExpandRangeString {

    public static void main(String[] args) {
        // System.out.println(getExpandRangeString("1-5, 8, 11-14, 18, 20, 26-29"));
        System.out.println(getExpandString("1-5, 8, 11-14, 18, 20, 26-29"));
       expand("1-5, 8, 11-14, 18, 20, 26-29");
    }

    public static void expand(String s)
    {
        String p = s;
        String[] arr = p.split("\\-");
        String k = "";
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                String[] arr1 = arr[i].split(", ");
                String[] arr2 = arr[i + 1].split(", ");
                int a = Integer.parseInt(arr1[arr1.length - 1]);
                int b = Integer.parseInt(arr2[0]);
                for (int j = a + 1; j < b; j++) {
                    arr[i] = arr[i] + ", " + j;
                }
            }
            if (k != "")
                k = k + ", " + arr[i];
            else
                k = k + arr[i];
        }

        System.out.println(k);
    }

    private static String getExpandString(String stringToExpand) {
        String[] words = stringToExpand.split("-");
        String result = "", k = "";
        for (int i = 0; i < words.length - 1; i++) {
            result += words[i].substring(0, words[i].length()) + ",";
            String[] lastIntArr = words[i].split(",");
            int lastCharof1stString = Integer.valueOf(lastIntArr[lastIntArr.length - 1].trim());

            String[] fistIntArr = words[i+1].split(",");
            int firstCharOfNextString = Integer.valueOf(fistIntArr[0].trim());

            while (firstCharOfNextString >= lastCharof1stString) {
                result += lastCharof1stString + "," ;
                lastCharof1stString += 1;
            }
        }

        if (k != "")
            k = k + ", " + result;
        else
            k = k + result;

        return k.substring(0, k.length() - 1);
    }

    private static String getExpandRangeString(String stringToExpand) {

        String result = "";

        for (int z = 0; z < stringToExpand.length(); z++) {
            String[] word = new String(String.valueOf(stringToExpand.charAt(z))).split("-");
            if (word.length > 0) {
                for (int i = 0; i < word.length; i += 2) {

                    int j = Character.getNumericValue(word[i].charAt(i));
                    int k = Character.getNumericValue(word[i + 1].charAt(i));

                    while (j != k) {
                        result += j + " , ";
                        j++;
                    }

                    result += k + " , ";
                }
            }
            result += stringToExpand.charAt(z) + " , ";
        }
        return result.substring(0, result.length() - 1);
    }
}
