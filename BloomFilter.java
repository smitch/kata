import java.io.*;
import java.util.Random;

/* experiment note
   [condition]
   words in dictionary: 338,882
   random word length: 4(# of word combination is approximately 7.3M)
   number of random word: 800(6 words is in the word list -> 764 words can be false positive)
   number of hash method: 1~2
   table size: Integer.MAX_VALUE>>8(2^23=8.3M)~Integer.MAX_VALUE>>12(2^19=524K)
               Integer.MAX_VALUE=2^31-1

   [result]
   table size: Integer.MAX_VALUE>>8
   hash method: 1
   -> number of false positive: 29

   table size: Integer.MAX_VALUE>>8
   hash method: 1, 2
   -> number of false positive: 5

   table size: Integer.MAX_VALUE>>9
   hash method: 1
   -> number of false positive: 61

   table size: Integer.MAX_VALUE>>9
   hash method: 1, 2
   -> number of false positive: 18

   table size: Integer.MAX_VALUE>>10
   hash method: 1
   -> number of false positive: 139

   table size: Integer.MAX_VALUE>>10
   hash method: 1, 2
   -> number of false positive: 65

   table size: Integer.MAX_VALUE>>10
   hash method: 1
   -> number of false positive: 139

   table size: Integer.MAX_VALUE>>10
   hash method: 1, 2
   -> number of false positive: 65

   table size: Integer.MAX_VALUE>>11
   hash method: 1
   -> number of false positive: 216

   table size: Integer.MAX_VALUE>>11
   hash method: 1, 2
   -> number of false positive: 178

   table size: Integer.MAX_VALUE>>12
   hash method: 1
   -> number of false positive: 368

   table size: Integer.MAX_VALUE>>12
   hash method: 1, 2
   -> number of false positive: 403

*/

class BloomFilter{

  // class member
  private final int TABLE_SIZE=Integer.MAX_VALUE>>12;
  // private final int TABLE_SIZE=Integer.MAX_VALUE>>8;
  private boolean[] bloomTable;
  private final String WORD_LIST="wordlist.txt";
  // private final int NUM_OF_HASH_METHOD=2;
  private final int NUM_OF_HASH_METHOD=1;
  private HashMethods[] hms;
  private final int CHAR_OFFSET=65; //(int)'A'->65
  private final int NUM_OF_ALFABETS=26; // # of A~Z, same as # of a~z
  private final String RANDOM_WORD_LIST="random.txt";

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
    if(NUM_OF_HASH_METHOD>0){
      res[0]=new HashMethods(){
          public int hashMethod(String str){
            return str.hashCode();
          }
        };
    }
    if(NUM_OF_HASH_METHOD>1){
      res[1]=new HashMethods(){
          public int hashMethod(String str){
            int res=13;
            for(char c: str.toCharArray()){
              res*=(int)c;
            }
            return res;
          }
        };
    }
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

      assert 0<=index && index<TABLE_SIZE;

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

      String str;
      while((str=br.readLine())!=null){
        registDictionary(str);
        assert isInDictionary(str)==true;
      }
      br.close();
    }
    catch(FileNotFoundException e){
      System.err.println(e);
    }
    catch(IOException e){
      System.err.println(e);
    }

    assert isInDictionary("AA")==true;
    assert isInDictionary("zythum")==true;
    // assert isInDictionary("xyzabc")==false;
    // assert isInDictionary("hogehoge")==false;

    assert isInWordList("AA")==true;
    assert isInWordList("zythum")==true;
    assert isInWordList("xyzabc")==false;
    assert isInWordList("hogehoge")==false;

    // writeRandomWordToFile(800, 4, RANDOM_WORD_LIST);
    // writeRandomWordToFile(400, 4, RANDOM_WORD_LIST);
    // writeRandomWordToFile(200, 4, RANDOM_WORD_LIST);

    // check the number of false positive
    countFalsePositive();

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

      assert (Character.isLowerCase((char)tmp)||Character.isUpperCase((char)tmp))==true;
      str+=(char)tmp;
    }
    return str;
  }

  private void countFalsePositive(){
    int count=0;
    try{
      File file=new File(RANDOM_WORD_LIST);
      BufferedReader br=new BufferedReader(new FileReader(file));
      String str;
      while((str=br.readLine())!=null){
        if(isInDictionary(str)==true && isInWordList(str)==false){
          count++;
          System.out.println(str+" is false positive");
        }
      }
      br.close();
    }
    catch(FileNotFoundException e){
      System.err.println(e);
    }
    catch(IOException e){
      System.err.println(e);
    }
    System.out.println("number of false positive is "+count);
    return;
  }

  private boolean isInWordList(String word){
    try{
      File file=new File(WORD_LIST);
      BufferedReader br=new BufferedReader(new FileReader(file));
      String str;
      while((str=br.readLine())!=null){
        if(str.equals(word)) return true;
      }
      br.close();
    }
    catch(FileNotFoundException e){
      System.err.println(e);
    }
    catch(IOException e){
      System.err.println(e);
    }
    return false;
  }

  private void writeRandomWordToFile(int numWords, int wordLength, String fileName){
    System.out.format("gen %d words, length is %d\n", numWords, wordLength);
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
    // (new BloomFilter()).writeRandomWordToFile(30, 4, "RANDOM_WORD_LIST");
  }
}
