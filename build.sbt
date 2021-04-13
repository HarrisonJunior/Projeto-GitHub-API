name := """github_api"""
organization := "be.com.pbsoft"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.5"

libraryDependencies += guice

libraryDependencies += ws



