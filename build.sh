#!/bin/bash
remote_path=$1
env=$2
MODULE=$3
ALL_MODULES=$4

`pwd`/git checkout $env
`pwd`/git pull

echo "
#######################################

clean and install all modules

#######################################
"
/maven/apache-maven-3.6.3/bin/mvn clean install -DskipTests=true
ret=$?
if [ $ret != 0 ]; then
    echo ""
    echo "Maven install failed"
    echo ""
    exit 1
fi

if [ "$MODULE" == "all" ]; then
    MODULES=( "${ALL_MODULES[@]}" )
else
    MODULES=("$MODULE")
fi

for service in ${MODULES[@]}; do
    echo "
#######################################

packaging $service

#######################################
"
    cd $service
    /maven/apache-maven-3.6.3/bin/mvn clean package -DskipTests=true
    ret=$?
    if [ $ret != 0 ]; then
        echo ""
        echo "Package $service failed"
        echo ""
        exit 1
    fi
    cd ..
done
