package team.mosk.apiserver.domain.member.domain.persist;

import lombok.*;
import org.hibernate.annotations.Where;
import org.springframework.security.crypto.password.PasswordEncoder;
import team.mosk.apiserver.domain.member.domain.vo.Address;
import team.mosk.apiserver.domain.member.domain.vo.RoleType;
import team.mosk.apiserver.global.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Where(clause = "activated = true")
@Table(indexes = {
        @Index(name = "i_email", columnList = "email"),
        @Index(name = "i_name", columnList = "name")
})
@Builder
public class Store extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private String ownerName;

    private String call;

    private boolean activated;

    private RoleType role;

    private String crn;

    //창업일
    private LocalDate foundedDate;

    @Embedded
    private Address address;

    public void setEncodePass(final PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }
}
