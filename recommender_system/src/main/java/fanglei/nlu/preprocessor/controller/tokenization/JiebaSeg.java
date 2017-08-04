package fanglei.nlu.preprocessor.controller.tokenization;

import java.util.List;

import com.huaban.analysis.jieba.JiebaSegmenter;

public class JiebaSeg implements ITokenizer
{

	private static class SingletonHolder
	{
		private static final JiebaSeg INSTANCE = new JiebaSeg();
	}

	private JiebaSeg()
	{
	}

	/**
	 * 
	 * @return
	 */
	public static final JiebaSeg getInstance()
	{
		return SingletonHolder.INSTANCE;
	}

	private JiebaSegmenter segmenter = new JiebaSegmenter();

	public String[] segment(String text)
	{
		List<String> result = segmenter.sentenceProcess(text);
		return (result.toArray(new String[result.size()]));

	}
}
