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
* File name: LoginDto.java
* Original Author: gonzalezsal
* Creation Date: 21 sept 2025
* --------------------------------------------------------------------------------------------------
*/
package com.tocode.application.entrypoints.api.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * <code>LoginDto</code>.
 *
 * @author gonzalezsal
 * @version 1.0
 */
@Getter
@Setter
public class LoginDto implements Serializable {
  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = 554645999786449513L;

  /** username. */
  @NotNull(message = "Username cannot be null")
  @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters")
  @JsonProperty(value="username", required = true)
  private String username;
  
  /** password. */
  @NotNull(message = "Password cannot be null")
  @Size(min = 5, max = 20, message = "Password must be between 5 and 20 characters")
  @JsonProperty(value = "password", required = true, access = JsonProperty.Access.WRITE_ONLY)
  private String password;
}
