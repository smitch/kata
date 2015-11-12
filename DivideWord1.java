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

  private boolean isInDictionary(String word){
    boolean ret=false;
    try{
      File file=new File(WORD_LIST);
      BufferedReader br=new BufferedReader(new FileReader(file));
      String str;
      while((str=br.readLine())!=null){
        if(str.equals(word)){
          ret=true;
          break;
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
    return ret;
  }

  private void test(){
    if(!isAssrtionEnabled()){
      System.err.println("assertion is needed to test");
      return;
    }
    try{
      HashSet<String> wordSet=get6LengthWord();
      assert isAll6Wordfound(new HashSet<String>(wordSet))==true;
      assert isInDictionary("hogehoge")==false;
      assert isInDictionary("ABC")==true;
      assert isInDictionary("abc")==false;
      divideWord1(wordSet);
      // asset divideWord1(new HashSet<String>())

      System.out.println("test finished");
    }
    catch(AssertionError e){
      System.err.println("Error " + e.getMessage());
      e.printStackTrace();
    }

   return;
  }

  private boolean isAll6Wordfound(HashSet<String> wordSet){
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

  private void divideWord1(HashSet<String> wordSet){
    for(String str: wordSet){
      for(int i=1; i<str.length()-1; i++){
        String str1=str.substring(0, i);
        String str2=str.substring(i, str.length());
        if(isInDictionary(str1) && isInDictionary(str2))
          System.out.println(str+" "+str1+" "+str2);
      }
    }
    return;
  }

  public static void main(String[] args){
    System.out.println("Divide word class first design: readable code");
    new DivideWord1().test();
  }
}
