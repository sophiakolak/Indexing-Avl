/* Following the specification in the README.md file, provide your 
 * FileAvl class.
 */
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class FileAvl{
    AvlTree oak = new AvlTree(); 
    FileAvl(String urMom){
    if (urMom == null)
    {
        System.out.println("Sorry you must add a real file");
    }
    else
    {
        File givenFile = new File(urMom);
        try
        {
            int lineNumber = 0;
            String[] stringArray;
            Scanner scanWords = new Scanner(givenFile);
            while(scanWords.hasNext())
            {
                lineNumber++;  
                String currentLine = scanWords.nextLine().toLowerCase();
                stringArray = currentLine.split(" ");
                for (int i = 0; i < stringArray.length; i++)
                {
                    indexWord(oak, stringArray[i], lineNumber);
                }
            }
        }
        catch(FileNotFoundException a)
        {
            a.printStackTrace();
        }
    }
  }
    
  public void indexWord(String word, int line)
  {
      indexWord(oak, word, line);
  }
  private void indexWord(AvlTree oak, String word, int line)
  {
      oak.insert(word, line);
  }
    
  public void getLinesForWord(String word)
  {
      getLinesForWord(oak, word);
  }
  private void getLinesForWord(AvlTree oak, String word)
  {
      oak.findLine(word);
  }
    
  public void printIndex()
  {
      printIndex(oak);
  }
  private void printIndex(AvlTree oak)
  {
      oak.printTree(); 
  }
        
}