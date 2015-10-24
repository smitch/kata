import java.io.*;

class BloomFilter{

  // class member
  private final int TABLE_SIZE=Integer.MAX_VALUE>>8;
  private boolean[] bloomTable;
  // bloomTable: array of bits
  private final String WORD_LIST="wordlist.txt";

  private boolean isEnabledAssertion(){
    boolean isEnabled=false;
    assert isEnabled=true;
    return isEnabled;
  }

  private int hashMethod1(String str){
    return str.hashCode();
  }
  // private hashMethod2
  // ...
  // private hashMethodN

  private void registDictionary(String word){
    // hash the word
    int hashValue=hashMethod1(word);

    // modulo the hash number by tableSize=: index
    int index=hashValue%TABLE_SIZE;
    if(index<0) index+=TABLE_SIZE;

    // System.out.println("debug: hashValue is "+hashValue);
    // System.out.println("debug: index is "+index);

    assert 0<=index && index<TABLE_SIZE ;

    // set the bits corresponding to the index on in dictionary(bloom table)
    bloomTable[index]=true;

    return;
  }

  private boolean isInDictionary(String word){
    // hash the word
    int hashValue=hashMethod1(word);

    // modulo the hash number by tableSize=: index
    int index=hashValue%TABLE_SIZE;
    if(index<0) index+=TABLE_SIZE;

    // System.out.println("debug: hashValue is "+hashValue);
    // System.out.println("debug: index is "+index);

    assert 0<=index && index<TABLE_SIZE ;

    // check the bits corresponding to the index is on in dictionary(bloom table)
    if(bloomTable[index]==true) return true;
    else return false;

  }


  private void test(){
    BufferedReader br=null;
    bloomTable=new boolean[TABLE_SIZE];

    if(!isEnabledAssertion()){
      System.out.println("Error: -ea option is required to test");
      return;
    }

    // System.out.println("debug: table size is "+TABLE_SIZE);

    // open file; file contains a word per line
    try{
      File file=new File(WORD_LIST);
      br=new BufferedReader(new FileReader(file));
    }
    catch(FileNotFoundException e){
      System.out.println(e);
    }

    try{
      // for word in word list
      String str;
      while((str=br.readLine())!=null){
        // regist the word to Dictionary
        registDictionary(str);
        // assert the word is in the Dictionary
        assert isInDictionary(str)==true;
      }
    }
    catch(FileNotFoundException e){
      System.out.println(e);
    }
    catch(IOException e){
      System.out.println(e);
    }

    // close file when all word is registered
    try{
      br.close();
    }
    catch(IOException e){
      System.out.println(e);
    }


    // pick a word and check the word is in the dictionary
    assert isInDictionary("AA")==true;
    assert isInDictionary("zythum")==true;
    assert isInDictionary("xyzabc")==false;
    assert isInDictionary("hogehoge")==false;

    // check the number of false positive

    return;
  }

  public static void main(String args[]){
    System.out.println("kata-5: Bloom Filter");
    (new BloomFilter()).test();
  }

}
