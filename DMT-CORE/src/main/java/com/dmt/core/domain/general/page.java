package com.dmt.core.domain.general;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author mali.sahin
 * @date 21-Mar-18
 */

@Entity
@Table(name = "PAGE_DEFINITION")
@Getter
@Setter
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

}
