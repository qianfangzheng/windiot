#!/bin/bash                                                                                                                                                          
PID=$(ps -ef | grep java | grep -v grep | awk '{ print $2 }')                                                                                                                                    
if [ -z "$PID" ]                                                                                
then                                                                                            
        echo 'adminApplication is already stopped'                                              
else                                                                                            
        kill -9 $PID                                                                          
        echo 'adminApplication Stop success'  
        echo "$PID";                                                  
fi