package team.mosk.apiserver.domain.member.dto;

import lombok.*;
import team.mosk.apiserver.domain.member.domain.persist.Store;
import team.mosk.apiserver.domain.member.domain.vo.Address;
import team.mosk.apiserver.domain.member.domain.vo.RoleType;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class JoinRequest {

    private String email;

    private String password;

    private String name;

    private String ownerName;

    private String call;

    private String crn;

    private LocalDate foundedDate;

    private Address address;

    public Store toEntity() {
        return Store.builder()
                .email(email)
                .password(password)
                .name(name)
                .ownerName(ownerName)
                .call(call)
                .crn(crn)
                .foundedDate(foundedDate)
                .address(address)
                .activated(true)
                .role(RoleType.SELLER)
                .build();
    }
}
