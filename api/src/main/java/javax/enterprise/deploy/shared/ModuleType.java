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

package javax.enterprise.deploy.shared;

/**
 * Class ModuleTypes defines enumeration values for the Jakarta EE
 * module types.
 *
 * @author Rebecca Searls
 */
public class ModuleType 
{
	private int value; // This enumeration value's int value

	/**
	 * The module is an EAR archive.
	 */
	public static final ModuleType EAR = new ModuleType(0);
	/**
	 * The module is an Enterprise Java Bean archive.
	 */
	public static final ModuleType EJB = new ModuleType(1);
	/**
	 * The module is an Client Application archive.
	 */
	public static final ModuleType CAR = new ModuleType(2);
	/**
	 * The module is an Connector archive.
	 */
	public static final ModuleType RAR = new ModuleType(3);
	/**
	 * The module is an Web Application archive.
	 */
	public static final ModuleType WAR = new ModuleType(4);


	private static final String[] stringTable = {
	"ear",
	"ejb",
	"car",
	"rar",
	"war",
	};

	private static final ModuleType[] enumValueTable = {
	EAR,
	EJB,
	CAR,
	RAR,
	WAR,
	};

	/*
	 *  Module extensions.
	 */
    private static final String[] moduleExtension = {
    ".ear",
	".jar",
	".jar",
	".rar",
	".war",
    };
        

    /**
     * Construct a new enumeration value with the given integer value.
     *
     * @param  value  Integer value.
     */
    protected ModuleType(int value)
    {   this.value = value;
    }
        
    /**
     * Returns this enumeration value's integer value.
     * @return the value
     */
    public int getValue() 
	{ 	return value;
    }

        
	/**
	 * Returns the string table for class ModuleType
	 */
	protected String[] getStringTable()
	{   return stringTable;
	}

	/**
	 * Returns the enumeration value table for class ModuleType
	 */
	protected ModuleType[] getEnumValueTable()
	{   return enumValueTable;
	}

	/**
     * Return the file extension string for this enumeration.
     */
    public String getModuleExtension()
    {   return (moduleExtension[getValue()]);
    }
    
	/**
     * Return an object of the specified value.
     * @param value a designator for the object.
     */
    public static ModuleType getModuleType(int value)
    {   return enumValueTable[value];
    }

	/**
	 * Return the string name of this ModuleType or the
	 * integer value if outside the bounds of the table
	 */
    public String toString() 
	{
    	String[] strTable = getStringTable();
    	int index = value - getOffset();
		if (strTable != null && index >= 0 && index < strTable.length)
        	return strTable[index];
		else
        	return Integer.toString (value);
    }

    /**
     * Returns the lowest integer value used by this enumeration value's
     * enumeration class.
     * <P>
     * The default implementation returns 0. If the enumeration class (a
     * subclass of class EnumSyntax) uses integer values starting at other than

     * 0, override this method in the subclass.
     * @return the offset of the lowest enumeration value.
     */
    protected int getOffset() 
	{ 	return 0;
    }
} 
