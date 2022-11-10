#!/bin/bash

git pull origin master
git add .
 if [ ! -z "$1" ]; then
    git commit -m $1;
  else
     git commit -m 'add';
  fi
git push origin master