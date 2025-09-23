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
* File name: ApplationStarter.java
* Original Author: gonzalezsal
* Creation Date: 20 sept 2025
* --------------------------------------------------------------------------------------------------
*/

package com.tocode.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <code>ApplationStarter</code>.
 *
 * @author gonzalezsal
 * @version 1.0
 */
@SpringBootApplication
public class ApplicationStarter {

  /**
   * Execution initiation.
   *
   * @param args arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(ApplicationStarter.class, getParameters(args));
  }
  
  /**
   * Gets the parameters.
   *
   * @param args args
   * @return parameters
   */
  private static String[] getParameters(String[] args) {
    if (args == null || args.length == 0) {
      return new String[] { "--server.port=8080" };
    }
    return args;    
  }
}
