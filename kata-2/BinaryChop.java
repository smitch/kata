class BinaryChop{

  private int recursiveChop(int[] array, int s, int t, int n){
    int res=-1;
    if((t-s)==1){
      if(array[s]==n) res=s;
    }
    return res;
  }

  public int chop(int[] array, int n){
    int res=-1;
    res=recursiveChop(array, 0, array.length, n);

    return res;
  }

  public void test(){
    // System.out.println("this is test");
    try {
      assert 0==-1;
      System.out.println("run with -ea option to test");
      return;
    }
    catch(AssertionError e){
    }

    try {
      int[] case1=new int[] {1};
      assert recursiveChop(case1, 0, 1, 1)==0;
      assert chop(case1, 1)==0;
      // assert chop(new int[] {1,2}, 2)==1;
      // assert chop(new int[] {1,2,4}, 1)==0;
      // assert chop(new int[] {1,2,4}, 2)==1;
      // assert chop(new int[] {1,2,4}, 4)==2;
      // assert chop(new int[] {1,2,4}, 0)==-1;
      System.out.println("test succeeded");
    }catch(AssertionError e){
      System.out.println("test failed");
      e.printStackTrace();
    }
  }

  public static void main(String[] args){
    // System.out.println("Binary Chop");
    BinaryChop binary=new BinaryChop();
    binary.test();
  }
}
