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
* File name: UserMapperTest.java
* Original Author: gonzalezsal
* Creation Date: 25 sept 2025
* --------------------------------------------------------------------------------------------------
*/
package com.tocode.application.adapters.mappers;

import com.tocode.application.domain.model.User;
import com.tocode.application.entrypoints.api.dto.UserDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <code>UserMapperTest</code>.
 *
 * @author gonzalezsal
 * @version 1.0
 */
class UserMapperTest {

  /**
   * Test map to entity.
   */
  @Test
  void testMapToEntity() {
    UserDto dto = new UserDto(1L, "testuser", "ADMIN", 1, LocalDateTime.now());
    User user = UserMapper.mapToEntity(dto);
    assertEquals(dto.getId(), user.getId());
    assertEquals(dto.getUserName(), user.getUserName());
    assertEquals(dto.getRole(), user.getRole());
    assertEquals(dto.getStatus(), user.getEstatus());
    assertEquals(dto.getCreationDate(), user.getCreationDate());
  }

  /**
   * Test map to dto.
   */
  @Test
  void testMapToDto() {
    User user = new User();
    user.setId(2L);
    user.setUserName("anotheruser");
    user.setRole("USER");
    user.setEstatus(0);
    user.setCreationDate(LocalDateTime.now());
    UserDto dto = UserMapper.mapToDto(user);
    assertEquals(user.getId(), dto.getId());
    assertEquals(user.getUserName(), dto.getUserName());
    assertEquals(user.getRole(), dto.getRole());
    assertEquals(user.getEstatus(), dto.getStatus());
    assertEquals(user.getCreationDate(), dto.getCreationDate());
  }
}
