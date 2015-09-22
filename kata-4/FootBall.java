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
  }

  public static void main(String[] args){
    System.out.println("Foot ball class!");
    (new FootBall()).test();
  }
}
