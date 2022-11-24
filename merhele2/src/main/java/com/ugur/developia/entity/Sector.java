package com.ugur.developia.entity;

import javax.persistence.*;

@Entity
@Table(name = "sectors")
public class Sector {

    @Column(name = "id",unique = true,nullable = false,insertable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sectorName")
    private String sectorName;

    public Sector() {
    }

    public Sector(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }


    @Override
    public String toString() {
        return "Sector{" +
                "id=" + id +
                ", sectorName='" + sectorName + '\'' +
                '}';
    }
}
