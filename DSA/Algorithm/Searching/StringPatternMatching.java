
public class StringPatternMatching {
    public static void main(String[] args) {
        String text = "ababcababcabc";
        String pattern = "abc";

        NaiveSearch obj = new NaiveSearch();
        System.out.println("Pattern found at index: " + obj.search(text, pattern));
    }
}
class NaiveSearch {
    public static int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i; // match found at index i
            }
        }
        return -1; // no match
    }

    public static void main(String[] args) {
        String text = "ababcababcabc";
        String pattern = "abc";
        System.out.println("Pattern found at index: " + search(text, pattern));
    }
}
class KMPSearch {

    public static int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // fallback
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] lps = buildLPS(pattern);

        int i = 0, j = 0;
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++; j++;
            }
            if (j == m) {
                return i - j; // match found
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1; // no match
    }

    public static void main(String[] args) {
        String text = "ababcababcabc";
        String pattern = "abc";
        System.out.println("Pattern found at index: " + search(text, pattern));
    }
}

class RabinKarp {
    static final int d = 256;           // Number of characters in input alphabet
    static final int q = 101;           // A prime number to mod hash value (for less collision)

    public static int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text window
        int h = 1;

        // The value of h would be "pow(d, m-1) % q"
        for (int i = 0; i < m - 1; i++)
            h = (h * d) % q;

        // Calculate hash value for pattern and first window of text
        for (int i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (int i = 0; i <= n - m; i++) {

            // Check hash values
            if (p == t) {
                // Check characters one by one
                int j;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }

                if (j == m)
                    return i; // Pattern found
            }

            // Calculate hash value for next window
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;

                // Make sure it's positive
                if (t < 0)
                    t += q;
            }
        }

        return -1; // No match
    }

    public static void main(String[] args) {
        String text = "ababcababcabc";
        String pattern = "abc";
        System.out.println("Pattern found at index: " + search(text, pattern));
    }
}
