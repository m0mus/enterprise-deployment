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

package javax.enterprise.deploy.model;

/**
 * An interface for beans that represent a fragment of a 
 * standard deployment descriptor.  A link is provided to 
 * the Jakarta EE application that includes this bean.
 */
public interface DDBean 
{
    
    /**
     * Returns the original xpath string provided by the DConfigBean.
     * @return The XPath of this Bean.
     */    
    public String getXpath();
    
    /**
     * Returns the XML text for by this bean.
     * @return The XML text for this Bean.
     */    
	public String getText();

    /**
     * Returns a tool-specific reference for attribute ID on an 
     * element in the deployment descriptor.  This attribute is 
     * defined for J2EE 1.2 and 1.3 components.
     * @return The XML text for this Bean or 'null' if
     *            no attribute was specifed with the tag.
     */    
	public String getId();
   
   /**
    * Return the root element for this DDBean.
    * @return The DDBeanRoot at the root of this DDBean
    * tree.
    */   
   public DDBeanRoot getRoot();
      
   /**
    * Return a list of DDBeans based upon the XPath.
    * @param xpath An XPath string referring to a location in the
    * same deployment descriptor as this standard bean.
    * @return a list of DDBeans or 'null' if no matching XML data is
    *            found. 
    */   
   public DDBean[] getChildBean(String xpath);
   
   /**
    * Return a list of text values for a given XPath in the
    * deployment descriptor.
    * @param xpath An XPath.
    * @return The list text values for this XPath or 'null'
    *     if no matching XML data is found.
    */   
   public String[] getText(String xpath);
   
   /**
    * Register a listener for a specific XPath.
    *
    * @param xpath The XPath this listener is to be registered for.
    * @param xpl The listener object.
    */
   public void addXpathListener(String xpath, XpathListener xpl);

   /**
    * Unregister a listener for a specific XPath.
    *
    * @param xpath The XPath from which this listener is to be
    *          unregistered.
    * @param xpl The listener object.
    */
   public void removeXpathListener(String xpath, XpathListener xpl);

    /** 
     * Returns the list of attribute names associated with the XML element. 
     *
     * @return a list of attribute names on this element.  Null 
     * is returned if there are no attributes. 
     */ 
   public String[] getAttributeNames(); 

    /**
     * Returns the string value of the named attribute. 
     *
     * @return a the value of the attribute.  Null is returned 
     * if there is no such attribute. 
     */ 
   public String getAttributeValue(String attrName); 
}

