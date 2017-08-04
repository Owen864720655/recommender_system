package fanglei.util;

public class Utils
{
	public static String tokensToUtterance(String[] tokens)
	{
		StringBuffer sb = new StringBuffer();
		for (String token : tokens)
		{
			sb.append(token);
		}
		return sb.toString();
	}
}
