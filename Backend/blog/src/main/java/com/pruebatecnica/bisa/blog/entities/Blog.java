package com.pruebatecnica.bisa.blog.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private boolean allowComments;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    @JsonIgnore
    private Author author;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Comment> comments;

    private String periodicity;
    private String title;
    private String topic;
    public boolean isAllowComments() {
        return allowComments;
    }

    public void setAllowComments(boolean allowComments) {
        this.allowComments = allowComments;
    }
}

