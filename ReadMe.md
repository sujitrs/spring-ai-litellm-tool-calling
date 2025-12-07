![img.png](img.png)

```
http://localhost:8080/ai?userInput=Get the current date and time in the user's timezone
http://localhost:8080/ai?userInput=What is name of the user ?
http://localhost:8080/ai?userInput=Given first name is "Sujeet", what is its middlename ?
http://localhost:8080/ai?userInput=Given first name is "Sujeet" with last name as "Suryawanshi", what is its middlename ?
```

# Setup Litellm
## config.yaml
```
model_list:
  - model_name: "*"             # all requests where model not in your config go to this deployment
    litellm_params:
      model: openai/*           # set `openai/` to use the openai route
      api_key: sk-proj-REPLACE_IT_WITH_REAL_SIMPLE_OPEN_AI_KEY

```

## Spinoff docker container

```
docker run     -v $(pwd)/config.yaml:/app/config.yaml     -p 4000:4000     ghcr.io/berriai/litellm:main-latest     --config /app/config.yaml --detailed_debug

```
