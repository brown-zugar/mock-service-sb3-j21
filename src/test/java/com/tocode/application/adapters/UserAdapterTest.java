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
* File name: UserAdapterTest.java
* Original Author: gonzalezsal
* Creation Date: 22 sept 2025
* --------------------------------------------------------------------------------------------------
*/
package com.tocode.application.adapters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.tocode.application.adapters.mappers.UserMapper;
import com.tocode.application.domain.model.User;
import com.tocode.application.entrypoints.api.dto.UserDto;
import com.tocode.application.infraestructure.persistance.UserRepository;

/**
 * <code>UserAdapterTest</code>.
 *
 * @author gonzalezsal
 * @version 1.0
 */
class UserAdapterTest {

  /** user adapter. */
  private UserAdapter userAdapter;
  
  /** user repository. */
  private UserRepository userRepository;
  
  /**
   * Sets the up.
   */
  @BeforeEach
  void setUp() {
    userRepository = Mockito.mock(UserRepository.class);
    userAdapter = new UserAdapter(userRepository);
  }
  
  /**
   * Test find by username.
   */
  @Test
  void testFindByUsername() {
      User user = new User();
      when(userRepository.findByUserName("testuser")).thenReturn(Optional.of(user));
      Optional<User> result = userAdapter.findByUsername("testuser");
      assertTrue(result.isPresent());
      assertEquals(user, result.get());
  }

  /**
   * Test find all users.
   */
  @Test
  void testFindAllUsers() {
      User user = new User();
      UserDto userDto = new UserDto();
      when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
      try (var mocked = Mockito.mockStatic(UserMapper.class)) {
          mocked.when(() -> UserMapper.mapToDto(user)).thenReturn(userDto);
          List<UserDto> result = userAdapter.findAllUsers();
          assertNotNull(result);
          assertEquals(1, result.size());
          assertEquals(userDto, result.get(0));
      }
  }

  /**
   * Test create user.
   */
  @Test
  void testCreateUser() {
      UserDto userDto = new UserDto();
      User user = new User();
      try (var mocked = Mockito.mockStatic(UserMapper.class)) {
          mocked.when(() -> UserMapper.mapToEntity(userDto)).thenReturn(user);
          when(userRepository.saveAndFlush(user)).thenReturn(user);
          User result = userAdapter.createUser(userDto);
          assertNotNull(result);
          assertEquals(user, result);
      }
  }
}
