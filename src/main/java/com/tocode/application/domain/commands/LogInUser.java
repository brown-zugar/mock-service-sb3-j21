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
* File name: LogInUser.java
* Original Author: gonzalezsal
* Creation Date: 21 sept 2025
* --------------------------------------------------------------------------------------------------
*/
package com.tocode.application.domain.commands;

import org.springframework.stereotype.Service;
import com.tocode.application.adapters.mappers.UserMapper;
import com.tocode.application.domain.exceptions.GrantAccessException;
import com.tocode.application.domain.exceptions.UserNotFoundException;
import com.tocode.application.domain.port.UserPort;
import com.tocode.application.entrypoints.api.dto.UserDto;
import com.tocode.application.infraestructure.security.Bcrypt;

/**
 * <code>LogInUser</code>.
 *
 * @author gonzalezsal
 * @version 1.0
 */
@Service
public class LogInUser {

  private static final int IS_ACTIVE = 1;
  
  /** The constant userPort. */
  private final UserPort userPort;
  
  /**
   * Creates a new instance of log in user.
   *
   * @param userPort user port
   */
  public LogInUser(UserPort userPort) {
    this.userPort = userPort;
  }
  
  /**
   * Grant user access.
   *
   * @param userName user name
   * @param password password
   * @return user dto
   */
  public UserDto grantAccess(String userName, String password) {

    return this.userPort.findByUsername(userName).map(user -> {
      if (!Bcrypt.validatePassword(password, user.getPassword())
          || user.getEstatus() != IS_ACTIVE) {
        throw new GrantAccessException("Access denied");
      }
      return UserMapper.mapToDto(user);
    }).orElseThrow(() -> new UserNotFoundException("User not found"));
  }
}
