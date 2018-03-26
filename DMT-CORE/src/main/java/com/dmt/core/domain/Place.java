package com.dmt.core.domain;

import com.dmt.core.domain.enums.PlaceType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "PLACE_DEF")
@Getter
@Setter
public class Place implements Serializable {

    @Id
    @Column(name = "ID", length = 11, nullable = false)
    private String id;

    @Column(name = "NAME", length = 20, nullable = false)
    private String isim;

    @Column(name = "TYPE", length = 5, nullable = false)
    private PlaceType type;


}
