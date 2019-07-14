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

package javax.enterprise.deploy.spi.factories;

import javax.enterprise.deploy.spi.DeploymentManager;
import javax.enterprise.deploy.spi.exceptions.DeploymentManagerCreationException;

/**
 * The DeploymentFactory interface is a deployment driver for a    
 * Jakarta EE plaform product.  It returns a DeploymentManager object
 * which represents a connection to a specific Jakarta EE platform
 * product.
 *
 * <p> Each application server vendor must provide an implementation 
 *  of this class in order for the Jakarta Deployment to work
 *  with their product.
 *
 * <p> The class implementing this interface should have a public
 * no-argument constructor, and it should be stateless (two instances
 * of the class should always behave the same).  It is suggested but
 * not required that the class have a static initializer that registers
 * an instance of the class with the DeploymentFactoryManager class.
 *
 * <p> A <tt>connected</tt> or <tt>disconnected</tt> DeploymentManager 
 * can be requested.  A DeploymentManager that runs connected to the 
 * platform can provide access to Jakarta EE resources. A DeploymentManager
 * that runs disconnected only provides module deployment configuration 
 * support. 
 *
 * @see javax.enterprise.deploy.shared.factories.DeploymentFactoryManager
 */
public interface DeploymentFactory 
{
    /**
     * Tests whether this factory can create a DeploymentManager
     * object based on the specificed URI.  This does not indicate
     * whether such an attempt will be successful, only whether the
     * factory can handle the uri. 
     * @param uri The uri to check
     * @return <tt>true</tt> if the factory can handle the uri.
     */
    public boolean handlesURI(String uri);

    /**
     * Return a <tt>connected</tt> DeploymentManager instance.
     *
     * @param uri The URI that specifies the connection parameters
     * @param username An optional username (may be <tt>null</tt> if
     *        no authentication is required for this platform).
     * @param password An optional password (may be <tt>null</yy> if
     *        no authentication is required for this platform).
     * @return A ready DeploymentManager instance.
     * @throws DeploymentManagerCreationException  occurs when a 
     *        DeploymentManager could not be returned (server down, 
     *        unable to authenticate, etc).
     */
    public DeploymentManager getDeploymentManager(String uri, 
            String username, String password) 
            throws DeploymentManagerCreationException;

    /**
     * Return a <tt>disconnected</tt> DeploymentManager instance. 
     *
     * @param uri the uri of the DeploymentManager to return.
     * @return A DeploymentManager <tt>disconnected</tt> instance.
     * @throws DeploymentManagerCreationException occurs if the 
     *         DeploymentManager could not be created.
     */
    public DeploymentManager getDisconnectedDeploymentManager(String uri) 
            throws DeploymentManagerCreationException;

    /**
     * Provide a string with the name of this vendor's DeploymentManager.
     * @return the name of the vendor's DeploymentManager.
     */
    public String getDisplayName();

    /**
     * Provide a string identifying version of this vendor's 
     * DeploymentManager.
     * @return the name of the vendor's DeploymentManager.
     */
    public String getProductVersion();
}
