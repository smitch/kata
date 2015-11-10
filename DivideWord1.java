class DivideWord1{
  // Objective: to divide 6 length word in dictionary into two words
  //           and write code as readable as possible

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

    }
    catch(AssertionError e){
      System.err.println("Error " + e.getMessage());
      e.printStackTrace();
    }

   return;
  }

  // HashSet<String> get6LengthWord
  // read file and get 6 length words

  // void findDictionary
  // for each substring
  // findInDictionary

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
