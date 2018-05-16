package app.service.urlService;

import com.google.common.hash.Hashing;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class UrlUtil {


    public String urlHasher(String enteredUrl) {
        return Hashing.murmur3_32()
                .hashString(enteredUrl.split("/", 4)[3], StandardCharsets.UTF_8)
                .toString();
    }


    public String prettyUrl(String[] splitedUrl) {
        return splitedUrl[2];
    }


}
