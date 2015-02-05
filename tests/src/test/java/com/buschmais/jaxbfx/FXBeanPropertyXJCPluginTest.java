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


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import com.buschmais.test.fx.ListType;
import com.buschmais.test.fx.ObjectFactory;
import com.buschmais.test.fx.TestType;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import org.junit.Test;

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
        assertTrue("ObjectProperty expected!", cut.aBooleanProperty() instanceof ObjectProperty);
        assertTrue("ObjectProperty expected!", cut.aDoubleProperty() instanceof ObjectProperty);
        assertTrue("ObjectProperty expected!", cut.aFloatProperty() instanceof ObjectProperty);
        assertTrue("ObjectProperty expected!", cut.aLongProperty() instanceof ObjectProperty);
        cut.getAList();
        assertTrue("ListProperty expected!", cut.aListProperty() instanceof ListProperty);
        assertTrue("ObjectProperty expected!", cut.anIntegerProperty() instanceof ObjectProperty);

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
        cut.setAnInteger(2);
        assertEquals(Integer.valueOf(2), cut.getAnInteger());
        cut.setALong(2l);
        assertEquals(Long.valueOf(2), cut.getALong());
        cut.setAFloat(0.25f);
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

    @Test
    public void testUnmarshalling() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance("com.buschmais.test.fx");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<TestType> jaxbElem = (JAXBElement<TestType>) unmarshaller.unmarshal(
                FXBeanPropertyXJCPluginTest.class.getResourceAsStream("/testdata.xml"));
        TestType unmarshalledBean = jaxbElem.getValue();
        assertEquals("string", unmarshalledBean.getAString());
        assertEquals("string", unmarshalledBean.aStringProperty().get());
        assertTrue(unmarshalledBean.isABoolean());
        assertTrue(unmarshalledBean.aBooleanProperty().get());
        assertTrue(unmarshalledBean.isAPrimitiveBoolean());
        assertTrue(unmarshalledBean.aPrimitiveBooleanProperty().get());
        assertEquals(1.051732e7, unmarshalledBean.getAPrimitiveDouble(), 0);
        assertEquals(1.051732e7, unmarshalledBean.aPrimitiveDoubleProperty().get(), 0);
        assertEquals(new Double(1.051732e7), unmarshalledBean.getADouble());
        assertEquals(new Double(1.051732e7), unmarshalledBean.aDoubleProperty().get());
        assertEquals(1.5e2, unmarshalledBean.getAPrimitiveFloat(), 0);
        assertEquals(1.5e2, unmarshalledBean.aPrimitiveFloatProperty().get(), 0);
        assertEquals(1.5e2, unmarshalledBean.getAFloat(), 0);
        assertEquals(1.5e2, unmarshalledBean.aFloatProperty().get(), 0);
        assertEquals(3, unmarshalledBean.getAPrimitiveInteger());
        assertEquals(3, unmarshalledBean.aPrimitiveIntegerProperty().get());
        assertEquals(new Integer(3), unmarshalledBean.getAnInteger());
        assertEquals(new Integer(3), unmarshalledBean.anIntegerProperty().get());
        assertEquals(new Long(10), unmarshalledBean.getALong());
        assertEquals(new Long(10), unmarshalledBean.aLongProperty().get());
        assertEquals(10, unmarshalledBean.getAPrimitiveLong());
        assertEquals(10, unmarshalledBean.aPrimitiveLongProperty().get());
        assertThat(unmarshalledBean.getAList(), hasSize(1));
        assertThat(unmarshalledBean.aListProperty().get(), hasSize(1));
        assertEquals("string", unmarshalledBean.getAList().get(0).getListItem());
        assertEquals("string", unmarshalledBean.aListProperty().get().get(0).getListItem());
    }

}
