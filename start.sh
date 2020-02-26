#!/bin/bash                                                                                                                                                          
echo 'starting...'
cd data-admin/target
nohup java -jar data-admin.jar >D:/java_project/web.log 2>D:/java_project/weberr.log &
echo 'It is expected to be finished in one minute!'