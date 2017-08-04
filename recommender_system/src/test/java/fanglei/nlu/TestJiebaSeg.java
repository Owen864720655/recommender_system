package fanglei.nlu;

import java.util.Arrays;

import fanglei.nlu.preprocessor.controller.tokenization.JiebaSeg;

public class TestJiebaSeg
{

	public static void main(String[] args)
	{
		String text = "前任拉甘送苏宁首败落后恒大6分争冠难了";
		JiebaSeg segmenter = JiebaSeg.getInstance();
		String[] result = segmenter.segment(text);
		System.out.println(Arrays.asList(result));
	}
}
