public class Question302{
    public int minArea(char[][] image, int row, int col) {
        int rows = image.length;
        int cols = image[0].length;

        int left = bs(image, 0, col + 1, false, row, col, true);
        int right = bs(image, col, cols, false, row, col, false);
        int top = bs(image, 0, row + 1, true, row, col, true);
        int bottom = bs(image, row, rows, true, row, col, false);

        return (bottom - top) * (right - left);
    }

    private int bs(char[][] image, int begin, int end, boolean hori, int row, int col,
            boolean goLower) {
        while (begin < end) {
            int mid = (end - begin) / 2 + begin;
            boolean tag = false;
            int limit = hori ? image[0].length : image.length;
            for (int i = 0; i < limit; i++) {
                if (hori && image[mid][i] == '1') tag = true;
                else if (!hori && image[i][mid] == '1') tag = true;
            }
            if (goLower == tag) end = mid;
            else begin = mid + 1;
        }
        return begin;
    }
}
