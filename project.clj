(defproject duct/server.http.http-kit "0.1.4"
  :description "Integrant methods for running a HTTP-Kit web server"
  :url "https://github.com/duct-framework/server.http.http-kit"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [duct/core "0.8.0"]
                 [http-kit "2.5.3"]
                 [duct/logger "0.3.0"]
                 [integrant "0.8.0"]]
  :profiles
  {:dev {:dependencies [[clj-http "3.12.3"]]}})
