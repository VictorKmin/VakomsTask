package app.service.urlService;


import app.dao.UrlDAO;
import app.entity.LongShortUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlDAO urlDAO;


    @Override
    @Transactional
    public void save(LongShortUrl longShortUrl) {
        if (longShortUrl != null) {
            urlDAO.save(longShortUrl);
        }
    }

    @Override
    public List<LongShortUrl> findAll() {
        return urlDAO.findAll();
    }

}