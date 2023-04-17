package team.mosk.apiserver.domain.member.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.mosk.apiserver.domain.member.application.StoreService;
import team.mosk.apiserver.domain.member.dto.JoinRequest;
import team.mosk.apiserver.domain.member.dto.SimpleStoreResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class StoreController {

    private final StoreService storeService;

    @PostMapping("/Stores")
    public ResponseEntity<SimpleStoreResponse> create(@RequestBody JoinRequest joinRequest) {
        log.info("Join Request Info is => [email : {}], [name : {}], [ownerName : {}], [call : {}]," +
                "[crn : {}], [foundedDate : {}], [address city : {}], [address road : {}], [address zipcode : {}]", joinRequest.getEmail(), joinRequest.getName(),
                joinRequest.getOwnerName(), joinRequest.getCall(), joinRequest.getCrn(), joinRequest.getFoundedDate(), joinRequest.getAddress().getCity()
        ,joinRequest.getAddress().getRoad(), joinRequest.getAddress().getZipcode());

        return ResponseEntity.status(HttpStatus.CREATED).body(storeService.create(joinRequest.toEntity()));
    }
}
