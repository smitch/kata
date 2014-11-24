class BinaryChop{

  enum ChopType {RECURSIVE, ITERATIVE, FUNCTIONAL, STD_FUNC, TREE};

  private int iterativeChop(int[] array, int s, int t, int n){
    int res=-1;
    int low=s, high=t;
    while(low+1<high){
      int mid=(low+high)/2;
      if(array[mid]>n) high=mid;
      else low=mid;
    }
    if(array[low]==n) res=low;
    return res;
  }
  
  private int recursiveChop(int[] array, int s, int t, int n){
    int res=-1;
    if((t-s)==1){
      if(array[s]==n) res=s;
    }
    else{
      int mid=(t+s)/2;
      if(array[mid]>n) res=recursiveChop(array, s, mid, n);
      else res=recursiveChop(array, mid, t, n);
    }
    return res;
  }

  public int chop(int[] array, int n, ChopType T){
  // public int chop(int[] array, int n){
    int res=-1;
    int length=array.length;
    if(length==0) return res;
    switch(T){
    case RECURSIVE: res=recursiveChop(array, 0, array.length, n);
    case ITERATIVE: res=iterativeChop(array, 0, array.length, n);
    default: res=recursiveChop(array, 0, array.length, n);
    }
    return res;
  }

  public void test(ChopType T){
    test(T, 100);
  }
  public void test(ChopType T, int testNum){
    System.out.println("test start ChopType:"+T);
    try {
      assert 0==-1;
      System.out.println("run with -ea option to test");
      return;
    }
    catch(AssertionError e){
    }

    try {
      int[] case0=new int[] {};
      int[] case1=new int[] {1};
      int[] case2=new int[] {1,2};
      int[] case3=new int[] {1,2,4};
      int[] case4=new int[] {1,2,4,9};
      int[][] testCases={case0, case1, case2, case3, case4};
      for(int i=0; i<testCases.length && i<testNum; i++){
        int[] tmp=testCases[i];
        for(int j=0; j<tmp.length; j++)
          assert chop(tmp, tmp[j], T)==j;
          // assert chop(tmp, tmp[j])==j;
        assert chop(tmp, 0, T)==-1;
        assert chop(tmp, 3, T)==-1;
        assert chop(tmp, 10, T)==-1;
        System.out.println("case #"+i+": succeeded");
      }
      // assert chop(case0, 0)==-1;
      // assert chop(case1, 1)==0;
      // assert chop(case2, 2)==1;
      // assert chop(case3, 1)==0;
      // assert chop(case3, 2)==1;
      // assert chop(case3, 4)==2;
      // assert chop(case3, 0)==-1;
      // assert chop(case3, 10)==-1;
      // assert chop(case3, 3)==-1;

    }catch(AssertionError e){
      System.out.println("test failed");
      e.printStackTrace();
    }
    System.out.println("test finished");
  }

  public static void main(String[] args){
    // System.out.println("Binary Chop");
    BinaryChop binary=new BinaryChop();
    binary.test(ChopType.RECURSIVE);
    binary.test(ChopType.ITERATIVE);
  }
}
