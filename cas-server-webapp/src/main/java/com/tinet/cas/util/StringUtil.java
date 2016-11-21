// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   StringUtil.java

package com.tinet.cas.util;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

/**
 * 扩展自org.apache.commons.lang.StringUtils，提供操作String的工具函数。
 * <p>
 * 文件名： StringUtil.java
 * <p>
 * Copyright (c) 2006-2010 T&I Net Communication CO.,LTD. All rights reserved.
 * 
 * @author 周营昭
 * @since 1.0
 * @version 1.0
 */
public final class StringUtil extends org.apache.commons.lang.StringUtils {

	public StringUtil() {
	}

	/**
	 * 使用指定的分割符(可以是多个)做String分词。参数seperators中的所有字符都作为分隔符。
	 * <p>
	 * 如果参数include标志为true，则分隔符也作为分词的一部分返回；如果为false，则分隔符将被跳过。
	 * 
	 * @param seperators
	 *            分隔符字符串。
	 * @param list
	 *            待分词的字符串。
	 * @param include
	 *            返回的分词中是否包含分隔符。
	 * @return 分割后的字符串数组。
	 */
	public static String[] split(String seperators, String list, boolean include) {
		StringTokenizer tokens = new StringTokenizer(list, seperators, include);
		String result[] = new String[tokens.countTokens()];
		int i = 0;

		while (tokens.hasMoreTokens())
			result[i++] = tokens.nextToken();
		return result;
	}

	/**
	 * 将字符串转成boolean类型。 如果字符串等于"true"、"t"、"1"，则返回true，否则返回false。
	 * 
	 * @param tfString
	 *            待转换字符串。
	 * @return
	 */
	public static boolean booleanValue(String tfString) {
		String trimmed = tfString.trim().toLowerCase();
		return "true".equals(trimmed) || "1".equals(trimmed) || "t".equals(trimmed);
	}

	/**
	 * 根据提供的标示符,分割字符串。 参数delim中的字符都会被作为分隔符使用，分隔符不会被作为分词的一部分。
	 * 
	 * @param str
	 *            待分割字符串。
	 * @param delim
	 *            分隔符。
	 * @return
	 */
	public static final String[] explodeString(String str, String delim) {
		if (str == null || str.equals("")) {
			String[] retstr = new String[1];
			retstr[0] = "";
			return retstr;
		}
		StringTokenizer st = new StringTokenizer(str, delim);
		String[] retstr = new String[st.countTokens()];
		int i = 0;

		while (st.hasMoreTokens()) {
			retstr[i] = st.nextToken();
			i++;
		}

		if (i == 0) {
			retstr[0] = str;
		}

		return retstr;
	}

	/**
	 * 判断是否为整型数字类型。
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[1-9][0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 判断一个字符是否不是空字符串。 如果一个字符为null或者长度为0的字符串，则被认为是Empty。 长度不为0的空格符字符串也被认为not
	 * empty。
	 * 
	 * @param string
	 * @return true 字符串不为空字符串。
	 */
	public static boolean isNotEmpty(String string) {
		return string != null && string.length() > 0;
	}

	/**
	 * 判断一个字符是否为空字符串。 如果一个字符为null或者长度为0的字符串，则被认为是Empty。 长度不为0的空格符字符串也被认为not
	 * empty。
	 * 
	 * @param string
	 * @return true 字符串为空字符串。
	 */
	public static boolean isEmpty(String string) {
		return string == null || string.length() == 0;
	}

	/**
	 * 判断字符串是否非空。
	 * <p>
	 * 功能等同于{@link StringUtil#isNotEmpty}。
	 * 
	 * @param src
	 *            要判断的字符串。
	 * @return null或长度为0则返回false，否则返回true。
	 */
	public static boolean isNotNull(String src) {
		return isNotEmpty(src);
	}

	/**
	 * 过滤空值。 如果参数src不为空，则返回src的字符串表示，否则返回参数defaultValue指定的值。
	 * 
	 * @param src
	 *            要过滤的对象。
	 * @param defaultValue
	 *            默认返回值。
	 * @return 过滤null之后的返回值，如果为null，则返回默认值，否则去掉两边的空格后返回。
	 */
	public static String filterNull(Object src, String defaultValue) {
		if (src != null) {
			return src.toString().trim();
		}

		return defaultValue;
	}

