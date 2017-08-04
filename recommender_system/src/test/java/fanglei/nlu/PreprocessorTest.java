package fanglei.nlu;

import java.util.Arrays;

import fanglei.nlu.preprocessor.Preprocessor;
import fanglei.nlu.preprocessor.model.PreprocessorParam;

/**
 * Test Preprocessor
 * 
 * @author Owen
 *
 */
public class PreprocessorTest
{

	public static void main(String[] args) throws Exception
	{
		// String text = "前任拉甘送苏宁首败落后恒大6分争冠难了";
		String utterance = "我想充个值ֵ";
		Preprocessor preprocessor = new Preprocessor();
		preprocessor.process(utterance);

		PreprocessorParam preprocessorParam = preprocessor
				.getPreprocessorParam();
		System.out.println("Utterance: " + preprocessorParam.getUtterance());
		System.out.println("Tokens: "
				+ Arrays.asList(preprocessorParam.getTokens()));
		System.out.println("PosTags: "
				+ Arrays.asList(preprocessorParam.getPosTags()));
	}

}
