/**
 * Write a description of class Rotate here.
 *
 * @author JTEpic
 * @version (a version number or a date)
 */
public class Rotate
{
    public static int[][] rotateArray(int[][] a){
        int[][] b=a;
        int l=b.length;
        int[] temp=new int[(l*l)];
        int num=0;
        for(int x=0;x<l;x++)
        for(int y=0;y<l;y++){
        temp[num]=b[x][y];
        num++;
        }
        num=0;
        for(int t=l-1;t>=0;t--){
            for(int p=0;p<l;p++){
                b[p][t]=temp[num];
                num++;
            }
        }
        return b;
}
}
