import java.io.*;
import java.util.*;

class WeatherData{

  private BufferedReader br;

  private int minmumTempSpreadDay(){
    int res=0;
    return res;
  }

  private int tempSpread(){
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
      // ans=minimunTempSpreadDay();
      // expect=14
      // assert ans==14;
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
