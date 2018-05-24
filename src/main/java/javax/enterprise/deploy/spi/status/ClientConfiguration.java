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

import java.io.Serializable;
import javax.enterprise.deploy.spi.exceptions.ClientExecuteException;

/**
 * The ClientConfiguration object configures an Application
 * Client for execution by a deployment tool.  This class 
 * should resolve the settings for installing and running
 * the application client.
 */
/**
 * The ClientConfiguration object installs, configures and
 * executes an Application Client. This class resolves the 
 * settings for installing and running the application client.
 */
public interface ClientConfiguration extends Serializable
{
	/**
     * This method performs an exec and starts the 
     * application client running in another process.
     *
     * @throws ClientExecuteException when the configuration
     *         is incomplete.
     */
	public void execute() throws ClientExecuteException;
}
