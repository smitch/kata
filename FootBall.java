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

  private boolean isDigit(String str){
    try{
      Integer.parseInt(str);
      return true;
    }
    catch(NumberFormatException e){
      return false;
    }
  }

  private String getMinimumDiffTeam(){
    fileOpen();
    String res="";
    int min=Integer.MAX_VALUE;
    try{
      String str;
      br.readLine(); // legend line
      while((str=br.readLine()) != null){
        String[] arr;
        // arr=str.split("\\.");
        arr=str.split("\\.? +");
        System.out.println(Arrays.toString(arr));
        // index 1: team number, 2: team name, 7: for goals 9: against goals
        if(isDigit(arr[1])){
          int tmp=Math.abs(Integer.parseInt(arr[7])-Integer.parseInt(arr[9]));
          if(min>tmp){
            min=tmp;
            res=arr[2];
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
    assert min==1;
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
      ans=getMinimumDiffTeam();

      assert expect.equals(ans): "expect="+expect+" answer="+ans;
      if(ans.equals(expect)) System.out.println("ans="+ans+" test succeed");

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
