package app.service.validators;

import app.entity.LongShortUrl;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UrlValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(LongShortUrl.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        LongShortUrl longShortUrl = (LongShortUrl) target;
        String url = longShortUrl.getEnteredUrl();
        if (url.isEmpty() || url == null) {
            errors.rejectValue("enteredUrl", "", "url not valid");
        } else if (!url.startsWith("http://") && !url.startsWith("https://")) {
            errors.rejectValue("enteredUrl", "", "must start with http:// or https://");
        } else if (url.length() < 10) {
            errors.rejectValue("enteredUrl", "", "url is too short");

        }

    }
}
