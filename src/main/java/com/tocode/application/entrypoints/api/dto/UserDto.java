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
* File name: UserDto.java
* Original Author: gonzalezsal
* Creation Date: 20 sept 2025
* --------------------------------------------------------------------------------------------------
*/
package com.tocode.application.entrypoints.api.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <code>UserDto</code>.
 *
 * @author gonzalezsal
 * @version 1.0
 */
@Getter
@Setter
public class UserDto {

  /** id. */
  private Long id;
  
  /** username. */
  private String userName;
  
  /** role. */
  private String role;
  
  /** status. */
  private Integer status;
  
  /** creation date. */
  private LocalDateTime creationDate;
  

  /**
   * Creates a new instance of user dto.
   */
  public UserDto() {
    super();
  }
  
  /**
   * Creates a new instance of user dto.
   *
   * @param id id
   * @param username username
   * @param role role
   * @param status status
   * @param creationDate creation date
   */
  public UserDto(Long id, String userName, String role, Integer status, LocalDateTime creationDate) {
    super();
    this.id = id;
    this.userName = userName;
    this.role = role;
    this.status = status;
    this.creationDate = creationDate;
  }  
}
