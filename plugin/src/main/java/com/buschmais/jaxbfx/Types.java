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

import java.util.HashSet;
import java.util.Set;

/**
 * All the type specific constant values.
 *
 * @author Tobias Israel
 * @since 1.0.0
 */
abstract class Types {

    public static final String JAVA_LANG_STRING = "java.lang.String";
    public static final String JAVAFX_STRING_PROPERTY = "javafx.beans.property.StringProperty";
    public static final String JAVAFX_SIMPLE_STRING_PROPERTY = "javafx.beans.property.SimpleStringProperty";

    public static final String JAVA_LANG_BOOLEAN = "java.lang.Boolean";
    public static final String JAVA_PRIMITIVE_BOOLEAN = "boolean";
    public static final String JAVAFX_BOOLEAN_PROPERTY = "javafx.beans.property.BooleanProperty";
    public static final String JAVAFX_SIMPLE_BOOLEAN_PROPERTY = "javafx.beans.property.SimpleBooleanProperty";

    public static final String JAVA_PRIMITIVE_DOUBLE = "double";
    public static final String JAVAFX_DOUBLE_PROPERTY = "javafx.beans.property.DoubleProperty";
    public static final String JAVAFX_SIMPLE_DOUBLE_PROPERTY = "javafx.beans.property.SimpleDoubleProperty";

    public static final String JAVA_PRIMITIVE_FLOAT = "float";
    public static final String JAVAFX_FLOAT_PROPERTY = "javafx.beans.property.FloatProperty";
    public static final String JAVAFX_SIMPLE_FLOAT_PROPERTY = "javafx.beans.property.SimpleFloatProperty";

    public static final String JAVA_PRIMITIVE_INTEGER = "int";
    public static final String JAVAFX_INTEGER_PROPERTY = "javafx.beans.property.IntegerProperty";
    public static final String JAVAFX_SIMPLE_INTEGER_PROPERTY = "javafx.beans.property.SimpleIntegerProperty";

    public static final String JAVA_PRIMITIVE_LONG = "long";
    public static final String JAVAFX_LONG_PROPERTY = "javafx.beans.property.LongProperty";
    public static final String JAVAFX_SIMPLE_LONG_PROPERTY = "javafx.beans.property.SimpleLongProperty";

    public static final String JAVA_UTIL_LIST = "java.util.List";
    public static final String JAVA_UTIL_ARRAYLIST = "java.util.ArrayList";
    public static final String JAVAFX_LIST_PROPERTY = "javafx.beans.property.ListProperty";
    public static final String JAVAFX_SIMPLE_LIST_PROPERTY = "javafx.beans.property.SimpleListProperty";
    public static final String JAVAFX_FXCOLLECTIONS = "javafx.collections.FXCollections";

    public static final String JAVAFX_OBJECT_PROPERTY = "javafx.beans.property.ObjectProperty";
    public static final String JAVAFX_SIMPLE_OBJECT_PROPERTY = "javafx.beans.property.SimpleObjectProperty";

    public static final String JAVA_LANG_NUMBER = "java.lang.Number";
    public static final Set<String> NUMBER_TYPES = new HashSet<>();
    static {
        NUMBER_TYPES.add( "Integer" );
        NUMBER_TYPES.add( "Long" );
        NUMBER_TYPES.add( "Float" );
        NUMBER_TYPES.add( "Double" );
    }
}
