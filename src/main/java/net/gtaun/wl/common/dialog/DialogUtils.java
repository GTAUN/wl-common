package net.gtaun.wl.common.dialog;

import org.apache.commons.lang3.StringUtils;

public final class DialogUtils
{
	public static String rightPad(String str, int size, int tabSize)
	{
		return str + StringUtils.repeat('\t', (size - str.length()) / tabSize);
	}
	
	private DialogUtils()
	{
		
	}
}
