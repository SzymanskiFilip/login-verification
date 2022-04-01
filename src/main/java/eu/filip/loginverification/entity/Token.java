package eu.filip.loginverification.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "verification_tokens")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    @Id
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "expiration_date")
    private LocalDateTime expiration_date;

    @Column(name = "activation_token", updatable = false, nullable = false, unique = true, columnDefinition = "BINARY(16)")
    private UUID activation_token;
}
