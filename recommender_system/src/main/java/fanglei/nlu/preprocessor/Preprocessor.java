package fanglei.nlu.preprocessor;

import fanglei.nlu.preprocessor.controller.analyzer.StopWordsRemoval;
import fanglei.nlu.preprocessor.controller.postagging.LtpPosTagger;
import fanglei.nlu.preprocessor.controller.tokenization.LtpSeg;
import fanglei.nlu.preprocessor.model.PosTag;
import fanglei.nlu.preprocessor.model.PreprocessorParam;

public class Preprocessor
{
	private PreprocessorParam preprocessorParam = new PreprocessorParam();

	public Preprocessor()
	{
	}

	/**
	 * Constructor
	 * 
	 * @param preprocessorParam
	 */
	public Preprocessor(PreprocessorParam preprocessorParam)
	{
		super();
		this.preprocessorParam = preprocessorParam;
	}

	/**
	 * Process
	 * 
	 * @param utterance
	 * @throws Exception
	 */
	public void process(String utterance) throws Exception
	{
		preprocessorParam.setUtterance(utterance);
		String[] tokens = LtpSeg.getInstance().segment(utterance);
		preprocessorParam.setTokens(tokens);
		utterance = StopWordsRemoval.getInstance().remove(tokens);
		PosTag[] posTags = LtpPosTagger.getInstance().tagPos(utterance);
		preprocessorParam.setPosTags(posTags);
	}

	/**
	 * @return the preprocessorParam
	 */
	public PreprocessorParam getPreprocessorParam()
	{
		return preprocessorParam;
	}

	/**
	 * @param preprocessorParam
	 *            the preprocessorParam to set
	 */
	public void setPreprocessorParam(PreprocessorParam preprocessorParam)
	{
		this.preprocessorParam = preprocessorParam;
	}

}
