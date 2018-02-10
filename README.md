# Vaadin-jee7-webapp-archetype

Archetype for Jave EE 7 webapps, based on Matti Tahvonen’s [java-ee7-app-stub](https://github.com/vonloxley/java-ee7-app-stub).

## Comes with
- Vaadin CDI
- Vaadin-maven-plugin
- a default theme

## Usage
If you want to give it a try start like this:

~~~bash
mvn \
	-DarchetypeGroupId=de.hansche  \
	-DarchetypeArtifactId=vaadin-jee7-webapp-archetype  \
	-DarchetypeVersion=8.3  \
	archetype:generate
~~~

## Install
If you cloned the archetype read on.

~~~bash
mvn install
~~~

## Create a project
~~~bash
mvn \
	-DarchetypeGroupId=de.hansche  \
	-DarchetypeArtifactId=vaadin-jee7-webapp-archetype  \
	-DarchetypeVersion=8.3  \
	-DarchetypeRepository=local  \
	-Dversion=1.0   \
	archetype:generate
~~~

## Start with
1. Creating views. Have a look at the view-package to see how.
2. Adding Entity Classes and Session Beans for Entity Classes.
3. In Netbeans, installing the [Entity Expander](http://plugins.netbeans.org/plugin/53874/entityexpander) plugin and the nice MaddonForm and TableViewWithPopups [templates](https://github.com/vonloxley/vaadin-jee7-entity-templates).

