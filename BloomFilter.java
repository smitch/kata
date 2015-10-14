class BloomFilter{

  // class member
  // bloomTable: array of bits
  // tableSize

  private boolean isEnabledAssertion(){
    boolean isEnabled=false;
    assert isEnabled=true;
    return isEnabled;
  }

  // private hashMethod1
  // private hashMethod2
  // ...
  // private hashMethodN

  private void test(){
    if(!isEnabledAssertion()){
      System.out.println("Error: -ea option is required to test");
      return;
    }

    // open file

    // while bufferedReader != null
    // read a word in list
    // hash the word
    // set the bit corresponding to the hash number on in dictionary(bloom table)

    // close file

    // pick a word and check the word is in the dictionary

    return;
  }

  public static void main(String args[]){
    System.out.println("kata-5: Bloom Filter");
    (new BloomFilter()).test();
  }

}
