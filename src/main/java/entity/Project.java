package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by glady on 30.06.2017.
 */
@Entity
@Table(name = "PROJECT")
public class Project{


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees;

    public Project() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != null ? !id.equals(project.id) : project.id != null) return false;
        return title != null ? title.equals(project.title) : project.title == null;
    }
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}