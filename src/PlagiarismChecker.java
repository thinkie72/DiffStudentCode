/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author Tyler Hinkie
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */
    public static int longestSharedSubstring(String doc1, String doc2) {
        // Create array to save data and perform tabulation (including padding)
        int[][] tabulation = new int[doc1.length() + 1][doc2.length() + 1];

        for (int i = 1; i < tabulation.length; i++) {
            for (int j = 1; j < tabulation[0].length; j++) {
                // If the letters match, add the top left diagonal square + 1
                if (doc1.charAt(i - 1) == doc2.charAt(j - 1)) tabulation[i][j] = tabulation[i - 1][j - 1] + 1;
                // If not, take the max of the two neighbors
                else tabulation[i][j] = Math.max(tabulation[i - 1][j], tabulation[i][j - 1]);
            }
        }

        // Return the bottom right square
        return tabulation[tabulation.length - 1][tabulation[0].length - 1];
    }
}
