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
      assert fileOpen()==true;
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
