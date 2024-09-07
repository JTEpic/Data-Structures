import java.util.Scanner;
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class main
{
    public static void main(String args[]){   
        String data,pass;
        Scanner scan=new Scanner(System.in);
        
        System.out.println("Item");
        data=scan.nextLine();
        System.out.println("Password");
        pass=scan.nextLine();
        
        double eData = wordToNumber(data);
        System.out.println("Number value of \"" + data + "\": " + eData);
        double ePass = wordToNumber(pass);
        System.out.println("Number value of \"" + pass + "\": " + ePass);
        
        System.out.println("Variations");
        int num=scan.nextInt();
        
        for(int x=0;x<num;x++){
            eData=encrypt(eData,ePass);
        }
        System.out.println("Encrypted : " + eData);
        for(int x=0;x<num;x++){
            eData=decrypt(eData,ePass);
        }
        System.out.println("Decrypted : " + eData);
        
        String dData=numberToWord(eData);
        System.out.println("Orgin : " + dData + " : " + pass);
    }
    
    public static double encrypt(double data,double pass){
        return data*pass;
    }
    
    public static double decrypt(double data,double pass){
        return data/pass;
    }
    
    public static double wordToNumber(String word) {
        word = word.toLowerCase();
        String sum = "";
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            /*if (Character.isLetter(letter)) {
            int value = letter - 'a' + 1; // Assuming lowercase English letters
            sum += value;
            } else*/
            sum += (int) letter;
            sum += "128";
        }
        return Double.valueOf(sum);
    }
    
    public static String numberToWord(double number) {
        String word = "",num = Double.toString(number),temp="";
        char word1;
        //char temp1='';
        for (int x=0;x<num.length();x++) {
            if(num.charAt(x)=='.'){
            }else if(num.charAt(x)=='E'){
                if(temp.contains("128")){
                temp=temp.substring(0,temp.length()-3);
                }
                word+=(char)((int)Integer.valueOf(temp));
                break;
            }else if(temp.contains("128")){
            //word+=(char)temp+" ";
            temp=temp.substring(0,temp.length()-3);
            word+=(char)((int)Integer.valueOf(temp));
            temp="";
            }else{
            temp+=num.charAt(x);
            }
            // Printing the characters at each position
            System.out.println(word);
            System.out.println(temp);
        }
        
        System.out.println(word);
        return word;
    }
}
