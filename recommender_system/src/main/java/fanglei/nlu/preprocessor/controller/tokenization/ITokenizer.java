package fanglei.nlu.preprocessor.controller.tokenization;

public interface ITokenizer
{
	/**
	 * Segment the words
	 * 
	 * @param sentence
	 * @return
	 * @throws Exception
	 */
	public String[] segment(String sentence) throws Exception;
}
