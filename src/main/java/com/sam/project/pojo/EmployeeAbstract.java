/*
 * Copyright 2016 (c) Hubble Connected (HKT) Ltd. - All Rights Reserved
 *
 * Proprietary and confidential.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */

package com.sam.project.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeAbstract implements Serializable {

  /**
   * The Status.
   */
  Integer status;
  /**
   * The Message.
   */
  String message;

  /**
   * Instantiates a new User abstract.
   */
  public EmployeeAbstract() {

  }

  /**
   * Instantiates a new User abstract.
   *
   * @param status  the status
   * @param message the message
   */
  public EmployeeAbstract(Integer status, String message) {
    this.status = status;
    this.message = message;
  }

  /**
   * Gets status.
   *
   * @return the status
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * Sets status.
   *
   * @param status the status
   */
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * Gets message.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Sets message.
   *
   * @param message the message
   */
  public void setMessage(String message) {
    this.message = message;
  }
}
