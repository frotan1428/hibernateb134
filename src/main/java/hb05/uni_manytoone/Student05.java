package hb05.uni_manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_student05")
public class Student05 {
    @Id
    private int id;

    @Column(name = "std_name",length = 100,nullable = false)
    private String name;

    private int grade;

    private LocalDateTime createdDate;

    @ManyToOne//university_id
    @JoinColumn(name = "univ_id")
    private University university;

    @PrePersist //this annotation is used to specify a method to be called  before an entity is persisted to the DB.
    public void prePersist(){
        createdDate = LocalDateTime.now();//12-4-2023 :8:12
    }

    // getter and setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
        // since we used @PrePersist annotation , we do not  need to set Method ..
//    public void setCreatedDate(LocalDateTime createdDate) {
//        this.createdDate = createdDate;
//    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    // to string method

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createdDate=" + createdDate +
                ", university=" + university +
                '}';
    }
}
