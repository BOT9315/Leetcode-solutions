class Solution:
    def maximalRectangle(self, matrix):

        if not matrix:
            return 0

        rows = len(matrix)
        cols = len(matrix[0])

        heights = [0] * cols
        max_area = 0

        for i in range(rows):

            # update heights
            for j in range(cols):

                if matrix[i][j] == "1":
                    heights[j] += 1
                else:
                    heights[j] = 0

            # check all rectangles
            for start in range(cols):
                min_height = heights[start]

                for end in range(start, cols):
                    min_height = min(min_height, heights[end])
                    width = end - start + 1
                    area = min_height * width
                    max_area = max(max_area, area)

        return max_area