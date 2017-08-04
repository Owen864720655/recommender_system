package fanglei.nlu.preprocessor.controller.tokenization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import fanglei.nlu.constant.LtpConstant;

public class LtpSeg implements ITokenizer
{
	private static class SingletonHolder
	{
		private static final LtpSeg INSTANCE = new LtpSeg();
	}

	private LtpSeg()
	{
	}

	/**
	 * 
	 * @return
	 */
	public static final LtpSeg getInstance()
	{
		return SingletonHolder.INSTANCE;
	}

	/**
	 * Segment the words
	 * 
	 * @param sentence
	 *            the sentence to be segmented
	 * @return
	 */
	public String[] segment(String sentence)
	{
		String result = "";
		try
		{
			String text = URLEncoder.encode(sentence, "utf-8");
			URL url = new URL(LtpConstant.URL_BASE + "api_key="
					+ LtpConstant.API_KEY + "&" + "text=" + text + "&"
					+ "format=" + LtpConstant.FORMAT_PLAIN + "&" + "pattern="
					+ LtpConstant.PATTERN_WORD_SEGMENTATION);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			BufferedReader innet = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf-8"));
			String line;
			while ((line = innet.readLine()) != null)
			{
				result += line;
			}
			innet.close();
			System.out.println(result);
			return result.split(LtpConstant.BLANK_SPACE);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
