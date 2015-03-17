import java.io.*;

class WeatherData{

  private int minmumTempSpreadDay(){
    int res=0;
    return res;
  }

  private int tempSpread(){
    int res=0;
    return res;
  }

  private boolean fileOpen(){
    boolean res=false;
    String fileName="weather.dat";
    try{
      File file=new File(fileName);
      BufferedReader br = new BufferedReader(new FileReader(file));
      String str;
      while((str=br.readLine()) != null){
        System.out.println(str);
      }
      br.close();
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
      // ans=minimunTempSpreadDay();
      // expect=14
      // assert ans==14;
    }catch(AssertionError e){
      System.out.println("test failed");
      System.out.format("expect=%d, ans=%d\n", expect, ans);
    }
  }

  public static void main(String[] args){
    (new WeatherData()).test();
  }
}
