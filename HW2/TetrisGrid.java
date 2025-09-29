public class TetrisGrid {
    private boolean[][] grid;
    private int rows;
    private int cols;

    public TetrisGrid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new boolean[rows][cols];
    }

    public TetrisGrid(boolean[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.grid = new boolean[rows][cols];

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                this.grid[r][c] = grid[r][c];
            }
        }
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public void clearRows() {
        int rowDel = 0;

        for(int r = 0; r < rows; r++) {
            boolean full = true;

            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == false) {
                    full = false;
                    break;
                }
            }

            if(full == false) {
                for(int c = 0; c < cols; c++) {
                    grid[r-rowDel][c] = grid[r][c];
                }
            }
            else {
                rowDel++;
            }
        }

        for(int r = rows - rowDel; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                grid[r][c] = false;
            }
        }
    }

    public static void main(String[] args) {
        TetrisGrid tg = new TetrisGrid(new boolean[][] {
                {false, false, false, false, false},
                {true,  true,  true,  true,  true },
                {false, true,  true,  false, false},
                {true,  true,  true,  true,  true },
                {false, false, false, false, false}
        });

        tg.clearRows();     

        boolean[][] g = tg.getGrid();
        for (int r = 0; r < g.length; r++) {
            for (int c = 0; c < g[0].length; c++) {
                System.out.print(g[r][c] ? "1" : "0");
            }
            System.out.println();
        }
    }

}
