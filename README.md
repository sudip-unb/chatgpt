# Call chatgpt API from Java

This simple java program will help to call OpenAI Completions. This is extreamly easy to use and consume the API exposed by OpenAI. This java program is using "text-davinci-003" model. 

# Generate API Key for REST call

Login to your ChatGPT account, go to the right-top corner and click on your account, and then click on "View API Keys" and then generate API Key by clicking "Create new secret key"

# ChatGPT API references

In this example we will use "Completion". We will send a promt and the model will return one or more predicted completions. Here, I am using "text-davinci-003" as a model.

# API for Completion

We are using the following API for completion - 
https://api.openai.com/v1/completions
We have to call a POST method with the folldong JSON - 

``` JSON
{
  "model": "text-davinci-003",
  "prompt": "Say this is a test",
  "max_tokens": 7,
  "temperature": 0,
  "top_p": 1,
  "n": 1,
  "stream": false,
  "logprobs": null,
  "stop": "\n"
}

```

In our code we will receive the prompt value from the user and call the REST API.

