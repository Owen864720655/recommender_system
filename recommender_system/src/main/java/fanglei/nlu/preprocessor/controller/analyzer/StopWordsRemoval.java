package fanglei.nlu.preprocessor.controller.analyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fanglei.util.Utils;

public class StopWordsRemoval implements IAnalyzer
{
	// public static final String STOP_WORD_TABLE = "." + File.separator + "src"
	// + File.separator + "main" + File.separator + "resources"
	// + File.separator + "models" + File.separator + "stopwords.txt";
	public static final String STOP_WORD_TABLE = "." + File.separator + "src"
			+ File.separator + "main" + File.separator + "resources"
			+ File.separator + "models" + File.separator + "stopwords"
			+ File.separator + "userdic.txt";

	/**
	 * Stop words set
	 */
	private static Set<String> stopWords = new HashSet<String>();

	/**
	 * Singleton mode
	 */
	private static final StopWordsRemoval INSTANCE = new StopWordsRemoval();

	public static StopWordsRemoval getInstance()
	{
		return INSTANCE;
	}

	/**
	 * Read the stop words from local file
	 * 
	 * @param path
	 * @throws IOException
	 */
	public static void readStopWords(String path) throws IOException
	{
		stopWords.clear();
		File file = new File(path);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String stopWord = null;
		while ((stopWord = br.readLine()) != null)
		{
			stopWords.add(stopWord);
		}
		fr.close();
		br.close();
	}

	/**
	 * 
	 * Constructor
	 */
	private StopWordsRemoval()
	{
		try
		{
			readStopWords(STOP_WORD_TABLE);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String remove(String[] words)
	{
		List<String> result = new ArrayList<String>();

		if (words == null || words.length == 0)
		{
			return null;
		}
		for (String word : words)
		{
			if (!stopWords.contains(word))
			{
				result.add(word);
			}
		}
		return Utils
				.tokensToUtterance(result.toArray(new String[result.size()]));
	}
}
