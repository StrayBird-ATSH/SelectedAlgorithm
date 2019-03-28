package MorganStanley;

public class StringMatching {
    /**
     * Finds the first character that only appears once in the String.
     *
     * @param string The query string
     * @return The earliest appearing character with only once appearance.
     */
    private static char earliestCharacter(String string) {
        int[] count = new int[26];
        int[] index = new int[26];
        for (int i = 0; i < string.length(); i++) {
            int offset = string.charAt(i) - 'a';
            count[offset]++;
            if (index[offset] == 0) index[offset] = i;
        }
        int pos = string.length();
        for (int i = 0; i < 26; i++) if (count[i] == 1 && index[i] < pos) pos = index[i];
        if (pos < string.length()) return string.charAt(pos);
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(earliestCharacter("iamsuperdemonandastudent"));
    }
}
