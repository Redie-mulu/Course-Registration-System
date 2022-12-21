package edu.miu.courseregistrationsystem.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Rediet
 * @version 1.0
 * @created 17-Dec-2022 07:48 AM
 */
@Entity
@Data
public class RegistrationEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status = "new";
    @OneToMany(cascade = CascadeType.ALL)
    List<RegistrationGroup> registrationGroups;

    public RegistrationEvent() {
    }

    public RegistrationEvent(long id, LocalDateTime startDate, LocalDateTime endDate, List<RegistrationGroup> registrationGroups) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.registrationGroups = registrationGroups;
    }

    public void setStatus(String status) {
        if (startDate.isBefore(LocalDateTime.now()) && endDate.isAfter(LocalDateTime.now())) {
            this.status = "Open";
        } else {
            this.status = "Closed";
        }
        this.status = status;
    }

    @Override
    public String toString() {
        return "RegistrationEvent{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", registrationGroups=" + registrationGroups +
                '}';
    }
}
