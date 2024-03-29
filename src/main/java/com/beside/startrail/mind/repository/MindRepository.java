package com.beside.startrail.mind.repository;

import com.beside.startrail.common.type.YnType;
import com.beside.startrail.mind.document.Mind;
import java.util.UUID;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface MindRepository extends ReactiveMongoRepository<Mind, UUID> {
  Flux<Mind> findAllByUserSequenceAndRelationshipSequenceAndUseYn(
      String userSequence,
      String relationshipSequence,
      YnType useYn,
      Sort sort
  );

  Flux<Mind> findAllByUserSequenceAndRelationshipSequenceAndUseYn(
      String userSequence,
      String relationshipSequence,
      YnType useYn
  );

  Mono<Mind> findOneByUserSequenceAndSequenceAndUseYn(
      String userSequence,
      String sequence,
      YnType useYn
  );

  Flux<Mind> findByUserSequenceAndUseYn(String userSequence, YnType useYn);
}
