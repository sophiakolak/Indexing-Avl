public class Problem2{
  public static void main(String[] args){
      
    //create fileAvl object
    FileAvl urMom = new FileAvl(args[0]);
    urMom.printIndex();
    urMom.getLinesForWord("hoo");
  }
}