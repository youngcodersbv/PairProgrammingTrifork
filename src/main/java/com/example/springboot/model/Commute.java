package com.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Locale;
import java.util.function.Predicate;

@Entity
@Table(name = "commute", schema = "public")
@JsonIgnoreProperties({"user"})
public class Commute {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String home;

    @Column(nullable = false)
    private String work;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;


    public static Predicate<Commute> createFilter(String filter) {
        return new Predicate<Commute>() {
            @Override
            public boolean test(Commute commute) {
                return filter(filter, commute);
            }
        };
    }

    public static boolean filter(String filter, Commute commute) {
        if(filter == null) {
            return true;
        }
        if(commute.getHome().toLowerCase(Locale.ROOT).contains(filter.toLowerCase(Locale.ROOT))) {
            return true;
        } else if(commute.getWork().toLowerCase(Locale.ROOT).contains(filter.toLowerCase(Locale.ROOT))) {
            return true;
        } else {
            return false;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
