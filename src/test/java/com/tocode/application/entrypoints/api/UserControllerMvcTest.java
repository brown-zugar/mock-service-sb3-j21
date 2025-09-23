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
* File name: UserControllerMvcTest.java
* Original Author: gonzalezsal
* Creation Date: 21 sept 2025
* --------------------------------------------------------------------------------------------------
*/
package com.tocode.application.entrypoints.api;



import static org.hamcrest.CoreMatchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.tocode.application.entrypoints.api.dto.LoginDto;

/**
 * <code>UserControllerMvcTest</code>.
 *
 * @author gonzalezsal
 * @version 1.0
 */
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerMvcTest {

  /** mock mvc. */
  @Autowired
  private MockMvc mockMvc;

  /**
   * Given a user 
   * When login with credentials that do not fulfill the validation rules
   * Then Should validate login inputs
   * And return a 400 Bad Request with validation error messages.
   *
   * @throws Exception exception.
   */
  @Test
  void shouldReturnDefaultMessage() throws Exception {
    LoginDto loginDto = new LoginDto();
    loginDto.setUsername("ab"); // Invalid user_name (too short)
    loginDto.setPassword("12345"); // Invalid password (too short)
    
    this.mockMvc.perform(post("/login")
        .contentType("application/json")
        .content("{\"username\":\"ab\",\"password\":\"123\"}"))
        .andDo(print())
        .andExpect(status().isBadRequest())
        .andExpect(content()
            .string(containsString("Password must be between 5 and 20 characters")));
  }
}
