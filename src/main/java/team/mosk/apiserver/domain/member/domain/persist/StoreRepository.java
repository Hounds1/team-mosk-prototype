package team.mosk.apiserver.domain.member.domain.persist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {

    boolean existsByEmail(final String email);
    boolean existsByCrn(final String crn);
}
