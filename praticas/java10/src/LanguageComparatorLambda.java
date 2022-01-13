import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;


class Language {
	private String tag;
	private String year;

  public Language(String tag, String year) {
  	this.tag = tag;
   	this.year = year;
  }
	public String getTag() {
		return tag;
	}
  public String getYear() {
		return year; 
	}
	public String toString() {
		return tag + " (" + year + ")";
	}
}

class LanguageComparatorLambda {

	public static void main(String[] args) {
		List<Language> languages = new ArrayList<Language>();
		languages.add(new Language("java", "1995"));
		languages.add(new Language("python", "1991"));
		languages.add(new Language("cpp", "1985"));
    
    languages.sort(new Comparator<Language>() {
    	@Override
      public int compare(Language lang1, Language lang2) {
      	return lang1.getTag().compareTo(lang2.getTag());
      }
    });
		for (Language lang : languages) {
			System.out.println(lang);
		}
	}


}

