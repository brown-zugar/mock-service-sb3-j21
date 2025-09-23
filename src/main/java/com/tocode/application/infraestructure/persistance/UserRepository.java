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
* File name: UserRepository.java
* Original Author: gonzalezsal
* Creation Date: 20 sept 2025
* --------------------------------------------------------------------------------------------------
*/

package com.tocode.application.infraestructure.persistance;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tocode.application.domain.model.User;

/**
 * <code>UserRepository</code>.
 *
 * @author gonzalezsal
 * @version 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  
  /**
   * Find by username.
   *
   * @param username username
   * @return optional
   */
  Optional<User> findByUserName(String userName);
  
  /**
   * Save and flush.
   *
   * @param <S> generic type
   * @param user user
   * @return user
   */
  <S extends User> S saveAndFlush(S entity);
}
