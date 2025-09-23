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
* File name: Bcrypt.java
* Original Author: gonzalezsal
* Creation Date: 21 sept 2025
* --------------------------------------------------------------------------------------------------
*/
package com.tocode.application.infraestructure.security;

import org.mindrot.jbcrypt.BCrypt;

public class Bcrypt {
  
  /**
   * Creates a new instance of bcrypt.
   */
  private Bcrypt() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * Hash password.
   *
   * @param plainPassword plain password
   * @return string
   */
  public static final String hashPassword(String plainPassword) {
    return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
  }
  
  /**
   * Validate password.
   *
   * @param plainPassword plain password
   * @param bcryptHash bcrypt hash
   * @return true, if the condition is satisfied.
   */
  public static final boolean validatePassword(String plainPassword, String bcryptHash) {
    return BCrypt.checkpw(plainPassword, bcryptHash);
  }
}
