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
                            <version>1.0.1</version>
                        </plugin>
                    </plugins>
                </configuration>
            </plugin>
        </plugins>
    </build>
	  ...
	</project>

If you're running the plugin with Java 7, you have to make two changes:

* Force the plugin to generate anonymous classes instead of lambdas with additional arguments:

                        <arg>-Xjaxbfx-java-version</arg>
                        <arg>7</arg>

* You might have to prevent compilation issues by adding the following dependency:

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

## Diving In

* Learn how the [JavaFX databinding](http://docs.oracle.com/javase/8/javafx/properties-binding-tutorial/binding.htm) works.
* Learn more about [Java Web Services Tools](https://docs.oracle.com/javase/8/docs/technotes/tools/#webservices).
* Read the JAXB2 Maven Plugin [documentation](https://github.com/highsource/maven-jaxb2-plugin/wiki).

## Bugs?

Check out [current issues](https://github.com/buschmais/jaxbfx/issues), report a [new one](https://github.com/buschmais/jaxbfx/issues/new), or (even better) help us making it better by forking, fixing and providing Pull Requests.

##License

jaxbfx is released under the [Apache License, Version 2.0] (http://www.apache.org/licenses/LICENSE-2.0.html)
