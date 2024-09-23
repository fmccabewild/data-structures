import java.util.Stack;
public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    int count = 1;

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        Stack<Pair> floodfill = new Stack<>();
        floodfill.push(new Pair(row, column));

        while(!floodfill.isEmpty())
        {
            Pair current = floodfill.pop();
            int cR = current.getRow();
            int cC = current.getColumn();
            if(within(current)& pixels[cR][cC] == 0)
            {
                pixels[cR][cC] = count;
                count++;
                floodfill.add(new Pair(cR-1, cC));
                floodfill.add(new Pair(cR, cC));
                floodfill.add(new Pair(cR-1, cC));
                floodfill.add(new Pair(cR-1, cC));
            }
        }
    }

    public boolean within(Pair current)
    {
        return(current.getRow() >= 0 & current.getColumn() >= 0 & current.getRow() < 10 & current.getColumn() < 10);
    }

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
