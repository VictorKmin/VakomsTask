package app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;


@Entity
public class LongShortUrl {
    @Id
    private String id;

    private String enteredUrl;
    private String prettyUrl;


    public LongShortUrl() {
    }

    public String getPrettyUrl() {
        return prettyUrl;
    }

    public void setPrettyUrl(String prettyUrl) {
        this.prettyUrl = prettyUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnteredUrl() {
        return enteredUrl;
    }

    public void setEnteredUrl(String enteredUrl) {
        this.enteredUrl = enteredUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LongShortUrl)) return false;
        LongShortUrl that = (LongShortUrl) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getEnteredUrl(), that.getEnteredUrl());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getEnteredUrl());
    }


    @Override
    public String toString() {
        return "LongShortUrl{" +
                "id='" + id + '\'' +
                ", enteredUrl='" + enteredUrl + '\'' +
                ", prettyUrl='" + prettyUrl + '\'' +
                '}';
    }
}