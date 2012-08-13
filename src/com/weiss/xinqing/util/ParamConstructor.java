package com.weiss.xinqing.util;

//construction
public class ParamConstructor {
	/*
	 * for pictures
	 */
	// {'categoryType':'PICTURE','searchType':'COMMON',keyWords':'%@','pageNo':%d}
	private static final String HOT_STR_PIC = "{'categoryType':'PICTURE','searchType':'HOT','pageNo':1,'version':'1.2.0'}";
	private static final String SPECIAL_STR_PIC = "{'categoryType':'PICTURE','searchType':'CLASSIFY','classifyParam':'%s','pageNo':1,'version':'1.2.0'}";
	private static final String COMMON_STR_PIC = "{'categoryType':'PICTURE','searchType':'COMMON','keyWords':'%s','pageNo':1,'version':'1.2.0'}";
	private static final String SUBJECT_PARAMS = "{'picOfSubject':'false','version':'1.2.0','recentDays':%d}";
	private static final String PICTURE_OF_SUBJECT_PARAMS = "{'picOfSubject':'true','version':'1.2.0','subjectId':%d}";

	public static final String getHotParamsForPic() {
		return HOT_STR_PIC;
	}

	public static final String getSpecialParamsForPic(String type) {
		return String.format(SPECIAL_STR_PIC, type);
	}

	public static final String getCommonParamsForPic(String keyWords) {
		return String.format(COMMON_STR_PIC, keyWords);
	}

	public static final String getSubjectParams(int interval) {
		return String.format(SUBJECT_PARAMS, interval);
	}

	public static final String getPicsOfSubjectParams(int subId) {
		return String.format(PICTURE_OF_SUBJECT_PARAMS, subId);
	}
}
