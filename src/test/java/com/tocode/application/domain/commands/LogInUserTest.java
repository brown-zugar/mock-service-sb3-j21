/* -------------------------------------------------------------------------------------------------
* Copyright (C) 2025 by Hitss. All rights reserved.  
* Hitss claims copyright in this computer program as an unpublished work,
* one or more versions of which were first used to provide services to  
* customers on the dates indicated in the foregoing notice. Claim of  
* copyright does not imply waiver of other rights.  
*  
* NOTICE OF PROPRIETARY RIGHTS  
*  
* This program is a confidential trade secret and the property of Hitss.  
* Use, examination, reproduction, disassembly, decompiling, transfer and/or  
* disclosure to others of all or any part of this software program are  
* strictly prohibited except by express written agreement with Hitss.  
* --------------------------------------------------------------------------------------------------
* File name: LogInUserTest.java
* Original Author: gonzalezsal
* Creation Date: 22 sept 2025
* --------------------------------------------------------------------------------------------------
*/
package com.tocode.application.domain.commands;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import com.tocode.application.adapters.mappers.UserMapper;
import com.tocode.application.domain.model.User;
import com.tocode.application.domain.port.UserPort;
import com.tocode.application.entrypoints.api.dto.UserDto;

/**
 * <code>LogInUserTest</code>.
 *
 * @author gonzalezsal
 * @version 1.0
 */
class LogInUserTest {
  
  
  /**
   * An implementation of <code>UserPort</code> for test purposes.
   * <code>UserAdapterForTest</code>.
   *
   * @author gonzalezsal
   * @version 1.0
   */
  private class UserAdapterForTest implements UserPort {
    
    private static final LocalDateTime NOW = LocalDateTime.now();

    /** user. */
    private User user = new User(
        "testuser",
        "$2a$10$/410aZ03vkxKQLv1oY9gJ.G8x7yjfO3b7VfcJpuGOmFN30/lTLxtq",
        "ADMIN", 1, NOW
        );
    
    /**
     * Gets the now.
     *
     * @return now
     */
    public static LocalDateTime getNow() {
      return NOW;
    }
    
    /** user dto. */
    private UserDto userDto = UserMapper.mapToDto(this.user);
    
    /**
     * Find by username.
     *
     * @param username username
     * @return optional
     */
    @Override
    public Optional<User> findByUsername(String username) {
      return Optional.of(this.user);
    }

    /**
     * Creates the user.
     *
     * @param userDto user dto
     * @return user
     */
    @Override
    public User createUser(UserDto userDto) {
      return this.user;
    }

    /**
     * Find all users.
     *
     * @return list
     */
    @Override
    public List<UserDto> findAllUsers() {
      return List.of(this.userDto);
    }
  }

  
  /** The constant userAdapter. */
  private final UserAdapterForTest userAdapter = new UserAdapterForTest();
  
  /** The constant logInUser. */
  private final LogInUser logInUser = new LogInUser(userAdapter);
  
  /**
   * Given a valid username and password
   * When the user exists and the password matches
   * Then the application should grant access.
   */
  @Test
  void shouldGrantAccess() {
    UserDto userDto = this.logInUser.grantAccess("testuser", "admin");
    assertThat(userDto).isNotNull();
    assertThat(userDto.getUserName()).isEqualTo("testuser");
    assertThat(userDto.getRole()).isEqualTo("ADMIN");
    assertThat(userDto.getStatus()).isEqualTo(1);
    assertThat(userDto.getCreationDate()).isEqualTo(UserAdapterForTest.getNow());
  }
}
