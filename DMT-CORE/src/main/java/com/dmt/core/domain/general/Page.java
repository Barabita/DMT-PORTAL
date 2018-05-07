package com.dmt.core.domain.general;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author mali.sahin
 * @since 21-Mar-18
 */

@Entity
@Table(name = "PAGE_DEFINITION")
public class Page implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", length = 36)
    private Long id;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "URL", length = 200)
    private String url;

    @Column(name = "TITLE", length = 100)
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
