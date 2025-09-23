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
* File name: GrantAccessException.java
* Original Author: gonzalezsal
* Creation Date: 21 sept 2025
* --------------------------------------------------------------------------------------------------
*/
package com.tocode.application.domain.exceptions;

/**
 * <code>GrantAccessException</code>.
 *
 * @author gonzalezsal
 * @version 1.0
 */
public class GrantAccessException extends RuntimeException {

  /** serialVersionUID. */
  private static final long serialVersionUID = 2452402349106652148L;

  /**
   * Creates a new instance of grant access exception.
   *
   * @param message message
   */
  public GrantAccessException(String message) {
    super(message);
  }

}
