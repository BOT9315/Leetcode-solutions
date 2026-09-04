class Solution(object):
    def fullJustify(self, words, maxWidth):
        res = []
        i = 0
        n = len(words)

        while i < n:
            # Step 1: find words for current line
            line_len = len(words[i])
            j = i + 1

            while j < n and line_len + 1 + len(words[j]) <= maxWidth:
                line_len += 1 + len(words[j])
                j += 1

            line_words = words[i:j]
            num_words = len(line_words)

            # Step 2: build line
            if j == n or num_words == 1:
                # Last line OR single word → left justify
                line = " ".join(line_words)
                line += " " * (maxWidth - len(line))
            else:
                total_chars = sum(len(word) for word in line_words)
                spaces = maxWidth - total_chars
                slots = num_words - 1

                space_per_slot = spaces // slots
                extra = spaces % slots

                line = ""
                for k in range(slots):
                    line += line_words[k]
                    line += " " * (space_per_slot + (1 if k < extra else 0))
                line += line_words[-1]

            res.append(line)
            i = j

        return res