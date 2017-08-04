package fanglei.nlu.preprocessor.controller.postagging;

import fanglei.nlu.preprocessor.model.PosTag;

public interface IPosTagger
{
	/**
	 * Tag the Part-of-Speech
	 * 
	 * @param sentence
	 * @return
	 * @throws Exception
	 */
	public PosTag[] tagPos(String sentence) throws Exception;

	/**
	 * Get all the tokens
	 * 
	 * @return
	 */
	public String[] getTokens();

	/**
	 * Get all the POS tags
	 * 
	 * @return
	 */
	public String[] getTags();

}
