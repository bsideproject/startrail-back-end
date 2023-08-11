package com.beside.startrail.relationship.command;

import com.beside.startrail.common.type.YnType;
import com.beside.startrail.relationship.document.Relationship;
import com.beside.startrail.relationship.repository.RelationshipRepository;
import reactor.core.publisher.Flux;

public class RelationshipFindAllByUserSequenceCommand {
  private final String userSequence;
  private final YnType useYn;
  private Flux<Relationship> result;

  public RelationshipFindAllByUserSequenceCommand(String userSequence, YnType useYn) {
    this.userSequence = userSequence;
    this.useYn = useYn;
  }

  public Flux<Relationship> execute(RelationshipRepository relationshipRepository) {
    result = relationshipRepository.findByUserSequenceAndUseYn(
        userSequence,
        useYn
    );

    return result;
  }
}
