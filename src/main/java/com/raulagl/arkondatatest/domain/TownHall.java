package com.raulagl.arkondatatest.domain;

import javax.persistence.*;


@Table( name = "town_hall" )
@Entity
public class TownHall {


    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "town_hall_generator")
    @SequenceGenerator( name = "town_hall_generator", sequenceName = "town_hall_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column( name = "id_provided")
    private Long idProvided;


    @Column( name = "full_text")
    private String fullText;

    @Column( name = "name")
    private String name;

    @Column( name = "cve_mun")
    private Integer keyMun;

    @Column( name = "cve_ent")
    private Integer keyEnt;

    @Column( name = "cve_geo")
    private Integer keyGeo;

    @Column( name = "gid")
    private Integer gid;

    @Column( name = "geo_point_2d")
    private String geographicPoint2d;

    @Column( name = "geo_shape")
    private String geographicShape;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProvided() {
        return idProvided;
    }

    public void setIdProvided(Long idProvided) {
        this.idProvided = idProvided;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getKeyMun() {
        return keyMun;
    }

    public void setKeyMun(Integer keyMun) {
        this.keyMun = keyMun;
    }

    public Integer getKeyEnt() {
        return keyEnt;
    }

    public void setKeyEnt(Integer keyEnt) {
        this.keyEnt = keyEnt;
    }

    public Integer getKeyGeo() {
        return keyGeo;
    }

    public void setKeyGeo(Integer keyGeo) {
        this.keyGeo = keyGeo;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGeographicPoint2d() {
        return geographicPoint2d;
    }

    public void setGeographicPoint2d(String geographicPoint2d) {
        this.geographicPoint2d = geographicPoint2d;
    }

    public String getGeographicShape() {
        return geographicShape;
    }

    public void setGeographicShape(String geographicShape) {
        this.geographicShape = geographicShape;
    }
}
