# Duct server.http.http-kit

[![Build Status](https://travis-ci.org/duct-framework/server.http.http-kit.svg?branch=master)](https://travis-ci.org/duct-framework/server.http.http-kit)

Integrant multimethods for running a [HTTP-Kit][] HTTP server for the
[Duct][] framework.

[http-kit]: http://www.http-kit.org/
[duct]: https://github.com/duct-framework/duct

## Installation

To install, add the following to your project `:dependencies`:

    [duct/server.http.http-kit "0.1.3"]

## Usage

This library adds Integrant methods that dispatch off the
`:duct.server.http/http-kit` key, which is derived from
`:duct.server/http`. The corresponding value is a map of options for
the HTTP-Kit Ring adapter, plus a `:handler` key that takes a handler
function.

For example:

```clojure
{:duct.server.http/http-kit
 {:port    3000
  :handler (fn [request]
             {:status  200
              :headers {"Content-Type" "text/plain"}
              :body    "Hello World"})}}
```

A `:logger` key may also be specified, which will be used to log when
the server starts and when it stops. The value of the key should be an
implementation of the `duct.logger/Logger` protocol from the
[duct.logger][] library

[duct.logger]: https://github.com/duct-framework/logger

## License

Copyright © 2019 James Reeves

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
