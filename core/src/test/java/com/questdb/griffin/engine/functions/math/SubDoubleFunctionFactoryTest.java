/*******************************************************************************
 *    ___                  _   ____  ____
 *   / _ \ _   _  ___  ___| |_|  _ \| __ )
 *  | | | | | | |/ _ \/ __| __| | | |  _ \
 *  | |_| | |_| |  __/\__ \ |_| |_| | |_) |
 *   \__\_\\__,_|\___||___/\__|____/|____/
 *
 * Copyright (C) 2014-2018 Appsicle
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 ******************************************************************************/

package com.questdb.griffin.engine.functions.math;

import com.questdb.griffin.FunctionFactory;
import com.questdb.griffin.SqlException;
import com.questdb.griffin.engine.AbstractFunctionFactoryTest;
import org.junit.Test;

public class SubDoubleFunctionFactoryTest extends AbstractFunctionFactoryTest {

    @Test
    public void testLeftNull() throws SqlException {
        call(Double.NaN, 10d).andAssert(Double.NaN, 0);
    }

    @Test
    public void testRightNull() throws SqlException {
        call(4d, Double.NaN).andAssert(Double.NaN, 0);
    }

    @Test
    public void testSimple() throws SqlException {
        call(5d, 8d).andAssert(-3d, 0.000001);
    }

    @Override
    protected FunctionFactory getFunctionFactory() {
        return new SubDoubleFunctionFactory();
    }
}