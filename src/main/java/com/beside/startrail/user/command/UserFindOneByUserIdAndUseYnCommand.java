package com.beside.startrail.user.command;

import com.beside.startrail.common.command.Command;
import com.beside.startrail.common.type.YnType;
import com.beside.startrail.user.document.User;
import com.beside.startrail.user.document.UserId;
import com.beside.startrail.user.repository.UserRepository;
import reactor.core.publisher.Mono;

public class UserFindOneByUserIdAndUseYnCommand implements Command<Mono<User>, UserRepository> {
  private final UserId userId;
  private final YnType useYn;

  private Mono<User> result;

  public UserFindOneByUserIdAndUseYnCommand(UserId userId, YnType useYn) {
    this.userId = userId;
    this.useYn = useYn;
  }

  @Override
  public Mono<User> execute(UserRepository userRepository) {
    result = userRepository.findByUserIdAndUseYn(userId, useYn);

    return result;
  }
}
