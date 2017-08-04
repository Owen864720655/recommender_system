package fanglei.nlu.preprocessor.controller.postagging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import fanglei.nlu.constant.LtpConstant;
import fanglei.nlu.preprocessor.model.PosTag;

public class LtpPosTagger implements IPosTagger
{
	private PosTag[] posTags = null;

	private static class SingletonHolder
	{
		private static final LtpPosTagger INSTANCE = new LtpPosTagger();
	}

	private LtpPosTagger()
	{
	}

	/**
	 * 
	 * @return
	 */
	public static final LtpPosTagger getInstance()
	{
		return SingletonHolder.INSTANCE;
	}

	/**
	 * Get the POS tags
	 * 
	 * @param sentence
	 * @return
	 * @throws IOException
	 */
	private static String[] tag(String sentence) throws IOException
	{
		String result = "";
		String text = URLEncoder.encode(sentence, "utf-8");
		URL url = new URL(LtpConstant.URL_BASE + "api_key="
				+ LtpConstant.API_KEY + "&" + "text=" + text + "&" + "format="
				+ LtpConstant.FORMAT_PLAIN + "&" + "pattern="
				+ LtpConstant.PATTERN_POS_TAGGING);
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
		return result.split(LtpConstant.BLANK_SPACE);
	}

	public PosTag[] tagPos(String sentence) throws Exception
	{
		String[] results = tag(sentence);
		PosTag[] posTags = new PosTag[results.length];
		String result;
		for (int i = 0; i < results.length; i++)
		{
			result = results[i];
			String[] temp = result.split(LtpConstant.UNDERLINE);
			if (temp.length == 2)
			{
				posTags[i] = new PosTag(temp[0], temp[1]);
			}
			else
			{
				throw new Exception("Error. The POS Tagging fails!");
			}
		}
		this.posTags = posTags;
		return posTags;
	}

	public String[] getTokens()
	{
		String[] tokens = new String[posTags.length];
		int i = 0;
		for (PosTag posTag : posTags)
		{
			tokens[i] = posTag.getToken();
			i++;
		}
		return tokens;
	}

	public String[] getTags()
	{
		String[] tags = new String[posTags.length];
		int i = 0;
		for (PosTag posTag : posTags)
		{
			tags[i] = posTag.getTag();
			i++;
		}
		return tags;
	}

}
