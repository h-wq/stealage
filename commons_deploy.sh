#!/usr/bin/env bash

COMMAND=$1
ENV=$2
VERSION_MAX=5

function usage() {
    echo "Usage: $0 up|down [env]"
    echo "       $0 start|restart [env]"
    echo "       $0 stop|status"
}

function stop_current() {
    local _current=$1
    echo "stopping $_current"

    if [ -z $_current ] || [ ! -d $_current ]; then
        echo "invalid current $_current"
        exit 1
    fi
    cd $_current
    ./run.sh stop
    if [ $? -ne 0 ]; then
        echo "cannot stop app in $_current"
        exit 1
    fi
    cd ..
}

function start_next() {
    local _next=$1
    echo "starting $_next"
    if [ -z $_next ] || [ ! -d $_next ]; then
        echo "invalid next $_next"
        exit 1
    fi
    cd $_next
    ./run.sh start $ENV
    if [ $? -ne 0 ]; then
        echo "cannot start app in $_next"
        exit 1
    fi
    cd ..
}

function up() {

    next_file=$(ls *target)
    next=$(echo $next_file)
    echo "next version = $next"

    deploy_time=$(date +%Y%m%d-%H%M%S)
    echo "deploy time = $deploy_time"

    if [ -z $next ]; then
        echo "no target"
    else
        stop_current $next
    fi

    start_next $next

    echo "$next  @$deploy_time"
}

function down() {
    current=$(ls *target)
    if [ "$current" = "" ]; then
        echo "no current run"
        exit 1
    fi

    stop_current $current
}

function status() {

    current=$(ls *target)
    if [ -z "$current" ]; then
        echo "no current run"
        exit 1
    else
        echo "current run = $current"
    fi

    cd $current
    ./run.sh status
}

function stop() {
    current=$(ls *target)
    if [ -z "$current" ]; then
        echo "no current run"
        exit 1
    else
        echo "current run = $current"
    fi
    cd $current
    ./run.sh stop
}

function start() {
    current=$(ls *target)
    if [ -z "$current" ]; then
        echo "no current run"
        exit 1
    else
        echo "current run = $current"
    fi
    cd $current
    ./run.sh start $ENV
}

function restart() {
    current=$(ls *target)
    if [ -z "$current" ]; then
        echo "no current run"
        exit 1
    else
        echo "current run = $current"
    fi
    cd $current
    ./run.sh restart $ENV
}

if [ "$COMMAND" != "status" ] && [ "$COMMAND" != "stop" ]; then
    if [ -z "$ENV" ]; then
        usage
        exit 1
    fi
fi

case "$COMMAND" in
    up)
        up
        ;;
    down)
        down
        ;;
    status)
        status
        ;;
    stop)
        stop
        ;;
    start)
        start
        ;;
    restart)
        restart
        ;;
    *)
        usage
        ;;
esac
