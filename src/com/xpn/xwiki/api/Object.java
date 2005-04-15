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
 *
 * User: ludovic
 * Date: 18 mars 2004
 * Time: 13:33:43
 */

package com.xpn.xwiki.api;

import com.xpn.xwiki.XWikiContext;
import com.xpn.xwiki.XWikiException;
import com.xpn.xwiki.doc.XWikiDocument;
import com.xpn.xwiki.objects.BaseObject;

public class Object extends Collection {

    public Object(BaseObject obj, XWikiContext context) {
        super(obj, context);
    }

    protected BaseObject getBaseObject() {
        return (BaseObject) getCollection();
    }

    public BaseObject getXWikiObject() {
        if (checkProgrammingRights())
         return (BaseObject) getCollection();
        else
         return null;
    }

    public java.lang.Object get(String name) {
        String docname = getCollection().getName();
        try {
            XWikiDocument doc = context.getWiki().getDocument(docname, context);
            return doc.display(name, this.getBaseObject(), context);
        } catch (XWikiException e) {
            return null;
        }
    }
}
