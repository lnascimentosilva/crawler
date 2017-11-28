package br.com.hiretest.crawler.utils.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherUtils {
	
	
	private static Matcher getMatcher(String pattern, String content) {
		Pattern p = Pattern.compile(pattern);
		return p.matcher(content);
	}

	public static Matcher getItemMatcher(String content) {
		return MatcherUtils.getMatcher(PatternConstants.ITEM_PATTERN, content);
	}
	
	public static Matcher getItemContentMatcher(String content) {
		return MatcherUtils.getMatcher(PatternConstants.ITEM_CONTENT_PATTERN, content);
	}
	
	public static Matcher getItemContentParagraphAndDivMatcher(String content) {
		return MatcherUtils.getMatcher(PatternConstants.ITEM_CONTENT_P_DIV_PATTERN, content);
	}
	
	public static Matcher getItemContentImageAndUnorderedListMatcher(String content) {
		return MatcherUtils.getMatcher(PatternConstants.ITEM_CONTENT_IMG_UL_PATTERN, content);
	}
	
	public static Matcher getItemContentHyperlinkMatcher(String content) {
		return MatcherUtils.getMatcher(PatternConstants.ITEM_CONTENT_HYPERLINK_PATTERN, content);
	}
}
