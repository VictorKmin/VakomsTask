package app.dao;

import app.entity.LongShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlDAO extends JpaRepository<LongShortUrl, String> {


}