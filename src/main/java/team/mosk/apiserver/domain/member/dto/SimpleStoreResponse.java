package team.mosk.apiserver.domain.member.dto;

import lombok.*;
import team.mosk.apiserver.domain.member.domain.persist.Store;
import team.mosk.apiserver.domain.member.domain.vo.RoleType;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class SimpleStoreResponse {
    private String name;

    private String ownerName;

    private String call;

    private RoleType role;

    public static SimpleStoreResponse of(final Store store) {
        return new SimpleStoreResponse(store.getName(), store.getOwnerName(), store.getCall(), store.getRole());
    }
}
