/**
 * ===================================================================
 *
 * Copyright (c) 2003 Ludovic Dubost, All rights reserved.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details, published at
 * http://www.gnu.org/copyleft/gpl.html or in gpl.txt in the
 * root folder of this distribution.

 * Created by
 * User: Ludovic Dubost
 * Date: 1 f�vr. 2004
 * Time: 21:54:09
 */
package com.xpn.xwiki.objects.classes;

import com.xpn.xwiki.XWikiContext;
import com.xpn.xwiki.web.XWikiMessageTool;
import com.xpn.xwiki.objects.BaseCollection;
import com.xpn.xwiki.objects.BaseProperty;
import com.xpn.xwiki.objects.IntegerProperty;
import com.xpn.xwiki.objects.NumberProperty;
import com.xpn.xwiki.objects.meta.PropertyMetaClass;
import org.apache.ecs.xhtml.option;
import org.apache.ecs.xhtml.select;

public class BooleanClass extends PropertyClass {

    public BooleanClass(PropertyMetaClass wclass) {
        super("boolean", "Boolean", wclass);
    }

    public BooleanClass() {
        this(null);
    }

    public String getDisplayType() {
        String dtype = getStringValue("displayType");
        if ((dtype==null)||(dtype.equals(""))) {
            return "yesno";
        }
        return dtype;
    }

    public void setDisplayType(String type) {
        setStringValue("displayType", type);
    }

    public BaseProperty fromString(String value) {
        NumberProperty property;
        Number nvalue = null;
        property = new IntegerProperty();
        if ((value!=null)&&(!value.equals("")))
                nvalue = new Integer(value);
        property.setName(getName());
        property.setValue(nvalue);
        return property;
    }

    public void displayView(StringBuffer buffer, String name, String prefix, BaseCollection object, XWikiContext context) {
        IntegerProperty prop = (IntegerProperty) object.safeget(name);
        if (prop==null)
            return;

        int value = ((Integer)prop.getValue()).intValue();
        buffer.append(getDisplayValue(context, value));
    }


    public void displayEdit(StringBuffer buffer, String name, String prefix, BaseCollection object, XWikiContext context) {
        select select = new select(prefix + name, 1);
        String String0 = getDisplayValue(context, 0);
        String String1 = getDisplayValue(context, 1);

        option[] options = { new option("---", "" ), new option(String1, "1" ), new option(String0, "0")};
        options[0].addElement("---");
        options[1].addElement(String1);
        options[2].addElement(String0);

        try {
        IntegerProperty prop = (IntegerProperty) object.safeget(name);
        if (prop!=null) {
            Integer ivalue = (Integer)prop.getValue();
            if (ivalue!=null) {
                int value = ivalue.intValue();
                if (value==1)
                    options[1].setSelected(true);
                else if (value==0)
                    options[2].setSelected(true);
            }
        }} catch (Exception e) {
            // This should not happen
            e.printStackTrace();
        }
        select.addElement(options);
        buffer.append(select.toString());
    }


    private String getDisplayValue(XWikiContext context, int value) {
        try {
            XWikiMessageTool msg = (XWikiMessageTool) context.get("msg");
            String strname = getDisplayType() + "_" + value;
            String result = msg.get(strname);
            if (result.equals(strname))
             return "" + value;
            else
             return result;
        } catch (Exception e) {
            return "" + value;
        }
    }

}
