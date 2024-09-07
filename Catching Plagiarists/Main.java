import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Collections;

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    // ui terrible
    public static void main (String[] args) throws FileNotFoundException {
        // Folders
        System.out.println("<This program will search all files in a folder and>");
        System.out.println("<send back the files that have been plagarized the most>");
        System.out.println();
        System.out.println("Pick the folder using the corresponding number:");
        int loc=1;
        Scanner scan = new Scanner(System.in);
        File dir = new File(".");
        ArrayList<File> directories = new ArrayList<File>();
        for(File folder : dir.listFiles())
        if(folder.isDirectory()){
            directories.add(folder);
            System.out.println(loc+" "+folder);
            loc++;
        }
        
        // Files
        System.out.println();
        loc=-1;
        while(loc<0||loc>=directories.size())
        loc=scan.nextInt()-1;
        System.out.println();
        File directory = directories.get(loc);
        String[] temp = directory.list();
        List<String> files = new ArrayList<String>();
        for(int i = 0; i < temp.length; i++){
            if(temp[i].endsWith(".txt")){
                files.add(temp[i]);
                System.out.println(i+1+" "+temp[i]);
            }
        }
        
        // Search
        System.out.println();
        System.out.println("Pick number of sequences, 1-10:");
        int numWords=-1;
        while(numWords<1||numWords>10)
        numWords=scan.nextInt();
        System.out.println();
        System.out.println("Pick minimum hit requirement, 1-50:");
        int max=-1;
        while(max<1||max>50)
        max=scan.nextInt();
        System.out.println();
        long time=System.currentTimeMillis();
        
        loc=1;
        ArrayList<Count> a = new ArrayList();
        ArrayList<ArrayList> b = new ArrayList();
        ArrayList<ArrayList> b2 = new ArrayList();
        List<String> files2 = new ArrayList<String>(files);
        for(int x=0;x<files.size();x++){
            ArrayList search = search(directory+"/"+files.get(x),numWords);
            b.add(search);
            b2.add(search);
        }
        for(int x=0;x<files.size();x++){
            String one = directory+"/"+files.get(x);
            ArrayList one2=b.get(x);
            for(int y=0;y<files2.size();y++){
                String two = directory+"/"+files2.get(y);
                ArrayList two2 = b2.get(y);
                if(one.equals(two)){
                    files2.remove(y);
                    b2.remove(y);
                    y--;
                } else{
                    a.add(new Count(one,two,counter(one2,two2)));
                }
            }
            System.out.println(loc+"/"+files.size());
            loc++;
        }
        Collections.sort(a);
        System.out.println();
        for(Count c: a){
            if(c.getNum()>max){
                System.out.println(c.getNum()+" "+c.getOne()+" > "+c.getTwo());
            }
        }
        System.out.println(System.currentTimeMillis()-time);
    }
    
    public static ArrayList search(String text,int numWords) throws FileNotFoundException
    {
        Scanner scan = new Scanner(System.in);
        ArrayList array = new ArrayList();
        for(int x=0;x<numWords;x++){
            Scanner file = new Scanner(new File(text));
            for(int y=0;y<x;y++){
                file.next();
            }
            while(file.hasNext()){
            String phrase = "";
            // read numWords words
            for(int j = 0; j < numWords; j++){
                if(file.hasNext())
                // remove punctuation and set lowercase
                phrase += file.next().replaceAll("[^A-z]","").toLowerCase();
                else
                phrase = null; // not enough words at end of file
            }
            if(phrase!=null)
            array.add(phrase);
            }
        }
        return array;
    }
    
    public static int counter(ArrayList one,ArrayList two)
    {
        int num=0;
        for(int x=0;x<one.size();x++){
            for(int y=0;y<two.size();y++){
                if(one.get(x).equals(two.get(y)))
                num++;
            }
        }
        return num;
    }
}