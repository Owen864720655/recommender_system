package fanglei.nlu.preprocessor.controller.analyzer;

public interface IAnalyzer
{
	/**
	 * Remove the stop words
	 * 
	 * @param words
	 * @return
	 */
	public String remove(String[] words);

}
