class WeatherData{

  private int minmumTempSpreadDay(){
    int res=0;
    return res;
  }

  private int tempSpread(){
    in res=0;
    return res;
  }

  private bool fileOpen(){
  }

  public void test(){
    try{
      assert 0==-1;
      System.out.println("run with -ea option to test");
      return;
    }
    catch(AssertionError e){
      System.out.println("test start");
    }

    int ans=0, expect=0;
    try{
      ans fileOpen()==true;
      // ans=minimunTempSpreadDay();
      // expect=14
      // assert ans==14;
    }catch(AssertionError e){
      System.out.println("test failed");
      System.out.format("expect=%d, ans=%d\n", expect, ans);
    }
  }

  public static void main(String[] args){
    System.out.println("code kata: Weather Data");
  }
}