# Example servers

Use for testing benchmarks.

# WRK

Get [wrk](https://github.com/wg/wrk)

## MacOS:

`brew install wrk`


## Run wrk test

```bash
wrk -t12 -c400 -d30s http://127.0.0.1:8080/hello
```