package com.beside.startrail.mind.command;

import com.beside.startrail.common.type.YnType;
import com.beside.startrail.mind.document.Mind;
import com.beside.startrail.mind.repository.MindRepository;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;

public class MindFindAllByRelationshipSequenceCommand {
  private final String relationshipSequence;
  private Flux<Mind> result;

  public MindFindAllByRelationshipSequenceCommand(String relationshipSequence) {
    this.relationshipSequence = relationshipSequence;
  }

  public Flux<Mind> execute(MindRepository mindRepository) {
    result = mindRepository.findAllByRelationshipSequenceAndUseYn(
        relationshipSequence,
        YnType.Y
    );

    return result;
  }
}
