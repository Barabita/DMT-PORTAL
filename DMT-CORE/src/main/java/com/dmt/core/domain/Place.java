package com.dmt.core.domain;

import com.dmt.core.domain.enums.PlaceType;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "PLACE_DEF")
public class Place extends BaseDomain implements Serializable {

    @Id
    @Column(name = "ID", length = 11, nullable = false)
    private String id;

    @Column(name = "NAME", length = 20, nullable = false)
    private String name;

    @Column(name = "TYPE", length = 5, nullable = false)
    @Enumerated(EnumType.STRING)
    private PlaceType type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlaceType getType() {
        return type;
    }

    public void setType(PlaceType type) {
        this.type = type;
    }
}
