/*
 * -------------------------------------------------------------------------------------------------
 * Copyright (C) 2025 by Hitss. All rights reserved. Hitss claims copyright in this computer program
 * as an unpublished work, one or more versions of which were first used to provide services to
 * customers on the dates indicated in the foregoing notice. Claim of copyright does not imply
 * waiver of other rights.
 * 
 * NOTICE OF PROPRIETARY RIGHTS
 * 
 * This program is a confidential trade secret and the property of Hitss. Use, examination,
 * reproduction, disassembly, decompiling, transfer and/or disclosure to others of all or any part
 * of this software program are strictly prohibited except by express written agreement with Hitss.
 * -------------------------------------------------------------------------------------------------
 * - File name: GlobalExceptionHandler.java Original Author: gonzalezsal Creation Date: 21 sept 2025
 * -------------------------------------------------------------------------------------------------
 * -
 */
package com.tocode.application.entrypoints.api.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.tocode.application.domain.exceptions.GrantAccessException;
import com.tocode.application.domain.exceptions.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * <code>GlobalExceptionHandler</code>.
 *
 * @author gonzalezsal
 * @version 1.0
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  /**
   * Handle validation errors.
   *
   * @param ex the exception
   * @return response entity with validation errors
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
    
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getFieldErrors()
        .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

    log.error("Validation errors: {}", errors);
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }

  /**
   * Handle user not found.
   *
   * @param ex ex
   * @return response entity
   */
  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex,
      HttpServletRequest request) {
    log.error("User [{}] not found: {}", request.getAttribute("username"), ex.getMessage());
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

  /**
   * Handle grant access.
   *
   * @param ex ex
   * @return response entity
   */
  @ExceptionHandler(GrantAccessException.class)
  public ResponseEntity<String> handleGrantAccess(GrantAccessException ex,
      HttpServletRequest request) {
    log.error("User [{}] not authorized: {}", request.getAttribute("username"), ex.getMessage());
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
  }
}
