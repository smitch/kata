class CommonKata-4{

  private BufferedReader br;

  public boolean fileOpen(String fileName){
    boolean res=true;
    // String fileName="weather.dat";
    try{
      File file=new File(fileName);
      br=new BufferedReader(new FileReader(file));
    }
    catch(FileNotFoundException e){
      System.out.println(e);
    }
    return res;
  }

  public boolean fileClose(){
    boolean res=true;
    try{
      br.close();
    }
    catch(IOException e){
      System.out.println(e);
    }
    return res;
  }

  private boolean isDigit(String str){
    try{
      Integer.parseInt(str);
      return true;
    }
    catch(NumberFormatException e){
      return false;
    }
  }

  public String getMinimumValue(int indexNum, int indexName, int indexValueA, int indexValueB){
    String res="";
    int min=Integer.MAX_VALUE;
    return res;
  }

}
