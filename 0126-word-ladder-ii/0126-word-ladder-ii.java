import java.util.*;

class Solution {
    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {

        List<List<String>> result = new ArrayList<>();

        Set<String> words = new HashSet<>(wordList);

        // If endWord is not present, no answer is possible
        if (!words.contains(endWord)) {
            return result;
        }

        // parent[word] = all previous words that can reach word
        // on a shortest path
        Map<String, List<String>> parent = new HashMap<>();

        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);

        boolean found = false;

        while (!currentLevel.isEmpty() && !found) {

            // Remove current level words so that we don't visit them again
            words.removeAll(currentLevel);

            Set<String> nextLevel = new HashSet<>();

            for (String word : currentLevel) {

                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {

                    char original = chars[i];

                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == original) {
                            continue;
                        }

                        chars[i] = c;
                        String nextWord = new String(chars);

                        if (words.contains(nextWord)) {

                            nextLevel.add(nextWord);

                            parent.putIfAbsent(
                                nextWord,
                                new ArrayList<>()
                            );

                            parent.get(nextWord).add(word);

                            if (nextWord.equals(endWord)) {
                                found = true;
                            }
                        }
                    }

                    chars[i] = original;
                }
            }

            currentLevel = nextLevel;
        }

        // No shortest path found
        if (!found) {
            return result;
        }

        // Build paths from endWord back to beginWord
        List<String> path = new ArrayList<>();
        path.add(endWord);

        backtrack(endWord, beginWord, parent, path, result);

        return result;
    }

    private void backtrack(
            String word,
            String beginWord,
            Map<String, List<String>> parent,
            List<String> path,
            List<List<String>> result) {

        if (word.equals(beginWord)) {

            List<String> completePath = new ArrayList<>(path);

            Collections.reverse(completePath);

            result.add(completePath);

            return;
        }

        if (!parent.containsKey(word)) {
            return;
        }

        for (String previous : parent.get(word)) {

            path.add(previous);

            backtrack(
                previous,
                beginWord,
                parent,
                path,
                result
            );

            path.remove(path.size() - 1);
        }
    }
}