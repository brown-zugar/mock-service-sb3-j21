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
* File name: UserMapper.java
* Original Author: gonzalezsal
* Creation Date: 21 sept 2025
* --------------------------------------------------------------------------------------------------
*/
package com.tocode.application.adapters.mappers;

import com.tocode.application.domain.model.User;
import com.tocode.application.entrypoints.api.dto.UserDto;

/**
 * <code>UserMapper</code>.
 *
 * @author gonzalezsal
 * @version 1.0
 */
public class UserMapper {

  /**
   * Creates a new instance of user mapper.
   */
  private UserMapper() {
    throw new IllegalStateException("Utility class");
  }
  
  /**
   * Map to entity.
   *
   * @param userDto user dto
   * @return user
   */
  public static final User mapToEntity(UserDto userDto) {
    User user = new User();
    user.setId(userDto.getId());
    user.setUserName(userDto.getUserName());
    user.setRole(userDto.getRole());
    user.setEstatus(userDto.getStatus());
    user.setCreationDate(userDto.getCreationDate());
    return user;
  }
  
  /**
   * Map to dto.
   *
   * @param user user
   * @return user dto
   */
  public static final UserDto mapToDto(User user) {
    return new UserDto(
        user.getId(), 
        user.getUserName(), 
        user.getRole(), 
        user.getEstatus(), 
        user.getCreationDate());
  }  
}
