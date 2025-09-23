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
* File name: UserAdapter.java
* Original Author: gonzalezsal
* Creation Date: 20 sept 2025
* --------------------------------------------------------------------------------------------------
*/
package com.tocode.application.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import com.tocode.application.adapters.mappers.UserMapper;
import com.tocode.application.domain.model.User;
import com.tocode.application.domain.port.UserPort;
import com.tocode.application.entrypoints.api.dto.UserDto;
import com.tocode.application.infraestructure.persistance.UserRepository;

/**
 * <code>UserAdapter</code>.
 *
 * @author gonzalezsal
 * @version 1.0
 */
@Component
public class UserAdapter implements UserPort {

  /** user repository. */
  private UserRepository userRepository;
  
  /**
   * Creates a new instance of user adapter.
   *
   * @param userRepository user repository
   */
  public UserAdapter(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  
  /**
   * Find by username.
   *
   * @param userName username
   * @return optional
   */
  @Override
  public Optional<User> findByUsername(String userName) {
    return userRepository.findByUserName(userName);
  }
  
  /**
   * Find all users.
   *
   * @return list
   */
  @Override
  public List<UserDto> findAllUsers() {
    return userRepository.findAll().stream().map(UserMapper::mapToDto).toList();
  }
  
  /**
   * Create user.
   *
   * @param userDto user dto
   * @return user
   */
  @Override
  public User createUser(UserDto userDto) {
    User user = UserMapper.mapToEntity(userDto);    
    return userRepository.saveAndFlush(user);
  }
  

}
