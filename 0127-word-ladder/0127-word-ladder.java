import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // endWord must be present
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> set = new HashSet<>(wordList);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int count = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();

                if (word.equals(endWord)) {
                    return count;
                }

                char[] chars = word.toCharArray();

                // Change one character
                for (int j = 0; j < chars.length; j++) {

                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {

                        chars[j] = c;

                        String newWord = new String(chars);

                        if (set.contains(newWord)) {
                            queue.add(newWord);
                            set.remove(newWord);
                        }
                    }

                    chars[j] = original;
                }
            }

            count++;
        }

        return 0;
    }
}