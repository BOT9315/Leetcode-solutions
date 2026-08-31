class Solution:
    def findSubstring(self, s, words):
        if not s or not words:
            return []

        word_len = len(words[0])
        word_count = {}
        for w in words:
            word_count[w] = word_count.get(w, 0) + 1

        n = len(s)
        total_words = len(words)
        total_len = word_len * total_words
        result = []

        # Try all starting offsets
        for i in range(word_len):
            left = i
            count = 0
            window = {}

            for right in range(i, n - word_len + 1, word_len):
                word = s[right:right + word_len]

                if word in word_count:
                    window[word] = window.get(word, 0) + 1
                    count += 1

                    # Shrink window if word count exceeds
                    while window[word] > word_count[word]:
                        left_word = s[left:left + word_len]
                        window[left_word] -= 1
                        left += word_len
                        count -= 1

                    # Valid concatenation found
                    if count == total_words:
                        result.append(left)

                else:
                    window.clear()
                    count = 0
                    left = right + word_len

        return result
