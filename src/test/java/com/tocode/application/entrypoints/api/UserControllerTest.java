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
* File name: UserControllerTest.java
* Original Author: gonzalezsal
* Creation Date: 21 sept 2025
* --------------------------------------------------------------------------------------------------
*/
package com.tocode.application.entrypoints.api;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import com.tocode.application.entrypoints.api.dto.LoginDto;

/**
 * <code>UserControllerTest</code>.
 *
 * @author gonzalezsal
 * @version 1.0
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {
  
  /** user controller. */
  @Autowired
  private UserController userController;
  
  /** rest template. */
  @Autowired
  private TestRestTemplate restTemplate;
  
  /** port. */
  @LocalServerPort
  private int port;
  
  /** La constante BASE_URL. */
  private static final String BASE_URL = "http://localhost:";
  
  /** La constante LOGIN_URL. */
  private static final String LOGIN_URL = "/login";
  
  
  /**
   * Should load context.
   */
  //@Test
  void shouldLoadContext() {
    // Verify that the UserController bean is loaded in the application context
    assertThat(userController).isNotNull();
    // assert userController != null; // It is the same of the line above but SonarQube does not like it
  }
  
  

  /**
   * Given a user 
   * When login with credentials that do not fulfill the validation rules
   * Then Should validate login inputs
   * And return a 400 Bad Request with validation error messages.
   */
  //@Test
  void shouldValidateLoginInputs() {
    String url = BASE_URL + port + LOGIN_URL;
    LoginDto loginDto = new LoginDto();
    loginDto.setUsername("ab"); // Invalid username (too short)
    loginDto.setPassword("123"); // Invalid password (too short)
    
    assertThat(restTemplate.postForEntity(
          url, 
          loginDto, 
          String.class)
        .getStatusCode())
    .isEqualTo(HttpStatus.BAD_REQUEST);
  }
}
