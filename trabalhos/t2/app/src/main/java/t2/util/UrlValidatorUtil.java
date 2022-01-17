package t2.util;

import org.apache.commons.validator.routines.UrlValidator;

public class UrlValidatorUtil {
    public static boolean validate(String url) {
        return new UrlValidator().isValid(url);
    }
}
