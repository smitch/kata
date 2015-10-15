class BloomFilter{

  // class member
  // bloomTable: array of bits
  // tableSize
  // private final String word list file

  private boolean isEnabledAssertion(){
    boolean isEnabled=false;
    assert isEnabled=true;
    return isEnabled;
  }

  // private hashMethod1
  // private hashMethod2
  // ...
  // private hashMethodN

  // private void registDictionary(String word)
  // hash the word
  // set the bits corresponding to the hash numbers on in dictionary(bloom table)

  // private boolean isInDictionary(String word)


  private void test(){
    if(!isEnabledAssertion()){
      System.out.println("Error: -ea option is required to test");
      return;
    }

    // open file; file contains a word per line

    // while bufferedReader != null
    // read a word in list
    // registDictionary

    // assert the word is in the Dictionary

    // close file

    // pick a word and check the word is in the dictionary

    return;
  }

  public static void main(String args[]){
    System.out.println("kata-5: Bloom Filter");
    (new BloomFilter()).test();
  }

}
