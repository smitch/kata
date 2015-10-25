import java.io.*;

class BloomFilter{

  // class member
  private final int TABLE_SIZE=Integer.MAX_VALUE>>8;
  private boolean[] bloomTable;
  private final String WORD_LIST="wordlist.txt";
  private final int NUM_OF_HASH_METHOD=1;
  private HashMethods[] hms;

  private boolean isEnabledAssertion(){
    boolean isEnabled=false;
    assert isEnabled=true;
    return isEnabled;
  }

  private interface HashMethods{
    int hashMethod(String str);
  }

  private HashMethods[] getHashMethods(){
    HashMethods[] res=new HashMethods[NUM_OF_HASH_METHOD];
    res[0]=new HashMethods(){
        @Override
        public int hashMethod(String str){
          return str.hashCode();
        }
      };
    return res;
  }

  private void registDictionary(String word){
    for(HashMethods hmsTmp: hms){
      int hashValue=hmsTmp.hashMethod(word);

      int index=hashValue%TABLE_SIZE;
      if(index<0) index+=TABLE_SIZE;

      assert 0<=index && index<TABLE_SIZE;

      bloomTable[index]=true;
    }
    return;
  }

  private boolean isInDictionary(String word){
    boolean res=true;

    for(HashMethods hmsTmp: hms){
      int hashValue=hmsTmp.hashMethod(word);

      int index=hashValue%TABLE_SIZE;
      if(index<0) index+=TABLE_SIZE;

      assert 0<=index && index<TABLE_SIZE ;

      res&=bloomTable[index];
    }
    return res;

  }

  private void test(){
    BufferedReader br=null;
    bloomTable=new boolean[TABLE_SIZE];
    hms = getHashMethods();

    if(!isEnabledAssertion()){
      System.out.println("Error: -ea option is required to test");
      return;
    }

    try{
      File file=new File(WORD_LIST);
      br=new BufferedReader(new FileReader(file));
    }
    catch(FileNotFoundException e){
      System.out.println(e);
    }

    try{
      String str;
      while((str=br.readLine())!=null){
        registDictionary(str);
        assert isInDictionary(str)==true;
      }
    }
    catch(FileNotFoundException e){
      System.out.println(e);
    }
    catch(IOException e){
      System.out.println(e);
    }

    try{
      br.close();
    }
    catch(IOException e){
      System.out.println(e);
    }


    assert isInDictionary("AA")==true;
    assert isInDictionary("zythum")==true;
    assert isInDictionary("xyzabc")==false;
    assert isInDictionary("hogehoge")==false;

    // check the number of false positive

    System.out.println("test finished");
    return;
  }

  public static void main(String args[]){
    System.out.println("kata-5: Bloom Filter");
    (new BloomFilter()).test();
  }
}
