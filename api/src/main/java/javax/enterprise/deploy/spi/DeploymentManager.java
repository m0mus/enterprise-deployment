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

package javax.enterprise.deploy.spi;

import javax.enterprise.deploy.spi.status.*;
import javax.enterprise.deploy.spi.exceptions.*;
import javax.enterprise.deploy.model.DeployableObject;
import javax.enterprise.deploy.shared.DConfigBeanVersionType;
import javax.enterprise.deploy.shared.ModuleType;
import java.io.File;
import java.io.InputStream;
import java.util.Locale;

import java.lang.Deprecated;

/**
 * The DeploymentManager object provides the core set
 * of functions a Jakarta EE platform must provide for Java EE
 * application deployment.  It provides server related
 * information, such as, a list of deployment targets,
 * and vendor unique runtime configuration information.
 */
public interface DeploymentManager {
    
    /**
     * Retrieve the list of deployment targets supported by
     * this DeploymentManager.
     *
     * @throws IllegalStateException is thrown when the method is
     *                    called when running in disconnected mode.
     * @return   A list of deployment Target designators the
     *           user may select for application deployment or 'null'
     *           if there are none.
     */
    public Target[] getTargets() throws IllegalStateException;
    
    
    /**
     * Retrieve the list of Jakarta EE application modules distributed
     * to the identified targets and that are currently running
     * on the associated server or servers.
     *
     * @param moduleType A predefined designator for a Jakarta EE
     *                   module type.
     *
     * @param targetList A list of deployment Target designators
     *                   the user wants checked for module run
     *                   status.
     *
     * @return An array of TargetModuleID objects representing
     *                   the running modules or 'null' if there
     *                   are none.
     *
     * @throws IllegalStateException is thrown when the method is
     *                    called when running in disconnected mode.
     * @throws TargetException An invalid Target designator
     *                   encountered.
     */
    public TargetModuleID[] getRunningModules(ModuleType moduleType,
            Target[] targetList) throws TargetException,
            IllegalStateException;
    
    /**
     * Retrieve the list of Jakarta EE application modules distributed
     * to the identified targets and that are currently not
     * running on the associated server or servers.
     *
     * @param moduleType A predefined designator for a Jakarta EE
     *                   module type.
     *
     * @param targetList A list of deployment Target designators
     *                   the user wants checked for module not
     *                   running status.
     *
     * @return An array of TargetModuleID objects representing
     *                   the non-running modules or 'null' if
     *                   there are none.
     *
     * @throws IllegalStateException is thrown when the method is
     *                    called when running in disconnected mode.
     * @throws TargetException An invalid Target designator
     *                   encountered.
     */
    public TargetModuleID[] getNonRunningModules(ModuleType moduleType,
            Target[] targetList) throws TargetException,
            IllegalStateException;
    
    /**
     * Retrieve the list of all Jakarta EE application modules running
     * or not running on the identified targets.
     *
     * @param moduleType A predefined designator for a Jakarta EE
     *                   module type.
     *
     * @param targetList A list of deployment Target designators
     *                   the user wants checked for module not
     *                   running status.
     *
     * @return An array of TargetModuleID objects representing
     *                   all deployed modules running or not or
     *                   'null' if there are no deployed modules.
     *
     * @throws IllegalStateException is thrown when the method is
     *                    called when running in disconnected mode.
     * @throws TargetException An invalid Target designator
     *                   encountered.
     */
    public TargetModuleID[] getAvailableModules(ModuleType moduleType,
            Target[] targetList) throws TargetException,
            IllegalStateException;
    
    /**
     * Retrieve the object that provides server-specific deployment
     * configuration information for the Jakarta EE deployable component.
     *
     * @param dObj An object representing a Jakarta EE deployable component.
     * @throws InvalidModuleException The DeployableObject is an
     *                      unknown or unsupport component for this
     *                      configuration tool.
     */
    
    public DeploymentConfiguration createConfiguration(DeployableObject dObj)
    throws InvalidModuleException;
    
    
    /**
     * The distribute method performs three tasks; it validates the
     * deployment configuration data, generates all container specific
     * classes and interfaces, and moves the fully baked archive to
     * the designated deployment targets.
     *
     * @param targetList   A list of server targets the user is specifying
     *                     this application be deployed to.
     * @param moduleArchive The file name of the application archive
     *                      to be disrtibuted.
     * @param deploymentPlan The XML file containing the runtime
     *                       configuration information associated with
     *                       this application archive.
     * @throws IllegalStateException is thrown when the method is
     *                    called when running in disconnected mode.
     * @return ProgressObject an object that tracks and reports the
     *                       status of the distribution process.
     */
    
    public ProgressObject distribute(Target[] targetList,
            File moduleArchive, File deploymentPlan)
            throws IllegalStateException;
    
