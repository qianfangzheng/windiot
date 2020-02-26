#!/bin/bash                                                                                                                                                          
echo 'starting...'
mvn clean
mvn package install
echo 'package success!'