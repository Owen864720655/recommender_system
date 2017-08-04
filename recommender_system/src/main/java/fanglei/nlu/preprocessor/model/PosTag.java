package fanglei.nlu.preprocessor.model;

public class PosTag
{
	/**
	 * Token
	 */
	private String token = "";

	/**
	 * Tag
	 */
	private String tag = "";

	public PosTag()
	{
	}

	public PosTag(String token, String tag)
	{
		super();
		this.token = token;
		this.tag = tag;
	}

	/**
	 * @return the token
	 */
	public String getToken()
	{
		return token;
	}

	/**
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token)
	{
		this.token = token;
	}

	/**
	 * @return the tag
	 */
	public String getTag()
	{
		return tag;
	}

	/**
	 * @param tag
	 *            the tag to set
	 */
	public void setTag(String tag)
	{
		this.tag = tag;
	}

	@Override
	public String toString()
	{
		return "PosTag [token=" + token + ", tag=" + tag + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PosTag other = (PosTag) obj;
		if (tag == null)
		{
			if (other.tag != null)
				return false;
		}
		else if (!tag.equals(other.tag))
			return false;
		if (token == null)
		{
			if (other.token != null)
				return false;
		}
		else if (!token.equals(other.token))
			return false;
		return true;
	}

}
