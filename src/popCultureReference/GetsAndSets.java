package popCultureReference;

import java.util.HashSet;

/**
 * Created by brannon on 4/14/15.
 */

/*Method gets and sets the phrase matches for the Search Terms */
public class GetsAndSets {

   HashSet<String> containsTheWord = new HashSet<>();
   String textAreaDisplayer;

   public HashSet<String> getContainsTheWord() {
      return containsTheWord;
   }

   public void setContainsTheWord(HashSet<String> containsTheWord) {

      this.containsTheWord = containsTheWord;
   }

   public String getTextAreaDisplayer() {
      return textAreaDisplayer;
   }

   public void setTextAreaDisplayer(String textAreaDisplayer) {
      this.textAreaDisplayer = textAreaDisplayer;
   }
}
