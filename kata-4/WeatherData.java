import java.io.*;
import java.util.*;

class WeatherData{

  private BufferedReader br;
  private int minimumTempSpread=1000000;

  private void upDateTempSpread(int max, int min){
    int spread=max-min;
    if(spread<minimumTempSpread) minimumTempSpread=spread;
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

  private void upDateTempSpread(String[] strArray){
    if(isDigit(strArray[1])){
      int max=Integer.parseInt(strArray[2]);
      int min=Integer.parseInt(strArray[3]);
      int spread=max-min;
      if(spread<minimumTempSpread) minimumTempSpread=spread;
    }
  }

  private int getMinimumTempSpread(){
    return minimumTempSpread;
  }

  private int readMimimumTempSpread(){
    fileOpen();
    try{
      String str;
      br.readLine(); // legend line
      br.readLine(); // blank line
     while((str=br.readLine()) != null){
        // System.out.println(str);
       String[] arr;
       arr=str.replace("*", " ").split(" +");
       // System.out.println(arr[0]);
       // System.out.println(Arrays.toString(arr));
       upDateTempSpread(arr);
      }
    }
    catch(FileNotFoundException e){
      System.out.println(e);
    }
    catch(IOException e){
      System.out.println(e);
    }
    fileClose();
    return getMinimumTempSpread();
  }

  private int minmumTempSpreadDay(){
    int res=0;
    return res;
  }

  private boolean fileOpen(){
    boolean res=true;
    String fileName="weather.dat";
    try{
      File file=new File(fileName);
      br = new BufferedReader(new FileReader(file));
      // String str;
      // while((str=br.readLine()) != null){
      //   System.out.println(str);
      // }
    }
    catch(FileNotFoundException e){
      System.out.println(e);
    }
    // catch(IOException e){
    //   System.out.println(e);
    // }
    return res;
  }

  private boolean fileClose(){
    boolean res=true;
    try{
      br.close();
    }
    catch(IOException e){
      System.out.println(e);
    }
    return res;
  }

  private boolean fileReadAll(){
    boolean res=true;
    try{
      String str;
      while((str=br.readLine()) != null){
        System.out.println(str);
      }
    }
    catch(FileNotFoundException e){
      System.out.println(e);
    }
    catch(IOException e){
      System.out.println(e);
    }
    return res;
  }

  private boolean fileReadLine(){
    boolean res=true;
    try{
      String str;
      br.readLine(); // legend line
      br.readLine(); // blank line
     while((str=br.readLine()) != null){
        // System.out.println(str);
       String[] arr;
       arr=str.split(" +");
       // System.out.println(arr[0]);
       System.out.println(Arrays.toString(arr));
      }
    }
    catch(FileNotFoundException e){
      System.out.println(e);
    }
    catch(IOException e){
      System.out.println(e);
    }
    return res;
  }


  public void test(){
    try{
      assert 0==-1;
      System.out.println("run with -ea option to test");
      return;
    }
    catch(AssertionError e){
      System.out.println("test start");
    }

    int ans=0, expect=0;
    try{
      assert fileOpen()==true;
      // assert fileReadAll()==true;
      assert fileReadLine()==true;
      assert fileClose()==true;
      upDateTempSpread(220, 100);
      assert getMinimumTempSpread()==120;
      assert isDigit("1")==true;
      assert isDigit("hoge")==false;
      upDateTempSpread(new String[] {"", "3", "22", "10"});
      assert getMinimumTempSpread()==12;
      upDateTempSpread(new String[] {"", "hoge", "22", "22"});
      assert getMinimumTempSpread()==12;
      ans=readMimimumTempSpread();
      expect=2;
      assert ans==2;
      System.out.println("test succeeded");
    }catch(AssertionError e){
      System.out.println("test failed");
      System.out.format("expect=%d, ans=%d\n", expect, ans);
    }
  }

  public static void main(String[] args){
    (new WeatherData()).test();
  }
}