    /**
     * The distribute method performs three tasks; it validates the
     * deployment configuration data, generates all container specific
     * classes and interfaces, and moves the fully baked archive to
     * the designated deployment targets.
     *
     * @param targetList   A list of server targets the user is specifying
     *                     this application be deployed to.
     * @param moduleArchive The input stream containing the application
     *                      archive to be disrtibuted.
     * @param deploymentPlan The input stream containing the deployment
     *                       configuration information associated with
     *                       this application archive.
     * @throws IllegalStateException is thrown when the method is
     *                    called when running in disconnected mode.
     * @return ProgressObject an object that tracks and reports the
     *                       status of the distribution process.
     * @deprecated as of Java EE 5, replaced with {@link #distribute(Target[], ModuleType, InputStream, InputStream)}
     */
    
    public ProgressObject distribute(Target[] targetList,
            InputStream moduleArchive, InputStream deploymentPlan)
            throws IllegalStateException;
    
    /**
     * The distribute method performs three tasks; it validates the
     * deployment configuration data, generates all container specific
     * classes and interfaces, and moves the fully baked archive to
     * the designated deployment targets.
     *
     * @param targetList   A list of server targets the user is specifying
     *                     this application be deployed to.
     * @param type   The module type of this application archive.
     * @param moduleArchive The input stream containing the application
     *                      archive to be disrtibuted.
     * @param deploymentPlan The input stream containing the deployment
     *                       configuration information associated with
     *                       this application archive.
     * @throws IllegalStateException is thrown when the method is
     *                    called when running in disconnected mode.
     * @return ProgressObject an object that tracks and reports the
     *                       status of the distribution process.
     *
     */
    
    public ProgressObject distribute(Target[] targetList, ModuleType type,
            InputStream moduleArchive, InputStream deploymentPlan)
            throws IllegalStateException;    
    
    /**
     * Start the application running.
     *
     * <p> Only the TargetModuleIDs which represent a root module
     * are valid for being started. A root TargetModuleID has no parent.
     * A TargetModuleID with a parent can not be individually started.
     * A root TargetModuleID module and all its child modules will be
     * started.
     *
     * @param moduleIDList  A array of TargetModuleID objects
     *                    representing the modules to be started.
     * @throws IllegalStateException is thrown when the method is
     *                    called when running in disconnected mode.
     * @return ProgressObject an object that tracks and reports the
     *                       status of the start operation.
     */
    
    public ProgressObject start(TargetModuleID[] moduleIDList)
    throws IllegalStateException;
    
    /**
     * Stop the application running.
     *
     * <p> Only the TargetModuleIDs which represent a root module
     * are valid for being stopped. A root TargetModuleID has no parent.
     * A TargetModuleID with a parent can not be individually stopped.
     * A root TargetModuleID module and all its child modules will be
     * stopped.
     *
     * @param moduleIDList  A array of TargetModuleID objects
     *                    representing the modules to be stopped.
     * @throws IllegalStateException is thrown when the method is
     *                    called when running in disconnected mode.
     * @return ProgressObject an object that tracks and reports the
     *                       status of the stop operation.
     */
    
    public ProgressObject stop(TargetModuleID [] moduleIDList)
    throws IllegalStateException;
    
    /**
     * Remove the application from the target server.
     *
     * <p> Only the TargetModuleIDs which represent a root module
     * are valid for undeployment. A root TargetModuleID has no parent.
     * A TargetModuleID with a parent can not be undeployed. A root
     * TargetModuleID module and all its child modules will be undeployed.
     * The root TargetModuleID module and all its child modules must
     * stopped before they can be undeployed.
     *
     * @param moduleIDList An array of TargetModuleID objects representing
     *                   the root modules to be stopped.
     * @throws IllegalStateException is thrown when the method is
     *                    called when running in disconnected mode.
     * @return ProgressObject an object that tracks and reports the
     *                       status of the stop operation.
     */
    
    public ProgressObject undeploy(TargetModuleID[] moduleIDList)
    throws IllegalStateException;
    
    /**
     * This method designates whether this platform vendor provides
     * application redeployment functionality. A value of true means
     * it is supported.  False means it is not.
     *
     * @return A value of true means redeployment is supported by this
     *                   vendor's DeploymentManager.  False means it
     *                   is not.
     */
    public boolean isRedeploySupported();
    
    /**
     * (optional)
     * The redeploy method provides a means for updating currently
     * deployed Jakarta EE applications.  This is an optional method for
     * vendor implementation.
     *
     * Redeploy replaces a currently deployed application with an
     * updated version.  The runtime configuration information for
     * the updated application must remain identical to the application
     * it is updating.
     *
     * When an application update is redeployed, all existing client
     * connections to the original running application must not be disrupted;
     * new clients will connect to the application update.
     *
     * This operation is valid for TargetModuleIDs that represent a
     * root module. A root TargetModuleID has no parent. A root
     * TargetModuleID module and all its child modules will be redeployed.
     * A child TargetModuleID module cannot be individually redeployed.
     * The redeploy operation is complete only when this action for
     * all the modules has completed.
     *
     * @param moduleIDList An array of designators of the applications
     *                      to be updated.
     * @param moduleArchive The file name of the application archive
     *                      to be disrtibuted.
     * @param deploymentPlan The deployment configuration information
     *                       associated with this application archive.
     * @return ProgressObject an object that tracks and reports the
     *                       status of the redeploy operation.
     * @throws IllegalStateException is thrown when the method is
     *                    called when running in disconnected mode.
     * @throws java.lang.UnsupportedOperationException this optional command
     *         is not supported by this implementation.
     */
    
