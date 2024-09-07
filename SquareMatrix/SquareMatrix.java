/**
 * Write a description of class SquareMatrix here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SquareMatrix implements SquareMatrixInterface
{
    private int[][] matrix;
    public SquareMatrix(int n){
        matrix=new int[n][n];
    }
    public SquareMatrix(int[][] n){
        matrix=n;
    }
    public SquareMatrix add(SquareMatrix s){
        int l=s.getSize();
        int[][] add=new int[l][l];
        for(int x=0;x<matrix.length;x++){
            for(int y=0;y<matrix[x].length;y++)
            add[x][y]=matrix[x][y]+s.getValue(x,y);
        }
        return new SquareMatrix(add);
    }
    public SquareMatrix subtract(SquareMatrix s){
        int l=s.getSize();
        int[][] subtract=new int[l][l];
        for(int x=0;x<matrix.length;x++){
            for(int y=0;y<matrix[x].length;y++)
            subtract[x][y]=matrix[x][y]-s.getValue(x,y);
        }
        return new SquareMatrix(subtract);
    }
    public SquareMatrix copy(){
        int l=this.getSize();
        int[][] copy=new int[l][l];
        for(int x=0;x<matrix.length;x++){
            for(int y=0;y<matrix[x].length;y++)
            copy[x][y]=matrix[x][y];
        }
        return new SquareMatrix(copy);
    }
    public int getSize(){
        return matrix.length;
    }
    public void setValue(int row,int column,int value){
        matrix[row][column]=value;
    }
    public int getValue(int row,int column){
        return matrix[row][column];
    }
    public void fillValue(int value){
        for(int x=0;x<matrix.length;x++){
            for(int y=0;y<matrix[x].length;y++)
            matrix[x][y]=value;
        }
    }
    public void makeZero(){
        for(int x=0;x<matrix.length;x++){
            for(int y=0;y<matrix[x].length;y++)
            matrix[x][y]=0;
        }
    }
    public String toString(){
        String s="";
        for(int x=0;x<matrix.length;x++){
            for(int y=0;y<matrix[x].length;y++)
            s+=matrix[x][y];
        }
        return s;
    }
}
