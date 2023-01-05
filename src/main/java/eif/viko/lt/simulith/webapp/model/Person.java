package eif.viko.lt.simulith.webapp.model;


import javax.persistence.*;

@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String email;
    private String group;
    private String role;
    private String country;
    private String schoolName;
    private boolean innerAudit;
    private boolean isApproved;

    public Person() {}

    public Person(String fullName, String email, String group, String role, String country, String schoolName, boolean innerAudit, boolean isApproved) {
        this.fullName = fullName;
        this.email = email;
        this.group = group;
        this.role = role;
        this.country = country;
        this.schoolName = schoolName;
        this.innerAudit = innerAudit;
        this.isApproved = isApproved;
    }
}
