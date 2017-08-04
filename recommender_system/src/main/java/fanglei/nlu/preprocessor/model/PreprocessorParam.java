package fanglei.nlu.preprocessor.model;

public class PreprocessorParam
{
	/**
	 * The utterance
	 */
	private String utterance = null;

	/**
	 * tokens
	 */
	private String[] tokens = null;

	/**
	 * POS tags
	 */
	private PosTag[] posTags = null;

	/**
	 * Constructor
	 * 
	 * @param utterance
	 */
	public PreprocessorParam()
	{
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param utterance
	 */
	public PreprocessorParam(String utterance)
	{
		super();
		this.utterance = utterance;
	}

	/**
	 * 
	 * @param utterance
	 * @param tokens
	 * @param posTags
	 */
	public PreprocessorParam(String utterance, String[] tokens, PosTag[] posTags)
	{
		super();
		this.utterance = utterance;
		this.tokens = tokens;
		this.posTags = posTags;
	}

	/**
	 * @return the utterance
	 */
	public String getUtterance()
	{
		return utterance;
	}

	/**
	 * @param utterance
	 *            the utterance to set
	 */
	public void setUtterance(String utterance)
	{
		this.utterance = utterance;
	}

	/**
	 * @return the tokens
	 */
	public String[] getTokens()
	{
		return tokens;
	}

	/**
	 * @param tokens
	 *            the tokens to set
	 */
	public void setTokens(String[] tokens)
	{
		this.tokens = tokens;
	}

	/**
	 * @return the posTags
	 */
	public PosTag[] getPosTags()
	{
		return posTags;
	}

	/**
	 * @param posTags
	 *            the posTags to set
	 */
	public void setPosTags(PosTag[] posTags)
	{
		this.posTags = posTags;
	}

}
