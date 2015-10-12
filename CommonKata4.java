import java.io.*;
import java.util.*;

class CommonKata4{

  private BufferedReader br;

  public boolean fileOpen(String fileName){
    boolean res=true;
    // String fileName="weather.dat";
    try{
      File file=new File(fileName);
      br=new BufferedReader(new FileReader(file));
    }
    catch(FileNotFoundException e){
      System.out.println(e);
    }
    return res;
  }

  public boolean fileClose(){
    boolean res=true;
    try{
      br.close();
    }
    catch(IOException e){
      System.out.println(e);
    }
    return res;
  }

  private boolean isDigit(String str){
    try{
      Integer.parseInt(str);
      return true;
    }
    catch(NumberFormatException e){
      return false;
    }
  }

  public String getMinimumValue(int indexNum, int indexName, int indexValueA, int indexValueB, int skipLinesNum, String fileName){
    String res="";
    int min=Integer.MAX_VALUE;
    fileOpen(fileName);

    try{
      String str;
      for(int i=0; i<skipLinesNum; i++) br.readLine(); // item name line

      while((str=br.readLine()) != null){
        String[] arr;
        arr=str.replace("*", " ").split("\\.? +");
        // System.out.println(Arrays.toString(arr));
        if(isDigit(arr[indexNum])){
          int tmp=Math.abs(Integer.parseInt(arr[indexValueA])-Integer.parseInt(arr[indexValueB]));
          if(min>tmp){
            min=tmp;
            res=arr[indexName];
          }
        }
      }
    }
    catch(FileNotFoundException e){
      System.out.println(e);
    }
    catch(IOException e){
      System.out.println(e);
    }

    fileClose();
    return res;
  }

  public static void main(String[] args){

    CommonKata4 test=new CommonKata4();
    System.out.println("minimum temperature spread day is "+test.getMinimumValue(1, 1, 2, 3, 2, "weather.dat"));

    System.out.println("team with minimum goals between for and against is "+test.getMinimumValue(1, 2, 7, 9, 1, "football.dat"));
    return;
  }

}
