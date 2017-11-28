package br.com.hiretest.crawler.utils.regex;

public class PatternConstants {
	
	public static final String ITEM_PATTERN = "<item>(.*?)</item>";
	public static final String ITEM_CONTENT_PATTERN = "<(title|link|description)>(.*?)</(?:title|link|description)>";
	public static final String ITEM_CONTENT_P_DIV_PATTERN = "<(p|div)(?:.*?)>(.*?)</(?:p|div)>";
	public static final String ITEM_CONTENT_IMG_UL_PATTERN = "<ul>(.*?)</ul>|<(img).*?src=['\"]{1}([^>]*?)['\"]{1}.*?>";
	public static final String ITEM_CONTENT_HYPERLINK_PATTERN = "<a.*?href=['\"]{1}([^>]*?)['\"]{1}.*?>";
	
	
	public static final String REPLACE_CDATA = "\\<\\!\\[CDATA\\[|\\]\\]\\>";
	public static final String REPLACE_HTML_TAGS = "<[^>]*>";
	public static final String REPLACE_NORMALIZE_HTML = "\t|\r|\n|&nbsp;";

}
