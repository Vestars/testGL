package gl.tech.task.backend.db;

import javax.persistence.*;

@Table
@Entity(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "works_days", nullable = false)
    private Integer worksDays;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "computer_id", referencedColumnName = "id")
    private Computer computer;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWorksDays() {
        return worksDays;
    }

    public void setWorksDays(Integer worksDays) {
        this.worksDays = worksDays;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
