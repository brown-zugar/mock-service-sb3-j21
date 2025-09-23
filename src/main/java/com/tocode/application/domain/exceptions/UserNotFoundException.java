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
* File name: UserNotFoundException.java
* Original Author: gonzalezsal
* Creation Date: 21 sept 2025
* --------------------------------------------------------------------------------------------------
*/
package com.tocode.application.domain.exceptions;

/**
 * <code>UserNotFoundException</code>.
 *
 * @author gonzalezsal
 * @version 1.0
 */
public class UserNotFoundException extends RuntimeException {
  
  /** serialVersionUID. */
  private static final long serialVersionUID = 6488081890852709043L;

  /**
   * Creates a new instance of user not found exception.
   *
   * @param message message
   */
  public UserNotFoundException(String message) {
    super(message);
  }

}
