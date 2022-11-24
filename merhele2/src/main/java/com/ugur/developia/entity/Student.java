package com.ugur.developia.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name ="students")
public class Student {

    @Column(name = "id",unique = true,nullable = false,insertable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "studentName")
    private String studentName;

    @Column(name = "studentSurname")
    private String studentSurname;

    @Column(name = "studentBirthdate")
    private Date studentBirthdate;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Sector.class)
    private Sector sector;

    public Student() {
    }

    public Student(String studentName, String studentSurname, Date studentBirthdate, Sector sector) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentBirthdate = studentBirthdate;
        this.sector = sector;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public Date getStudentBirthdate() {
        return studentBirthdate;
    }

    public void setStudentBirthdate(Date studentBirthdate) {
        this.studentBirthdate = studentBirthdate;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentSurname='" + studentSurname + '\'' +
                ", studentBirthdate=" + studentBirthdate +
                ", sector=" + sector +
                '}';
    }
}
