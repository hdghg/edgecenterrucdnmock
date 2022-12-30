#!/bin/sh

./mvnw -B clean compile jib:build -Djib.to.image=hdghg/edgecenterrucdnmock:latest
