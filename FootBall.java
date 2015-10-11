import java.io.*;
import java.util.*;

class FootBall{

  private BufferedReader br;

  private boolean fileOpen(){
    boolean res=true;
    String fileName="football.dat";
    try{
      File file=new File(fileName);
      br=new BufferedReader(new FileReader(file));
    }
    catch(FileNotFoundException e){
      System.out.println(e);
    }
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

  private boolean getMinimumDiff(){
    fileOpen();
    boolean res=true;
    try{
      String str;
      br.readLine(); // legend line
      while((str=br.readLine()) != null){
        String[] arr;
        arr=str.split(" ");
        System.out.println(Arrays.toString(arr));
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

  public void test(){
    boolean isAssertionEnabled=false;
    assert isAssertionEnabled=true;
    if(!isAssertionEnabled){
      System.out.println("Error: run with -ea option to test");
      return;
    }

    String expect="Aston_Villa";
    String  ans="";

    System.out.println("print the team with the smallest differential betweeen for and away goals");

    try{
      // do process here
      assert fileOpen()==true: "file open failed";
      assert fileClose()==true: "file close failed";
      assert getMinimumDiff()==true;

      assert expect.equals(ans): "expect="+expect+" answer="+ans;

    }catch(AssertionError e){
      System.out.println("test failed");
      e.printStackTrace();
    }

  }

  public static void main(String[] args){
    System.out.println("Foot ball class!");

    (new FootBall()).test();

  }
}
