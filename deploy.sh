#!/bin/bash

ENV_FILE=".env"

# Обновление кода в деплой backend приложения
pushd ~/Conyata/ || exit

# Переходим на ветку main
git checkout master

# Обновляем ветку main
git pull origin master

# Останавливаем старые контейнеры микросервисов и запускаем новые, с обновлённым кодом
docker compose -f docker-compose.yml --env-file $ENV_FILE down --timeout=60 --remove-orphans
docker compose -f docker-compose.yml --env-file $ENV_FILE up --build --detach

popd || exit