package score.helper;

import java.util.regex.Pattern;

/* singleton 패턴
 * 1. 객체를 1개만 만들어서 사용
 * 2. new로 객체 생성이 안됨
 * */
public class RegexHelper {
	// singleton 패턴 시작
	private static RegexHelper instance = null;

	public static RegexHelper getInstance() {
		if (instance == null)
			instance = new RegexHelper();
		return instance;
	}

	//new에 의한 객체생성이 불가능함
	private RegexHelper() {
          
	}
	// singleton 패턴 끝
	
	/**
	 * 주어진 문자열이 공백이거나 null인지를 검사 
	 * @param str
	 * @return boolean - 공백, null이 아닐 경우 true를 리턴
	 */
	public boolean isValue(String str) {
		boolean result = false;
		if(str !=null) {
			//trim: 공백문자 제거
			result =! str.trim().equals(""); 
		}
		return result;
	}
	
	/**
	 * 숫자 모양에 대한 형식 검사
	 * @param str
	 * @return boolean - 형식에 맞을 경우 true, 맞지 않을 경우 false
	 */
	public boolean isNum(String str) {
		boolean result = false;
		if(isValue(str)) {
			result = Pattern.matches("^[0-9]*$", str);
		}
		return result;
	}
	
	/**
	 * 한글로만 구성되었는지에 대한 형식 검사
	 * @param str
	 * @return boolean - 형식에 맞을 경우 true, 맞지 않을 경우 false
	 */
	public boolean isKor(String str) {
		boolean result = false;
		if(isValue(str)) {
			result = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", str);
		}
		return result;
	}
	
	/**
	 * 영어로만 구성되었는지에 대한 형식 검사
	 * @param str
	 * @return boolean - 형식에 맞을 경우 true, 맞지 않을 경우 false
	 */
	public boolean isEng(String str) {
		boolean result = false;
		if(isValue(str)) {
			result = Pattern.matches("^[a-zA-Z]*$", str);
		}
		return result;
	}
	
	
}
