package util;

public class CheckApiKey {
private static String apikey1="ABC123";
private static String apikey2="123ABC";
public static Boolean isApiKey1(String apikey) {
	if(apikey==null) {
		return false;
	}else {
	return apikey.equals(apikey1);
	}
}
public static Boolean isApiKey2(String apikey) {
	if(apikey==null) {
		return false;
	}else {
	return apikey.equals(apikey2);
}
}

}
