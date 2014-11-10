jaxbfx
======

[![Build Status](https://travis-ci.org/buschmais/jaxbfx.svg?branch=master)](https://travis-ci.org/buschmais/jaxbfx)

A JAXB2 XJC plugin to generate JavaFX properties.

##Getting Started

###Using Maven

Configure the JAXB-2 Maven Plugin and add jaxbfx plugin configuration:

	<project>
	...
    <build>
        <plugins>
            <plugin>
                <groupId>org.jvnet.jaxb2.maven2</groupId>
                <artifactId>maven-jaxb22-plugin</artifactId>
                <version>0.11.0</version>
                <executions>
                    <execution>
                        <phase>generate-sources</phase>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <schemaDirectory>src/main/resources/xsd</schemaDirectory>
                    <schemaIncludes>
                        <schemaInclude>*.xsd</schemaInclude>
                    </schemaIncludes>
                    <specVersion>2.2</specVersion>
                    <strict>true</strict>
                    <extension>true</extension>
                    <removeOldOutput>true</removeOldOutput>
                    <args>
                        <arg>-Xgenerate-fx-properties</arg>
                    </args>
                    <plugins>
                        <plugin>
                            <groupId>com.buschmais.jaxbfx</groupId>
                            <artifactId>jaxbfx-plugin</artifactId>
                            <version>1.0.0</version>
                        </plugin>
                    </plugins>
                </configuration>
            </plugin>
        </plugins>
    </build>
	  ...
	</project>

If you're running the plugin with Java 7, you might have to prevent compilation issues by adding the following
dependency:

    ...
     <dependencies>
         <dependency>
             <groupId>com.oracle</groupId>
             <artifactId>javafx</artifactId>
             <version>2.2</version>
             <systemPath>${java.home}/lib/jfxrt.jar</systemPath>
             <scope>system</scope>
         </dependency>
     </dependencies>
     ...

##License

jaxbfx is released under the [Apache License, Version 2.0] (http://www.apache.org/licenses/LICENSE-2.0.html)
