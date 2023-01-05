package eif.viko.lt.simulith.webapp.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String personEmail;
    private String personGroup;
    private String personRole;
    private String personCountry;
    private String schoolName;
    private boolean innerAudit;
    private boolean approved;

    public Person() {}

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public String getPersonGroup() {
        return personGroup;
    }

    public String getPersonRole() {
        return personRole;
    }

    public String getPersonCountry() {
        return personCountry;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public boolean isInnerAudit() {
        return innerAudit;
    }

    public boolean isApproved() {
        return approved;
    }
}
