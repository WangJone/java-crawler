package algorithm;

public class Triangle{
        /**
     * Pascal's Triangle
     * 杨辉三角
     * @param n
     */
    public static void Yang(int n)
    {
        int[][] yang= new int[n][n];
        for(int x= 0;x<n;x++)
        {
            for(int y =0;y<=x;y++)
            {
                if(y==0 || y==x)
                {
                    yang[x][y]=1;
                }
                else{
                    yang[x][y]=yang[x-1][y-1]+yang[x-1][y];
                }
                System.out.print(yang[x][y]+"\t");
            }
            System.out.println();
        }
    }
}
