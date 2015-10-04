class FootBall{


  public void test(){
    try{
      assert 0==-1;
      System.out.println("Warning: run with -ea option to test");
      return;
    }
    catch(AssertionError e){
      System.out.println("test start");
    }

    String expect="Aston_Villa";
    String  ans="";

    System.out.println("print the team with the smallest differential betweeen for and away goals");

    try{
      // do process here

      assert expect==ans;

    }catch(AssertionError e){
      System.out.println("test failed");
    }

  }

  public static void main(String[] args){
    System.out.println("Foot ball class!");
    (new FootBall()).test();
  }
}
