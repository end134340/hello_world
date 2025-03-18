package com.yedam.api;

public class StringUtil {
	// 남, 여 반환
	static String getGender(String ssn) {
		char cut;
		if (ssn.length() > 13) {
			cut = ssn.charAt(6);
			ssn = ssn.replace(String.valueOf(cut), "");
		}
		if (ssn.charAt(6) % 2 == 0) {
			return "여";
		} else {
			return "남";
		}
	}

	// 파일명 반환
	static String getFileName(String file) {
		String[] strAry = file.split("/");

		String name = "";
		for (String str : strAry) {
			if (str.indexOf(".") != -1) {
				name = str.substring(0, str.indexOf("."));
				return name;
			}
		}
		return name;
	}

	// 파일확장자 반환
	static String getExtName(String file) {
		int idx = file.indexOf(".");
		return file.substring(idx + 1);
	}

}//