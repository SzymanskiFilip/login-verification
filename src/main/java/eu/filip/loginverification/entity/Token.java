package eu.filip.loginverification.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
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
    private Date expiration_date;

    @Column(name = "activation_token")
    private UUID activation_token;
}