	/**
	 * 从参数src左边取参数length指定数量的字符。 如果参数src为null，则返回参数defaultValue。
	 * 
	 * @param src
	 *            源字符串。
	 * @param length
	 *            截取长度。
	 * @param defaultValue
	 *            src为null情况下返回的值。
	 * @return
	 */
	public static String left(Object src, int length, String defaultValue) {
		if (src != null) {
			String temp = src.toString();

			if (temp.length() >= length) {
				return temp.substring(0, length);
			}

			return temp;
		}

		return defaultValue;
	}

	/**
	 * 从参数src右边取参数length指定数量的字符。 如果参数src为null，则返回参数defaultValue。
	 * 
	 * @param src
	 *            源字符串。
	 * @param length
	 *            截取长度。
	 * @param defaultValue
	 *            src为null情况下返回的值。
	 * @return
	 */
	public static String right(Object src, int length, String defaultValue) {
		if (src != null) {
			String temp = src.toString();
			int tempLen = temp.length();

			if (tempLen >= length) {
				return temp.substring(tempLen - length, tempLen);
			}

			return temp;
		}

		return defaultValue;
	}

	/**
	 * 按照拆分字符串。如果分词为空也保存在返回的字符串数组。 <br>
	 * 例如
	 * <ul>
	 * StringUtil.split("a.b.c", '.') = ["a", "b", "c"]
	 * </ul>
	 * <ul>
	 * StringUtil.split("a..b.c", '.') = ["a", "", "b", "c"]
	 * </ul>
	 * 
	 * @param src
	 *            要拆分的字符串。
	 * @param flag
	 *            拆分的标记。
	 * 
	 * @return 返回拆分后的数组，内容为空也包含在拆分的字符串数组中。
	 */
	public static String[] split(String src, String flag) {
		return StringUtils.splitPreserveAllTokens(src, flag);
	}

	/**
	 * 获取不带扩展名的文件名。 比如：StringUtil.getFilenameWithNoExt("C:/dir/a.txt") =
	 * "C:/dir/a";
	 * 
	 * @param filename
	 *            要处理的文件名。
	 * @return 去掉扩展名后的文件名。
	 */
	public static String getFilenameWithNoExt(String filename) {
		return filename.substring(0, filename.lastIndexOf("."));
	}

	/**
	 * 获取文件的扩展名。 比如：StringUtil.getFilenameWithNoExt("C:/dir/a.txt") = "txt";
	 * 
	 * @param filename
	 *            要处理的文件名。
	 * @return 文件名的扩展名。
	 */
	public static String getFilenameExt(String filename) {
		return filename.substring(filename.lastIndexOf(".") + 1);
	}

