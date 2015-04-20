package popCultureReference;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by brannon on 4/14/15.
 */

/*Method gets and sets the phrase matches for the Search Terms */
public class GetsAndSets {

   private Set<String> containsTheWord = new HashSet<>();
   private String textAreaDisplayer;
   private static int selection;

   public int getSelection() {
      return selection;
   }

   public void setSelection(int selection) {
      this.selection = selection;
   }

   public Set<String> getContainsTheWord() {
      return containsTheWord;
   }

   public void setContainsTheWord(Set<String> containsTheWord) {

      this.containsTheWord = containsTheWord;
   }

   public String getTextAreaDisplayer() {
      return textAreaDisplayer;
   }

   public void setTextAreaDisplayer(String textAreaDisplayer) {
      this.textAreaDisplayer = textAreaDisplayer;
   }
}
