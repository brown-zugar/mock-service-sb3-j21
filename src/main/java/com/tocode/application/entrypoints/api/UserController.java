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
* File name: UserController.java
* Original Author: gonzalezsal
* Creation Date: 21 sept 2025
* --------------------------------------------------------------------------------------------------
*/
package com.tocode.application.entrypoints.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tocode.application.domain.commands.LogInUser;
import com.tocode.application.entrypoints.api.dto.LoginDto;
import com.tocode.application.entrypoints.api.dto.UserDto;
import jakarta.validation.Valid;

@RestController
public class UserController {

  /** log in user. */
  private LogInUser logInUser;

  /**
   * Creates a new instance of user controller.
   *
   * @param logInUser log in user
   */
  public UserController(LogInUser logInUser) {
    this.logInUser = logInUser;
  }

  /**
   * Login.
   *
   * @param loginDto login dto
   * @return response entity
   */
  @PostMapping("/login")
  public ResponseEntity<UserDto> login(@Valid @RequestBody LoginDto loginDto) {

    return ResponseEntity
        .ok(logInUser.grantAccess(loginDto.getUsername(), loginDto.getPassword()));
  }
}
