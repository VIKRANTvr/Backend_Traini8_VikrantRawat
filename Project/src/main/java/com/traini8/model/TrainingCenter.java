package com.traini8.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "training_centers")
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Center Name is required")
    @Size(max = 40, message = "Center Name must be less than 40 characters")
    @Column(name = "center_name")
    private String centerName;

    @Column(unique = true, length = 12, name = "center_code")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center Code must be exactly 12 alphanumeric characters")
    private String centerCode;

    @Embedded
    private Address address;

    @Column(name = "student_capacity")
    private Integer studentCapacity;

    @ElementCollection
    @CollectionTable(name = "courses_offered", joinColumns = @JoinColumn(name = "center_id"))
    @Column(name = "course_name")
    private List<String> coursesOffered;

    @Column(name = "created_on", updatable = false)
    private Instant createdOn;

    @Email(message = "Invalid email format")
    @Column(name = "contact_email")
    private String contactEmail;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    @Column(name = "contact_phone")
    private String contactPhone;

    @PrePersist
    public void prePersist() {
        this.createdOn = Instant.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getStudentCapacity() {
        return studentCapacity;
    }

    public void setStudentCapacity(Integer studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

    public List<String> getCoursesOffered() {
        return coursesOffered;
    }

    public void setCoursesOffered(List<String> coursesOffered) {
        this.coursesOffered = coursesOffered;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
