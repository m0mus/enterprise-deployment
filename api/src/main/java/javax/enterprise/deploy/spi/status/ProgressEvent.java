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

import javax.enterprise.deploy.spi.TargetModuleID;
import java.util.EventObject;

/**
 * An event which indicates that a deployment
 * status change has occurred.
 *
 * @see ProgressListener 
 * @see ProgressObject
 */
public class ProgressEvent extends EventObject
{
   transient private DeploymentStatus statuscode; // TODO fully implement Serializable if this is needed.
   transient private TargetModuleID targetModuleID;

   /**
    * Creates a new object representing a deployment
    * progress event.
    *
    * @param source the object on which the Event initially occurred.
    * @param sCode  the object containing the status 
    *               information.
    */
   public ProgressEvent (Object source, TargetModuleID targetModuleID,
             DeploymentStatus sCode)
   {
      super(source);
      this.statuscode = sCode;
      this.targetModuleID = targetModuleID;
   }

   /**
    * Retrieve the TargetModuleID for this event
    *
    * @return the object containing the TargetModuleID
    */ 
   public TargetModuleID getTargetModuleID()
   {
     return targetModuleID;
   }

   /**
    * Retrieve the status information.
    *
    * @return the object containing the status information.
    */
   public DeploymentStatus getDeploymentStatus()
   {
      return statuscode;
   }
}
