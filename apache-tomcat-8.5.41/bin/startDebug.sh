#!/bin/sh

[ -z "$CATALINA_HOME" ] && CATALINA_HOME=`cd "$PRGDIR/.." >/dev/null; pwd`
[ -z "$JPDA_ADDRESS" ] && JPDA_ADDRESS=8000
[ -z "$JPDA_TRANSPORT" ] && JPDA_TRANSPORT=dt_socket

./catalina.sh  jpda start