	/**
	 * 将参数src指定的字符串转成整型，如果无法解析为整型数字，则返回参数defaultValue指定的值。
	 * 
	 * @param src
	 * @param defaultValue
	 * @return int 解析后的整数。
	 */
	public static int toInt(Object src, int defaultValue) {
		try {
			return Integer.parseInt(src.toString());
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static String numToChinese(String input) {
		String s1 = "零壹贰叁肆伍陆柒捌玖";
		String s4 = "分角整元拾佰仟万拾佰仟亿拾佰仟";
		String temp = "";
		String result = "";
		if (input == null)
			return "输入字串不是数字串只能包括以下字符（??0??～??9??，??.??)，输入字串最大只能精确到仟亿，小数点只能两位！";
		temp = input.trim();

		try {
			Float.parseFloat(temp);
		} catch (Exception e) {
			return "输入字串不是数字串只能包括以下字符（??0??～??9??，??.??)，输入字串最大只能精确到仟亿，小数点只能两位！";
		}

		int len = 0;
		if (temp.indexOf(".") == -1)
			len = temp.length();
		else
			len = temp.indexOf(".");
		if (len > s4.length() - 3)
			return ("输入字串最大只能精确到仟亿，小数点只能两位！");
		int n1, n2 = 0;
		String num = "";
		String unit = "";
		String tempNum = "";
		for (int i = 0; i <= len + 2; i++) {
			if (temp.length() == i) {
				break;
			}
			if (i == len) {
				tempNum = "";
				continue;
			}
			n1 = Integer.parseInt(String.valueOf(temp.charAt(i)));
			num = s1.substring(n1, n1 + 1);
			n1 = len - i + 2;
			unit = s4.substring(n1, n1 + 1);
			if (num.equals("零")) {
				if (tempNum.equals("零")) {
					if (unit.equals("万") || unit.equals("亿") || unit.equals("元") || unit.equals("角")
							|| unit.equals("分")) {
						if (result.indexOf("零") == result.length() - 1) {
							result = result.substring(0, result.length() - 1);
						}
						if (!unit.equals("角") && !unit.equals("分")) {
							num = "";
						} else if (unit.equals("角") || unit.equals("分")) {
							tempNum = num;
							continue;
						}
					} else {
						tempNum = num;
						continue;
					}

				} else {
					if (unit.equals("万") || unit.equals("亿") || unit.equals("元")) {
						if (len > 1) {
							num = "";
						}
					} else if (!unit.equals("角") && !unit.equals("分")) {
						unit = "";
					} else if (unit.equals("角") || unit.equals("分")) {
						tempNum = num;
						continue;
					}
				}
			}
			result = result.concat(num).concat(unit);
			tempNum = num;
		}
		if ((len == temp.length()) || (len == temp.length() - 1) || result.indexOf("元") == result.length() - 1)
			result = result.concat("整");

		return result;
	}

	/**
	 * 弱密码校验 1. 长度不少于8位，不大于50位。 2. 为字母、数字、符号的任意组合，必须包含大小写字母和数字。
	 * 
	 * @return
	 */
	public static String isEasyPwd(String pwd) {
		// 长度不少于8位
		if (pwd.length() < 8) {
			return "密码长度不能小于8位";
		}
		// 不能包含URL
		String s = "(https://|http://)?([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
		Pattern pattern = Pattern.compile(s);
		Matcher isUrl = pattern.matcher(pwd);
		if (isUrl.matches()) {
			return "密码中不能包含URL";
		}

		// 简单密码判断
		if (pwd.length() == 8
				&& (pwd.contains("123456") || pwd.contains("654321") || pwd.contains("abc123")
						|| pwd.contains("aaa111") || pwd.contains("qaswed"))) {
			return "密码过于简单！";
		}

		// 为字母、数字、符号的任意组合，必须包含大小写字母和数字。
		int isNum = 0;
		int isLower = 0;
		int isUpper = 0;
		int isSpecial = 0;
		int strong = 0;
		for (int i = 0; i < pwd.length(); i++) {
			int ascii = pwd.charAt(i);
			if (ascii >= 48 && ascii <= 57) {
				if (isNum != 1) {
					isNum = 1;
				}
				continue;
			} else if (ascii >= 97 && ascii <= 122) {
				if (isLower != 2) {
					isLower = 2;
				}
				continue;
			} else if (ascii >= 65 && ascii <= 90) {
				if (isUpper != 4) {
					isUpper = 4;
				}
				continue;
			} else {
				if (isSpecial != 8) {
					isSpecial = 8;
				}
				continue;
			}
		}
		strong = isNum | isLower | isUpper | isSpecial;
		if (strong == 7) {
			return "3";
		} else if (strong == 15) {
			return "4";
		} else {
			return "密码中必须包含大小写字母和数字！";
		}
	}

	/**
	 * 数字转换成汉字
	 * 
	 * @return
	 */
	public static String fmtNum2Cn(int i) {
		int[] numArra = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		String[] cnArra = new String[] { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
		boolean flag = false;
		for (int j = 0; j < numArra.length; j++) {
			if (numArra[j] == i) {
				flag = true;
				return cnArra[j];
			}
		}
		if (!flag) {
			return cnArra[0];
		}
		return null;
	}

	/** * 清零 * @param str 原始字符串 * @return */
	public static String trimBigDecimalZero(String str) {
		if (str.indexOf(".") != -1 && str.charAt(str.length() - 1) == '0') {
			return trimBigDecimalZero(str.substring(0, str.length() - 1));
		} else {
			return str.charAt(str.length() - 1) == '.' ? str.substring(0, str.length() - 1) : str;
		}
	}

	/**
	 * 是否ip
	 * 
	 * @param ip
	 * @return
	 */
	public static boolean isIp(String ip) {
		Pattern pattern = Pattern
				.compile("\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
		Matcher matcher = pattern.matcher(ip);
		return matcher.matches();
	}

	public static String transfer(String str) {
		if (str == null) {
			return "";
		}
		return StringEscapeUtils.escapeSql(str.replace('\'', '‘'));
	}

	public static String escapeHtml(String str) {
		if (isEmpty(str)) {
			return "";
		}
		return escapeHtmlAndScript(str);
	}

	/**
	 * 暴力设置指定对象的String类型的字段
	 * 
	 * @param object
	 * @return
	 */
	public static Object escapeHtml(Object object) {
		if (object == null) {
			return object;
		}
		return escape(object, "html");
	}

	/**
	 * 针对HTML和javascript转意，集合里的对象非String类型
	 * 
	 * @param c
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Collection escapeHtml(Collection c) {
		if (c == null) {
			return c;
		}
		Iterator i = c.iterator();
		while (i.hasNext()) {
			escapeHtml(i.next());
		}
		return c;

	}

	public static List<String> escapeHtml(List<String> list) {
		if (list == null) {
			return list;
		}
		for (int i = 0; i < list.size(); i++) {
			list.set(i, escapeHtml(list.get(i)));
		}
		return list;
	}

	/**
	 * 暴力设置指定对象的String类型的字段
	 * 
	 * @param object
	 * @return
	 */
	public static Object escapeSql(Object object) {
		if (object == null) {
			return object;
		}
		if (object instanceof String) {
			return StringEscapeUtils.escapeSql(object.toString());
		}
		return escape(object, "sql");
	}

	private static Object escape(Object object, String escapeType) {
		Class c = object.getClass();
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			String typeName = field.getGenericType().toString();
			if (typeName.endsWith("String")) {
				field.setAccessible(true);
				Object fieldValue = null;
				try {
					fieldValue = field.get(object);
				} catch (Exception e) {
				}
				if (fieldValue != null && StringUtil.isNotEmpty(fieldValue.toString())) {
					try {
						field.set(object, escape(fieldValue.toString(), escapeType));
					} catch (Exception e) {
					}
				}
				field.setAccessible(false);
			}

		}
		return object;
	}

	private static String escape(String value, String escapeType) {
		if (StringUtil.isEmpty(value)) {
			return "";
		}
		String v = null;
		if ("html".equals(escapeType)) {
			v = StringEscapeUtils.escapeJavaScript(value);
			v = StringEscapeUtils.escapeHtml(value);
			v = v.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
		} else {
			v = StringEscapeUtils.escapeSql(value);
		}
		return v;
	}

	public static String escapeHtmlAndScript(String str) {
		if (isEmpty(str)) {
			return str;
		}
		return StringEscapeUtils.escapeJavaScript(StringEscapeUtils.escapeHtml(str)).replaceAll("\\(", "&#40;")
				.replaceAll("\\)", "&#41;");
	}

	/**
	 * 将html和 script的特殊字符转为实体字符(忽略中文字符),防止脚本注入漏洞
	 * 
	 * @param str
	 *            转义前的字符串
	 * @return 转义后的后的字符串
	 */
	public static String escapeSequence(String str) {
		if (isEmpty(str)) {
			return str;
		}
		String result = "";
		String temp = "";
		for (int i = 0; i < str.length(); i++) {
			int chr1 = (char) str.charAt(i);
			if (chr1 >= 19968 && chr1 <= 171941) {// 汉字范围 \u4e00-\u9fa5 (中文)
				result += str.charAt(i);
			} else {
				temp = "" + str.charAt(i);
				result += StringEscapeUtils.escapeJavaScript(StringEscapeUtils.escapeHtml(temp))
						.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
			}
		}
		return result;
	}

}
