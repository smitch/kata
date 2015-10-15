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
    // modulo the hash number by tableSize=: index
    // assert the index < tableSize
    // set the bits corresponding to the index on in dictionary(bloom table)
    return;
  }

  private boolean isInDictionary(String word){
    return false;
  }


  private void test(){
    BufferedReader br=null;
    bloomTable=new boolean[TABLE_SIZE];

    if(!isEnabledAssertion()){
      System.out.println("Error: -ea option is required to test");
      return;
    }

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

    return;
  }

  public static void main(String args[]){
    System.out.println("kata-5: Bloom Filter");
    (new BloomFilter()).test();
  }

}
