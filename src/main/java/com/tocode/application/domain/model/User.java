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
* File name: User.java
* Original Author: gonzalezsal
* Creation Date: 20 sept 2025
* --------------------------------------------------------------------------------------------------
*/

package com.tocode.application.domain.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * <code>User</code>.
 *
 * @author gonzalezsal
 * @version 1.0
 */
@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

  /** id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** username. */
  @Column(nullable = false, unique = true, length = 50, name = "user_name")
  private String userName;

  /** password. */
  @Column(nullable = false)
  private String password; // bcrypt hash

  /** role. */
  @Column(nullable = false, length = 10)
  private String role;

  /** estatus. */
  @Column(nullable = false)
  private Integer estatus;

  /** creation date. */
  @Column(nullable = false, name = "creation_date")
  private LocalDateTime creationDate;

  /**
   * Creates a new instance of user.
   */
  public User() {}

  /**
   * Creates a new instance of user.
   *
   * @param username username
   * @param password password
   * @param role role
   * @param estatus estatus
   * @param creationDate creation date
   */
  public User(String userName, String password, String role, Integer estatus,
      LocalDateTime creationDate) {
    this.userName = userName;
    this.password = password;
    this.role = role;
    this.estatus = estatus;
    this.creationDate = creationDate;
  }
}
