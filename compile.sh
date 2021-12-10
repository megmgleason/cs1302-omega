#!/bin/bash

OPTS="-q -e" # quiet and produce execution error messages
JFX="-Dprism.order=sw" # specify the software renderer

check1302
set -ex
mvn $OPTS clean
mvn $OPTS compile
mvn $OPTS exec:java $JFX $@
