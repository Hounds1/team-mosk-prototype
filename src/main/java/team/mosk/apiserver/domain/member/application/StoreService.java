package team.mosk.apiserver.domain.member.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.mosk.apiserver.domain.member.domain.persist.Store;
import team.mosk.apiserver.domain.member.domain.persist.StoreRepository;
import team.mosk.apiserver.domain.member.dto.SimpleStoreResponse;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreService {

    private final StoreRepository storeRepository;
    private final PasswordEncoder passwordEncoder;

    public SimpleStoreResponse create(final Store store) {
        existEmail(store.getEmail());
        existCrn(store.getCrn());

        store.setEncodePass(passwordEncoder);

        Store savedStore = storeRepository.save(store);

        return SimpleStoreResponse.of(savedStore);
    }

    public void existEmail(final String email) {
        if (storeRepository.existsByEmail(email)) {
            throw new IllegalStateException("이미 가입된 이메일");
        }
    }

    public void existCrn(final String crn) {
        if (storeRepository.existsByCrn(crn)) {
            throw new IllegalStateException("이미 가입된 상점");
        }
    }
}
