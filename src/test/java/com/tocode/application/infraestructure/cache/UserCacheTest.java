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
* File name: UserCacheTest.java
* Original Author: gonzalezsal
* Creation Date: 25 sept 2025
* --------------------------------------------------------------------------------------------------
*/
package com.tocode.application.infraestructure.cache;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import com.tocode.application.entrypoints.api.dto.UserDto;

/**
 * <code>UserCacheTest</code>.
 *
 * @author gonzalezsal
 * @version 1.0
 */
class UserCacheTest {

  /**
   * Should keep max 20 users in cache.
   */
  @Test
  void shouldKeepMax20UsersInCache() {
    UserCache cache = new UserCache();

    // Add 25 users, exceeding the capacity
    for (int i = 1; i <= 25; i++) {
      UserDto user = new UserDto();
      user.setUserName("user" + i);
      cache.setUser(user);
    }

    // The first 5 users should have been evicted
    for (int i = 1; i <= 5; i++) {
      assertNull(cache.getUser("user" + i), "Oldest user should be evicted");
    }

    // The last 20 users should be present
    for (int i = 6; i <= 25; i++) {
      assertNotNull(cache.getUser("user" + i), "Recent user should be present");
    }
  }
}
