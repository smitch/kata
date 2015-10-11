import java.util.*;

class FootBall{

  private boolean fileOpen(){
    return false;
  }

  private boolean isAssertionEnabled(String[] args){
    for(String str:args){
      if(str.equals("-ea")) return true;
    }
    return false;
  }

  public void test(String[] args){
    if(!isAssertionEnabled(args)){
      System.out.println("Error: run with -ea option to test");
      return;
    }

    // try{
    //   assert 0==-1;
    //   System.out.println("Warning: run with -ea option to test");
    //   return;
    // }
    // catch(AssertionError e){
    //   System.out.println("test start");
    // }

    String expect="Aston_Villa";
    String  ans="";

    System.out.println("print the team with the smallest differential betweeen for and away goals");

    try{
      // do process here
      assert fileOpen()==true;
      assert expect==ans;

    }catch(AssertionError e){
      System.out.println("test failed");
    }

  }

  public static void main(String[] args){
    System.out.println("Foot ball class!");

    (new FootBall()).test(args);

  }
}
