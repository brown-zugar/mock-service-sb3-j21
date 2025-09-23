package com.tocode.application.domain.port;

import java.util.List;
import java.util.Optional;
import com.tocode.application.domain.model.User;
import com.tocode.application.entrypoints.api.dto.UserDto;

public interface UserPort {
  Optional<User> findByUsername(String username);
  User createUser(UserDto userDto);
  List<UserDto> findAllUsers();
}
