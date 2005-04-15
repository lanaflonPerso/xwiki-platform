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
 * Date: 22 d�c. 2003
 * Time: 09:19:06
 */
package com.xpn.xwiki.objects.meta;

import com.xpn.xwiki.objects.BaseCollection;
import com.xpn.xwiki.objects.classes.NumberClass;
import com.xpn.xwiki.objects.classes.StaticListClass;
import com.xpn.xwiki.objects.classes.DateClass;
import com.xpn.xwiki.objects.classes.StringClass;

public class DateMetaClass extends PropertyMetaClass {

  public DateMetaClass() {
    super();
    // setType("numbermetaclass");
    setPrettyName("Date Class");
    setName(DateClass.class.getName());

    NumberClass size_class = new NumberClass(this);
    size_class.setName("size");
    size_class.setPrettyName("Size");
    size_class.setSize(5);
    size_class.setNumberType("integer");

    NumberClass emptyistoday_class = new NumberClass(this);
    emptyistoday_class.setName("emptyIsToday");
    emptyistoday_class.setPrettyName("Empty Is Today");
    emptyistoday_class.setSize(5);
    emptyistoday_class.setNumberType("integer");

    StringClass dateformat_class = new StringClass(this);
    dateformat_class.setName("dateFormat");
    dateformat_class.setPrettyName("Date Format");
    dateformat_class.setSize(20);

    safeput("size", size_class);
    safeput("emptyIsToday", emptyistoday_class);
    safeput("dateFormat", dateformat_class);
  }

  public BaseCollection newObject() {
        return new DateClass();
  }
}
