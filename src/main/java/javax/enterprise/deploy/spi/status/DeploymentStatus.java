/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package javax.enterprise.deploy.spi.status;

import javax.enterprise.deploy.shared.StateType;
import javax.enterprise.deploy.shared.CommandType;
import javax.enterprise.deploy.shared.ActionType;

/**
 * The DeploymentStatus interface provides information about
 * the progress status of a deployment action.
 */
public interface DeploymentStatus
{
   /**
    * Retrieve the StateType value.
    *
    * @return the StateType object 
    */
   public StateType getState();

   /**
    * Retrieve the deployment CommandType of this event.
    *
    * @return the CommandType Object
    */
   public CommandType getCommand();

   /**
    * Retrieve the deployment ActionType for this event.
    *
    * @return the ActionType Object
    */
   public ActionType getAction();

   /**
    * Retrieve any additional information about the
    * status of this event.
    *
    * @return message text
    */
   public String getMessage();

   /**
    * A convience method to report if the operation is
    * in the completed state.
    *
    * @return true if this command has completed successfully 
    */
   public boolean isCompleted();

   /**
    * A convience method to report if the operation is
    * in the failed state.
    *
    * @return true if this command has failed 
    */
   public boolean isFailed();

   /**
    * A convience method to report if the operation is
    * in the running state.
    *
    * @return true if this command is still running
    */
   public boolean isRunning();
}
