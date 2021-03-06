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
package org.phenotips.hpoa.annotation;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Map;

public class PrettyPrint
{
    private PrettyPrint()
    {
        // Nothing to do, just forbidding instantiation
    }

    public static void printList(Collection<? extends Object> data, PrintStream out)
    {
        for (Object o : data) {
            out.println(o);
        }
    }

    public static void printList(Collection<? extends Object> data, int limit, PrintStream out)
    {
        int i = 0;
        for (Object o : data) {
            if (i++ > limit) {
                break;
            }
            out.println(o);
        }
    }

    public static void printMap(Map<? extends Object, ? extends Object> data, PrintStream out)
    {
        for (Object key : data.keySet()) {
            out.println(key + "\t" + data.get(key));
        }
    }

    public static void printMap(Map<? extends Object, ? extends Object> data, int limit, PrintStream out)
    {
        int i = 0;
        for (Object key : data.keySet()) {
            if (i++ > limit) {
                break;
            }
            out.println(key + "\t" + data.get(key));
        }
    }
}
