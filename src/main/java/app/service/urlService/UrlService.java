package app.service.urlService;

import app.entity.LongShortUrl;

import java.util.List;

public interface UrlService {

    void save(LongShortUrl longShortUrl);

    List<LongShortUrl> findAll();
}