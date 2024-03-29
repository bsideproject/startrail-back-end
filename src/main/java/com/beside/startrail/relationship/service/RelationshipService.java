package com.beside.startrail.relationship.service;

import com.beside.startrail.common.command.Command;
import com.beside.startrail.common.type.YnType;
import com.beside.startrail.relationship.command.RelationshipFindAllByUserSequenceAndNicknameKeywordAndUseYnCommand;
import com.beside.startrail.relationship.command.RelationshipFindAllByUserSequenceAndUseYnCommand;
import com.beside.startrail.relationship.command.RelationshipFindOneByUserSequenceAndSequenceAndUseYnCommand;
import com.beside.startrail.relationship.command.RelationshipSaveOneCommand;
import com.beside.startrail.relationship.document.Relationship;
import com.beside.startrail.relationship.repository.CustomRelationshipRepository;
import com.beside.startrail.relationship.repository.RelationshipRepository;
import com.beside.startrail.relationship.type.SortType;
import java.util.Comparator;
import java.util.Optional;
import protobuf.common.LevelInformationProto;
import protobuf.relationship.RelationshipResponseProto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class RelationshipService {
  public static Flux<RelationshipResponseProto> sort(
      Flux<RelationshipResponseProto> relationshipResponseProtos,
      SortType sortType
  ) {
    switch (sortType) {
      case LEVEL -> {
        return relationshipResponseProtos
            .sort(
                Comparator.<RelationshipResponseProto, Integer>comparing(
                        relationshipResponseProto ->
                            Optional.ofNullable(relationshipResponseProto)
                                .map(RelationshipResponseProto::getLevelInformation)
                                .map(LevelInformationProto::getLevel)
                                .orElse(0)
                    )
                    .reversed()
            );
      }
      default -> {
        return relationshipResponseProtos
            .sort(
                Comparator.comparing(relationshipResponseProto ->
                    Optional.ofNullable(relationshipResponseProto)
                        .map(RelationshipResponseProto::getNickname)
                        .orElse("")
                )
            );
      }
    }
  }

  public static Command<Mono<Relationship>, RelationshipRepository> getBySequence(
      String userSequence,
      String sequence,
      YnType useYn
  ) {
    return new RelationshipFindOneByUserSequenceAndSequenceAndUseYnCommand(
        userSequence,
        sequence,
        useYn
    );
  }

  public static Command<Flux<Relationship>, CustomRelationshipRepository> getByNicknameKeyword(
      String userSequence,
      String nicknameKeyword,
      YnType useYn
  ) {
    return new RelationshipFindAllByUserSequenceAndNicknameKeywordAndUseYnCommand(
        userSequence,
        nicknameKeyword,
        useYn
    );
  }

  public static Command<Mono<Relationship>, RelationshipRepository> create(Relationship relationship) {
    return new RelationshipSaveOneCommand(relationship);
  }

  public static Command<Mono<Relationship>, RelationshipRepository> update(Relationship relationship) {
    return new RelationshipSaveOneCommand(relationship);
  }

  public static Command<Flux<Relationship>, RelationshipRepository> getByUserSequence(
      String userSequence,
      YnType useYn
  ) {
    return new RelationshipFindAllByUserSequenceAndUseYnCommand(userSequence, useYn);
  }
}
