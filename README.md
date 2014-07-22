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
			 <groupId>org.codehaus.mojo</groupId>
                <artifactId>jaxb2-maven-plugin</artifactId>
                <version>1.6</version>
                <executions>
                    <execution>
                        <id>xjc</id>
                        <goals>
                            <goal>xjc</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <schemaIncludes>
                        <schemaInclude>**/*.xsd</schemaInclude>
                    </schemaIncludes>
                    <strict>true</strict>
                    <verbose>true</verbose>
                    <extension>true</extension>
                    <removeOldOutput>true</removeOldOutput>
                    <args>
                        <arg>-Xgenerate-fx-properties</arg>
                    </args>
                    <plugins>
                        <plugin>
                            <groupId>com.buschmais.jaxbfx</groupId>
                            <artifactId>jaxbfx-plugin</artifactId>
                            <version>1.0-SNAPSHOT</version>
                        </plugin>
                    </plugins>
			</plugin>
		</plugins>
	  <build>
	  ...
	</project>


##License

jaxbfx is released under the [Apache License, Version 2.0] (http://www.apache.org/licenses/LICENSE-2.0.html)
