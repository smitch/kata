class BloomFilter{

  private boolean isEnabledAssertion(){
    boolean isEnabled=false;
    assert isEnabled=true;
    return isEnabled;
  }

  private void test(){
    if(!isEnabledAssertion()){
      System.out.println("Error: -ea option is required to test");
      return;
    }

    return;
  }

  public static void main(String args[]){
    System.out.println("kata-5: Bloom Filter");
    (new BloomFilter()).test();
  }

}