    public ProgressObject redeploy(TargetModuleID[] moduleIDList,
            File moduleArchive, File deploymentPlan)
            throws java.lang.UnsupportedOperationException,
            IllegalStateException;
    
    /**
     * (optional)
     * The redeploy method provides a means for updating currently
     * deployed Jakarta EE applications.  This is an optional method for
     * vendor implementation.
     *
     * Redeploy replaces a currently deployed application with an
     * updated version.  The runtime configuration information for
     * the updated application must remain identical to the application
     * it is updating.
     *
     * When an application update is redeployed, all existing client
     * connections to the original running application must not be disrupted;
     * new clients will connect to the application update.
     *
     * This operation is valid for TargetModuleIDs that represent a
     * root module. A root TargetModuleID has no parent. A root
     * TargetModuleID module and all its child modules will be redeployed.
     * A child TargetModuleID module cannot be individually redeployed.
     * The redeploy operation is complete only when this action for
     * all the modules has completed.
     *
     * @param moduleIDList An array of designators of the applications
     *                      to be updated.
     * @param moduleArchive The input stream containing the application
     *                      archive to be disrtibuted.
     * @param deploymentPlan The input stream containing the runtime
     *                       configuration information associated with
     *                       this application archive.
     * @return ProgressObject an object that tracks and reports the
     *                       status of the redeploy operation.
     * @throws IllegalStateException is thrown when the method is
     *                    called when running in disconnected mode.
     * @throws java.lang.UnsupportedOperationException this optional command
     *         is not supported by this implementation.
     */
    
    public ProgressObject redeploy(TargetModuleID[] moduleIDList,
            InputStream moduleArchive, InputStream deploymentPlan)
            throws java.lang.UnsupportedOperationException,
            IllegalStateException;
    
    
    
    /**
     * The release method is the mechanism by which the tool signals
     * to the DeploymentManager that the tool does not need it to
     * continue running connected to the platform.
     *
     * The tool may be signaling it wants to run in a disconnected
     * mode or it is planning to shutdown.
     *
     * When release is called the DeploymentManager may close any
     * Jakarta EE resource connections it had for deployment configuration
     * and perform other related resource cleanup.  It should not
     * accept any new operation requests (i.e., distribute, start
     * stop, undeploy, redeploy.  It should finish any operations
     * that are currently in process.  Each ProgressObject associated
     * with a running operation should be marked as released (see
     * the ProgressObject).
     *
     */
    
    public void release();
    
    /**
     * Returns the default locale supported by this implementation of
     * javax.enterprise.deploy.spi subpackages.
     *
     * @return Locale the default locale for this implementation.
     */
    public Locale getDefaultLocale();
    
    /**
     * Returns the active locale this implementation of
     * javax.enterprise.deploy.spi subpackages is running.
     *
     * @return Locale the active locale of this implementation.
     */
    public Locale getCurrentLocale();
    
    /**
     * Set the active locale for this implementation of
     * javax.enterprise.deploy.spi subpackages to run.
     *
     * @throws java.lang.UnsupportedOperationException the provide locale is
     *      not supported.
     */
    public void setLocale(Locale locale)
        throws java.lang.UnsupportedOperationException;
    
    /**
     * Returns an array of supported locales for this implementation.
     *
     * @return Locale[] the list of supported locales.
     */
    public Locale[] getSupportedLocales();
    
    /**
     * Reports if this implementation supports the designated locale.
     *
     * @return  A value of 'true' means it is support and 'false' it is
     *      not.
     */
    public boolean isLocaleSupported(Locale locale);
    
    /**
     * Returns the Jakarta EE platform version number for which the
     * configuration beans are provided.  The beans must have
     * been compiled with the J2SE version required by the Jakarta EE
     * platform.
     *
     * @return a DConfigBeanVersionType object representing the
     * platform version number for which these beans are provided.
     */
    public DConfigBeanVersionType getDConfigBeanVersion();
    
    /**
     * Returns 'true' if the configuration beans support the Jakarta EE platform
     * version specified.  It returns 'false' if the version is
     * not supported.
     *
     * @param version a DConfigBeanVersionType object representing the
     *	Jakarta EE platform version for which support is requested.
     * @return 'true' if the version is supported and 'false if not.
     */
    public boolean isDConfigBeanVersionSupported(DConfigBeanVersionType version);
    
    /**
     * Set the configuration beans to be used to the Jakarta EE platform
     * version specificed.
     *
     * @param version a DConfigBeanVersionType object representing the
     * Jakarta EE platform version for which support is requested.
     * @throws DConfigBeanVersionUnsupportedException when the
     *        requested bean version is not supported.
     */
    public void setDConfigBeanVersion(DConfigBeanVersionType version) throws
            DConfigBeanVersionUnsupportedException;
}
