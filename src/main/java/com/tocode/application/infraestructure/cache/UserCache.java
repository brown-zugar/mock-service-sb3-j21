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
* File name: UserCache.java
* Original Author: gonzalezsal
* Creation Date: 25 sept 2025
* --------------------------------------------------------------------------------------------------
*/

package com.tocode.application.infraestructure.cache;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.tocode.application.entrypoints.api.dto.UserDto;

/**
 * <code>UserCache</code>.
 *
 * @author gonzalezsal
 * @version 1.0
 */
@Component()
@Scope("singleton")
public class UserCache {
  
  /** The constant CAPACITY. */
  private static final int CAPACITY = 20;

  /** The constant userMapCache. */
  private final Map<String, UserDto> userMapCache;
  
  /**
   * Creates a new instance of user cache.
   */
  public UserCache() {
    this.userMapCache = Collections.synchronizedMap(
      new LinkedHashMap<String, UserDto>(UserCache.CAPACITY, 0.75f, true) {
      /**
       * serialVersionUID
       */
      private static final long serialVersionUID = -5924568149107941800L;

      /**
       * Removes the eldest entry.
       *
       * @param eldest eldest
       * @return true, if the condition is satisfied.
       */
      @Override
      public boolean removeEldestEntry(Map.Entry<String, UserDto> eldest) {
        return size() > UserCache.CAPACITY;
      }
    });
  }
  
  /**
   * Set the user.
   *
   * @param user  user
   */
  public void setUser(UserDto user) {
    this.userMapCache.put(user.getUserName(), user);
  }
  
  /**
   * Gets the user.
   *
   * @param userName user name
   * @return user
   */
  public UserDto getUser(String userName) {
    return this.userMapCache.getOrDefault(userName, null);
  }
  
}
