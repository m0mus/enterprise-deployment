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
import javax.enterprise.deploy.spi.exceptions.OperationUnsupportedException;

/**
 * The ProgressObject interface tracks and reports
 * the progress of the deployment activities,
 * distribute, start, stop, undeploy.  
 *
 * <p>This class has an <code> optional</code> cancel 
 * method.  The support of the cancel function can 
 * be tested by the isCancelSupported method.
 * </p>
 *
 * <p>The ProgressObject structure allows the
 * user the option of polling for status or to
 * provide a callback.
 * </p>
 */
public interface ProgressObject
{

   /**
    * Retrieve the status of this activity.
    *
    * @return An object containing the status
    *          information.
    */
   public DeploymentStatus getDeploymentStatus();


   /**
    * Retrieve the list of TargetModuleIDs successfully
    * processed or created by the associated DeploymentManager
    * operation. 
    *
    * @return a list of TargetModuleIDs.
    */
	public TargetModuleID [] getResultTargetModuleIDs();


   /**
    * Return the ClientConfiguration object associated with the
    * TargetModuleID.
    *
    * @return ClientConfiguration for a given TargetModuleID or 
    *         null if none exists.
    */
    public ClientConfiguration getClientConfiguration(TargetModuleID id); 


   /**
    * Tests whether the vendor supports a cancel 
    * opertation for deployment activities.
    *
    * @return <code>true</code> if canceling an
    *         activity is supported by this platform.
    */
   public boolean isCancelSupported();

   /**
    * (optional)
    * A cancel request on an in-process operation 
    * stops all further processing of the operation and returns
    * the environment to it original state before the operation
    * was executed.  An operation that has run to completion 
    * cannot be cancelled.
    *
    * @throws OperationUnsupportedException this optional command
    *         is not supported by this implementation.
    */
   public void cancel() throws OperationUnsupportedException;

   /**
    * Tests whether the vendor supports a stop
    * opertation for deployment activities.
    *
    * @return <code>true</code> if canceling an
    *         activity is supported by this platform.
    */
   public boolean isStopSupported();

   /**
    * (optional)
    * A stop request on an in-process operation allows the 
    * operation on the current TargetModuleID to run to completion but 
    * does not process any of the remaining unprocessed TargetModuleID 
    * objects.  The processed TargetModuleIDs must be returned by the 
    * method getResultTargetModuleIDs.
    *
    * @throws OperationUnsupportedException this optional command
    *         is not supported by this implementation.
    */
   public void stop() throws OperationUnsupportedException;

   /**
    * Add a listener to receive Progress events on deployment
    * actions.
    *
    * @param pol the listener to receive events
    * @see ProgressEvent 
    */
   public void addProgressListener(ProgressListener pol);

   /**
    * Remove a ProgressObject listener.
    *
    * @param pol the listener being removed
    * @see ProgressEvent 
    */
   public void removeProgressListener(ProgressListener pol);
}
