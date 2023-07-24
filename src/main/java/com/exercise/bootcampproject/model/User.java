package com.exercise.bootcampproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.ZonedDateTime;

@Data @NoArgsConstructor
@Entity @Table(name = "register_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_address")
    private String emailAddress;

    @Enumerated(value = EnumType.STRING)
    private Administration administration;

    @JsonIgnore
    private String password;
    @JsonIgnore
    private String rePassword = printInfo();

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    @CreatedDate
    private ZonedDateTime createdAt = makeDate();


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "photoUpload_id", referencedColumnName = "id")
    private PhotoUpload photoUpload;


    @ManyToOne @JsonIgnore
    @JoinColumn(name = "bootcamp_id", referencedColumnName = "id")
    private BootCamp bootCamp;

    private ZonedDateTime makeDate(){
        ZonedDateTime date = ZonedDateTime.now();
        return date;
    }

    private String printInfo(){
      Boolean answer =  checkPassword(this.password,this.rePassword);
      if (answer == true){
          return ("Your password matches");
      }
        return ("Your password does not match" + "\n" + "Enter again");
    }

    private Boolean checkPassword(String password,String rePassword){
        if (password == rePassword){
            return true;
        }
        return false;
    }
}
