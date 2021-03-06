/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.phenotips.hpoa.ontology;

import org.phenotips.hpoa.utils.maps.SetMap;

import java.util.Collection;
import java.util.Collections;

public class TermData extends SetMap<String, String>
{
    public static final String ID_FIELD_NAME = "id";

    public static final String NAME_FIELD_NAME = "name";

    public static final String PARENT_FIELD_NAME = "is_a";

    public static final String OBSOLETE_FIELD_NAME = "is_obsolete";

    public static final String ALT_ID_FIELD_NAME = "alt_id";

    public static final String PARENT_ID_REGEX = "^([A-Z]+\\:[0-9]{7})\\s*!\\s*.*";

    private static final long serialVersionUID = 4880377023212693352L;

    private String id;

    private String name;

    private boolean obsolete;

    @Override
    public void clear()
    {
        this.id = null;
        this.name = null;
        this.obsolete = false;
        super.clear();
    };

    public String getId()
    {
        return this.id;
    }

    public String getName()
    {
        return (this.name == null) ? "" : this.name;
    }

    public void setObsolete(boolean obsolete)
    {
        this.obsolete = obsolete;
    }

    public boolean isObsolete()
    {
        return this.obsolete;
    }

    public boolean isValid()
    {
        return this.id != null && !isObsolete();
    }

    @Override
    public boolean addTo(String key, String value)
    {
        if (ID_FIELD_NAME.equals(key)) {
            this.id = value;
        } else if (NAME_FIELD_NAME.equals(key)) {
            this.name = value;
        } else if (OBSOLETE_FIELD_NAME.equals(key) && "true".equals(value)) {
            this.setObsolete(true);
        } else if (PARENT_FIELD_NAME.equals(key)) {
            return super.addTo(PARENT_FIELD_NAME, value.replaceAll(PARENT_ID_REGEX, "$1"));
        }
        return super.addTo(key, value);
    }

    @Override
    public boolean addTo(String key, Collection<String> values)
    {
        boolean result = true;
        for (String value : values) {
            result &= this.addTo(key, value);
        }
        return result;
    }

    public Collection<String> get(String key)
    {
        Collection<String> result = super.get(key);
        if (result == null) {
            return Collections.emptyList();
        }
        return result;
    }
}
