public class CharGrid {
    public static int charArea(char[][] grid, char ch) {
        int rows = grid.length;
        int cols = grid[0].length;

        int minRow = rows, maxRow = -1;
        int minCol = cols, maxCol = -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ch) {
                    if (i < minRow) minRow = i;
                    if (i > maxRow) maxRow = i;
                    if (j < minCol) minCol = j;
                    if (j > maxCol) maxCol = j;
                }
            }
        }

        if (maxRow == -1) return 0;

        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }

    public static int countPlus(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isPlus(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isPlus(char[][] grid, int r, int c) {
        char ch = grid[r][c];
        if (ch == ' ') return false; 

        int up = countDirection(grid, r, c, -1, 0, ch);
        int down = countDirection(grid, r, c, 1, 0, ch);
        int left = countDirection(grid, r, c, 0, -1, ch);
        int right = countDirection(grid, r, c, 0, 1, ch);

        int arm = Math.min(Math.min(up, down), Math.min(left, right));

        return arm >= 2; 
    }

    private static int countDirection(char[][] grid, int r, int c, int dr, int dc, char ch) {
        int rows = grid.length;
        int cols = grid[0].length;
        int len = 0;
        int i = r, j = c;

        while (i >= 0 && i < rows && j >= 0 && j < cols && grid[i][j] == ch) {
            len++;
            i += dr;
            j += dc;
        }
        return len;
    }


    public static void main(String[] args) {
        System.out.println(charArea(new char[][] {
                {'a', 'b', 'c', 'd'},
                {'e', 'a', 'f', 'g'},
                {'h', 'i', 'a', 'j'}
        }, 'a')); // Output: 9

        char[][] grid = {
            {' ', ' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', 'p', ' ', ' ', 'x', ' ', ' ', ' '},
            {'p', 'p', 'p', 'p', 'p', ' ', 'x', 'x', 'x'},
            {' ', ' ', 'p', ' ', ' ', 'y', ' ', 'x', ' '},
            {' ', ' ', 'p', ' ', 'y', 'y', 'y', ' ', ' '},
            {'z','z','z','z','z','y','z','z','z'},
            {' ', ' ', 'x', 'x', ' ', 'y', ' ', ' ', ' '},
        };

        System.out.println(countPlus(grid)); 

    }
}

