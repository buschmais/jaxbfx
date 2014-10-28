/*
 * Copyright 2014 buschmais GbR
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.buschmais.jaxbfx;

import static org.junit.Assert.*;

import org.junit.Test;

import com.buschmais.test.fx.ListType;
import com.buschmais.test.fx.ObjectFactory;
import com.buschmais.test.fx.TestType;

import javafx.beans.property.*;

/**
 * Tests to make sure, the plugin serves your expectations ;-)
 *
 * @author Tobias Israel
 * @since 1.0.0
 */
public class FXBeanPropertyXJCPluginTest {


    @Test
    public void testGeneratedOutputTypes() throws Exception {
        ObjectFactory of = new ObjectFactory();
        TestType cut = of.createTestType();
        assertTrue("StringProperty expected!", cut.aStringProperty() instanceof StringProperty);
        assertTrue("BooleanProperty expected!", cut.aBooleanProperty() instanceof BooleanProperty);
        assertTrue("DoubleProperty expected!", cut.aDoubleProperty() instanceof DoubleProperty);
        assertTrue("FloatProperty expected!", cut.aFloatProperty() instanceof FloatProperty);
        assertTrue("LongProperty expected!", cut.aLongProperty() instanceof LongProperty);
        cut.getAList();
        assertTrue("ListProperty expected!", cut.aListProperty() instanceof ListProperty);
        assertTrue("IntegerProperty expected!", cut.anIntegerProperty() instanceof IntegerProperty);

        assertTrue("BooleanProperty expected!", cut.aPrimitiveBooleanProperty() instanceof BooleanProperty);
        assertTrue("DoubleProperty expected!", cut.aPrimitiveDoubleProperty() instanceof DoubleProperty);
        assertTrue("FloatProperty expected!", cut.aPrimitiveFloatProperty() instanceof FloatProperty);
        assertTrue("LongProperty expected!", cut.aPrimitiveLongProperty() instanceof LongProperty);
        assertTrue("IntegerProperty expected!", cut.aPrimitiveIntegerProperty() instanceof IntegerProperty);
    }

    @Test
    public void testGeneratedOutputUsage() throws Exception {
        ObjectFactory of = new ObjectFactory();
        TestType cut = of.createTestType();
        assertNull("Optional xsd:int element must be null!", cut.getAnInteger());
        assertNull("Optional xsd:boolean element must be null!", cut.isABoolean());
        assertNull("Optional xsd:double element must be null!", cut.getADouble());
        assertNull("Optional xsd:float element must be null!", cut.getAFloat());
        assertNull("Optional xsd:long element must be null!", cut.getALong());

        ListType listItem = of.createListType();
        cut.getAList().add(listItem);
        assertEquals(listItem, cut.aListProperty().get(0));
        cut.setABoolean(Boolean.TRUE);
        assertTrue(cut.isABoolean());
        cut.setADouble(22.5);
        assertEquals(22.5, cut.getADouble(), 0);
        cut.setAnInteger(Integer.valueOf(2));
        assertEquals(Integer.valueOf(2), cut.getAnInteger());
        cut.setALong(Long.valueOf(2));
        assertEquals(Long.valueOf(2), cut.getALong());
        cut.setAFloat(Float.valueOf(0.25f));
        assertEquals(Float.valueOf(0.25f), cut.getAFloat());

        cut.setAPrimitiveBoolean(true);
        assertTrue(cut.isAPrimitiveBoolean());
        cut.setAPrimitiveDouble(22.5);
        assertEquals(22.5, cut.getAPrimitiveDouble(), 0);
        cut.setAPrimitiveInteger(2);
        assertEquals(2, cut.getAPrimitiveInteger());
        cut.setAPrimitiveLong(2);
        assertEquals(2, cut.getAPrimitiveLong());
        cut.setAPrimitiveFloat(0.25f);
        assertEquals(0.25f, cut.getAPrimitiveFloat(), 0);
    }

}
