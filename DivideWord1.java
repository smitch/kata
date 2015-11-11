import java.util.HashSet;
import java.io.*;

class DivideWord1{
  // Objective: to divide 6 length word in dictionary into two words
  //           and write code as readable as possible

  private final String WORD_LIST="wordlist.txt";
  private final String WORD_LIST_6LENGTH="6lengthwordlist.txt";

  private boolean isAssrtionEnabled(){
    boolean isEnabled=false;
    assert isEnabled=true;
    return isEnabled;
  }

  private void test(){
    if(!isAssrtionEnabled()){
      System.err.println("assertion is needed to test");
      return;
    }
    try{
      HashSet<String> wordSet=get6LengthWord();
      assert isAll6Wordfoud(new HashSet<String>(wordSet))==true;
      System.out.println("test finished");
    }
    catch(AssertionError e){
      System.err.println("Error " + e.getMessage());
      e.printStackTrace();
    }

   return;
  }

  private boolean isAll6Wordfoud(HashSet<String> wordSet){
    boolean ret=true;
    try{
      File file=new File(WORD_LIST_6LENGTH);
      BufferedReader br=new BufferedReader(new FileReader(file));
      String str;
      while((str=br.readLine())!=null){
        if(!wordSet.contains(str)){
          System.err.println("unneccesary word is contained");
          ret=false;
          break;
        }
        wordSet.remove(str);
      }
      br.close();
    }
    catch(FileNotFoundException e){
      System.err.println(e);
    }
    catch(IOException e){
      System.err.println(e);
    }
    if(wordSet.isEmpty()==false)
      ret=false;

    return ret;
  }

  private HashSet<String> get6LengthWord(){
    HashSet<String> set=new HashSet<String>();
    try{
      File file=new File(WORD_LIST);
      BufferedReader br=new BufferedReader(new FileReader(file));
      String str;
      while((str=br.readLine())!=null){
        if(str.length()==6)
          set.add(str);
      }
      br.close();
    }
    catch(FileNotFoundException e){
      System.err.println(e);
    }
    catch(IOException e){
      System.err.println(e);
    }

    return set;
  }

  private void findDictionary(String word){
  // for each substring
  // findInDictionary
    return;
  }

  // pubclic void divideWord1{
  // read dictionary and find 6 length word
  // divide the word and find substring in dictionary
  // if the both words are found, print the word
  //}

  public static void main(String[] args){
    System.out.println("Divide word class first design: readable code");
    new DivideWord1().test();
  }
}
