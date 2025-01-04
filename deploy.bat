set ENV_FILE=C:\Users\Админ\Downloads\ConInstructions\.env

pushd C:\Users\Админ\Downloads\ConInstructions

call docker compose -f docker-compose.yml --env-file %ENV_FILE% down --timeout=60 --remove-orphans
call docker compose -f docker-compose.yml --env-file %ENV_FILE% up --build --detach

popd