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

import java.beans.PropertyChangeEvent;

/**
 * An Event class describing ConfigBeans being added/subtracted
 * from a server configuration.
 */
public final class XpathEvent {

   private final DDBean bean;
   private final Object typ;
   private PropertyChangeEvent changeEvent;

   /**
    * Adding a DDBean
    */   
   public static final Object BEAN_ADDED = new Object();
   /**
    * Removing a DDBean
    */   
   public static final Object BEAN_REMOVED = new Object();
   /**
    * Changing a DDBean
    */
   public static final Object BEAN_CHANGED = new Object();

   /**
    * A description of a change in the ConfigBean tree.
    * @param bean The ConfigBean being added/removed.
    * @param typ Indicates an add/remove event.
    */   
   public XpathEvent(DDBean bean, Object typ) {
       this.bean = bean; this.typ = typ;
       }

   public PropertyChangeEvent getChangeEvent() {
       if(typ == BEAN_CHANGED) return changeEvent;
       return null;
   }
   
   public void setChangeEvent(PropertyChangeEvent pce) {
       changeEvent = pce;
   }
   
       /**
        * The bean being added/removed/changed.
        * @return The bean being added/removed/changed.
        */       
   public DDBean getBean() {return bean;}

   /** Is this an add event?
    * @return true if this is an add event.
    */   
   public boolean isAddEvent() {return typ == BEAN_ADDED;}

   /** Is this a remove event?
    * @return true if this is a remove event.
    */   
   public boolean isRemoveEvent() {return typ == BEAN_REMOVED;}

   /** Is this a change event?
    * @return true if this is a change event.
    */   
   public boolean isChangeEvent() {return typ == BEAN_CHANGED;}

   }
