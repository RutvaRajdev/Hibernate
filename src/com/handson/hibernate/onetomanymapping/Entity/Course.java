package com.handson.hibernate.onetomanymapping.Entity;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor_onetomany=" + instructor_onetomany +
                '}';
    }

    public Course(String title) {
        this.title = title;
    }


    public Instructor getInstructor_onetomany() {
        return instructor_onetomany;
    }

    public void setInstructor_onetomany(Instructor instructor_onetomany) {
        this.instructor_onetomany = instructor_onetomany;
    }

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "instructor_id")
    private Instructor instructor_onetomany;
}
