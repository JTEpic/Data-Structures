import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;

/**
 * Write a description of class Main3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main2
{
    // ui good, ~23 seconds
    public static void main (String[] args) throws FileNotFoundException {
        // Folders
        System.out.println("<This program will search all files in a folder and>");
        System.out.println("<show the files that have been plagarized the most>");
        System.out.println();
        System.out.println("Pick the folder using the corresponding number:");
        int loc=1;
        Scanner scan = new Scanner(System.in);
        File dir = new File("./Catching Plagiarists");
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
        System.out.println("Showing text files:");
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
        System.out.println("Pick number of sequences, 1-20:");
        int numWords=-1;
        while(numWords<1||numWords>20)
        numWords=scan.nextInt();
        System.out.println();
        System.out.println("Pick minimum hit requirement, 0-500:");
        int max=-1;
        while(max<0||max>500)
        max=scan.nextInt();
        System.out.println();
        System.out.println("Setting up...");
        double time=System.currentTimeMillis();
        // Getting sequences
        loc=1;
        ArrayList<Count> a = new ArrayList();
        ArrayList<HashMap> b = new ArrayList();
        ArrayList<HashMap> b2 = new ArrayList();
        List<String> files2 = new ArrayList<String>(files);
        for(int x=0;x<files.size();x++){
            HashMap search = search(directory+"/"+files.get(x),numWords);
            b.add(search);
            b2.add(search);
        }
        // Comparing
        String location = directory+"/";
        for(int x=0;x<files.size();x++){
            String one = location+files.get(x);
            HashMap<String, Integer> one2=b.get(x);
            for(int y=0;y<files2.size();y++){
                String two = location+files2.get(y);
                HashMap<String, Integer> two2 = b2.get(y);
                if(one.equals(two)){
                    files2.remove(y);
                    b2.remove(y);
                    y--;
                } else{
                    a.add(new Count(one,two,counter(one2,two2)));
                }
            }
            System.out.println(loc+"/"+files.size()+" completed");
            loc++;
        }
        
        Collections.sort(a);
        System.out.println();
        for(Count c: a){
            if(c.getNum()>max){
                System.out.println(c.getNum()+" hits "+c.getOne()+" > "+c.getTwo());
            }
        }
        System.out.println((System.currentTimeMillis()-time)/1000);
    }
    
    public static HashMap search(String text,int numWords) throws FileNotFoundException
    {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Integer> table = new HashMap<>();
        
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
            if(!table.containsKey(phrase))
            table.put(phrase,1);
            else
            table.put(phrase,table.get(phrase)+1);
            }
        }
        return table;
    }
    
    // good enough, only interates through smaller hashmap for speed
    // add large values too
    public static int counter(HashMap<String, Integer> one,HashMap<String, Integer> two){
        int num=0;
        HashMap<String, Integer> small = two.size() < one.size() ? two : one;
        HashMap<String, Integer> large = small == one ? two : one;
        for (String key : small.keySet()) {
            if (large.containsKey(key)&&small.get(key).equals(large.get(key)))
            num+=large.get(key);//+; handles duplicates
        }
        return num;
    }
}
