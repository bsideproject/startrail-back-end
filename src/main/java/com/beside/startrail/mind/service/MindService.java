package com.beside.startrail.mind.service;

import com.beside.startrail.common.type.YnType;
import com.beside.startrail.mind.command.MindCountByRelationshipSequenceAndUseYnCommand;
import com.beside.startrail.mind.command.MindCountByUserSequenceAndUseYnCommand;
import com.beside.startrail.mind.command.MindFindAllByRelationshipSequenceCommand;
import com.beside.startrail.mind.command.MindFindAllByRelationshipSequenceWithOrderCommand;
import com.beside.startrail.mind.command.MindFindOneBySequenceCommand;
import com.beside.startrail.mind.command.MindSaveAllCommand;
import com.beside.startrail.mind.command.MindSaveOneCommand;
import com.beside.startrail.mind.document.Mind;
import com.beside.startrail.mind.type.SortOrderType;
import java.util.List;

public class MindService {
  public static MindCountByUserSequenceAndUseYnCommand countByUserSequenceAndUseYn(
      String userSequence,
      YnType useYn
  ) {
    return new MindCountByUserSequenceAndUseYnCommand(userSequence, useYn);
  }

  public static MindCountByRelationshipSequenceAndUseYnCommand countByRelationshipSequenceAndUseYn(
      String userSequence,
      YnType useYn
  ) {
    return new MindCountByRelationshipSequenceAndUseYnCommand(userSequence, useYn);
  }

  public static MindFindAllByRelationshipSequenceWithOrderCommand getByRelationshipSequenceWithOrder(
      String relationshipSequence,
      SortOrderType sortOrderType
  ) {
    return new MindFindAllByRelationshipSequenceWithOrderCommand(
        relationshipSequence,
        sortOrderType.getSort("date")
    );
  }

  public static MindFindAllByRelationshipSequenceCommand getByRelationshipSequence(
      String relationshipSequence
  ) {
    return new MindFindAllByRelationshipSequenceCommand(
        relationshipSequence
    );
  }

  public static MindFindOneBySequenceCommand getBySequence(String sequence) {
    return new MindFindOneBySequenceCommand(sequence);
  }

  public static MindSaveAllCommand create(List<Mind> minds) {
    return new MindSaveAllCommand(minds);
  }

  public static MindSaveOneCommand update(Mind mind) {
    return new MindSaveOneCommand(mind);
  }
}
