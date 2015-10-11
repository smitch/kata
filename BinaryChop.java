import java.util.*;

class BinaryChop{

  enum ChopType {RECURSIVE, ITERATIVE, FUNCTIONAL, STD_FUNC, OBJECT_ORIENTED};

  private class ObjectOrientedChop{
    int[] array;
    int s;
    int t;
    int n;
    ObjectOrientedChop(int[] array, int s, int t, int n){
      this.array=array;
      this.s=s;
      this.t=t;
      this.n=n;
    }

    public int find(){
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
  }

  private int objectOrientedChop(int[] array, int s, int t, int n){
    int res=-1;
    ObjectOrientedChop chop=new ObjectOrientedChop(array, s, t, n);
    res=chop.find();
    return res;
  }

  private int stdFuncChop(int[] array, int s, int t, int n){
    int res=-1;
    res=Arrays.
      binarySearch(array, n);
    if(res<0) res=-1;
    return res;
  }

  private int functionalChop(int[] array, int s, int t, int n){
    int res=-1;
    int mid=(s+t)/2;
    // System.out.format("\ns=%d, mid=%d, t=%d, n=%d\n", s, mid, t, n);
    // System.out.println("array="+Arrays.toString(array));
    // System.out.println("array[s:mid)="+Arrays.toString(Arrays.copyOfRange(array, s, mid)));
    // System.out.println("array[mid:t)="+Arrays.toString(Arrays.copyOfRange(array, mid, t)));
    if(array.length==1){
      if(array[s]==n)
        res=s;
      else res=-1;
    }
    else if(array[mid]>n) res=functionalChop(Arrays.copyOfRange(array, s, mid), 0, mid, n);
    else{
      res=functionalChop(Arrays.copyOfRange(array, mid, t), 0, t-mid, n);
      if(res!=-1) res+=mid;
    }
    return res;
  }

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
    case RECURSIVE:
      res=recursiveChop(array, 0, array.length, n);
      break;
    case ITERATIVE:
      res=iterativeChop(array, 0, array.length, n);
      break;
    case FUNCTIONAL:
      res=functionalChop(array, 0, array.length, n);
      break;
    case STD_FUNC:
      res=stdFuncChop(array, 0, array.length, n);
      break;
    case OBJECT_ORIENTED:
      res=objectOrientedChop(array, 0, array.length, n);
      break;
    default: System.err.println("Error: no such ChopType "+T);
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

    int ans=0, expect=0;
    try {
      int[] case0=new int[] {};
      int[] case1=new int[] {1};
      int[] case2=new int[] {1,2};
      int[] case3=new int[] {1,2,4};
      int[] case4=new int[] {1,2,4,9};
      int[][] testCases={case0, case1, case2, case3, case4};
      for(int i=0; i<testCases.length && i<testNum; i++){
        int[] tmp=testCases[i];
        int j=0;
        for(j=0; j<tmp.length; j++){
          System.out.format("case #%d-%d", i, j);
          expect=j;
          ans=chop(tmp, tmp[j], T);
          assert ans==expect;
          System.out.println(": succeeded");
        }
        expect=-1;
        System.out.format("case #%d-%d", i, j++);
        ans=chop(tmp, 0, T); 
        assert ans==expect;
        System.out.println(": succeeded");
        System.out.format("case #%d-%d", i, j++);
        ans=chop(tmp, 3, T); 
        assert ans==expect;
        System.out.println(": succeeded");
        System.out.format("case #%d-%d", i, j++);
        ans=chop(tmp, 10, T);
        assert ans==expect;
        System.out.println(": succeeded");
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
      System.out.println(": failed");
      System.out.format("expect=%d, ans=%d\n", expect, ans);
      //      e.printStackTrace();
    }
    System.out.println("test finished");
  }

  public static void main(String[] args){
    // System.out.println("Binary Chop");
    BinaryChop binary=new BinaryChop();
    binary.test(ChopType.RECURSIVE);
    binary.test(ChopType.ITERATIVE);
    binary.test(ChopType.FUNCTIONAL);
    binary.test(ChopType.STD_FUNC);
    binary.test(ChopType.OBJECT_ORIENTED);
    // binary.test(ChopType.FUNCTIONAL, 3);
  }
}
