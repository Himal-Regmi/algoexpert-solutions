package string.easy;

public class RunLengthEncoding {
    //SC - O(N) and TC - O(N)
    public String runLengthEncoding(String string) {
        StringBuilder s = new StringBuilder();
        int counter = 0;
        char latestChar = string.charAt(0);

        for (int i = 0; i < string.length(); i++) {
            if (latestChar != string.charAt(i) || counter == 9) {
                s.append(counter);
                s.append(latestChar);
                latestChar = string.charAt(i);
                counter = 1;
            } else {
                counter += 1;
            }
        }
        s.append(counter);
        s.append(latestChar);

        return s.toString();
    }
}
