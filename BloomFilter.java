import java.io.*;
import java.util.Random;

class BloomFilter{

  // class member
  private final int TABLE_SIZE=Integer.MAX_VALUE>>8;
  private boolean[] bloomTable;
  private final String WORD_LIST="wordlist.txt";
  private final int NUM_OF_HASH_METHOD=1;
  private HashMethods[] hms;
  private final int CHAR_OFFSET=65; //(int)'A'->65
  private final int NUM_OF_ALFABETS=26; // # of A~Z, same as # of a~z

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
      System.err.println(e);
    }

    try{
      String str;
      while((str=br.readLine())!=null){
        registDictionary(str);
        assert isInDictionary(str)==true;
      }
    }
    catch(FileNotFoundException e){
      System.err.println(e);
    }
    catch(IOException e){
      System.err.println(e);
    }

    try{
      br.close();
    }
    catch(IOException e){
      System.err.println(e);
    }


    assert isInDictionary("AA")==true;
    assert isInDictionary("zythum")==true;
    assert isInDictionary("xyzabc")==false;
    assert isInDictionary("hogehoge")==false;

    // check the number of false positive

    System.out.println("test finished");
    return;
  }

  private String getRandomWord(int wordLength){
    Random rnd=new Random();
    String str="";
    for(int i=0; i<wordLength; i++){
      int tmp=rnd.nextInt(NUM_OF_ALFABETS);
      if(rnd.nextBoolean()) tmp+=CHAR_OFFSET;
      else tmp=Character.toLowerCase((char)(tmp+CHAR_OFFSET));

      // System.out.println(tmp);
      assert (Character.isLowerCase((char)tmp)||Character.isUpperCase((char)tmp))==true;
      str+=(char)tmp;
    }
    return str;
  }

  private void writeRandomWordToFile(int numWords, int wordLength, String fileName){
    try{
      File file=new File(fileName);
      BufferedWriter bw=new BufferedWriter(new FileWriter(file));
      for(int i=0; i<numWords; i++){
        bw.write(getRandomWord(wordLength));
        bw.newLine();
      }
      bw.close();
    }
    catch(FileNotFoundException e){
      System.err.println(e);
    }
    catch(IOException e){
      System.err.println(e);
    }
  }

  public static void main(String args[]){
    System.out.println("kata-5: Bloom Filter");
    (new BloomFilter()).test();
    (new BloomFilter()).writeRandomWordToFile(30, 4, "random.txt");
  }
}
