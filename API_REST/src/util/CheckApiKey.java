package util;

public class CheckApiKey {
private static String apikey1="123ABC";
private static String apikey2="ABC123";
public static Boolean isApiKey1(String apikey) {
	return apikey.equals(apikey1);
}
public static Boolean isApiKey2(String apikey) {
	return apikey.equals(apikey2);
}

}
