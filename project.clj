(defproject duct/server.http.http-kit "0.1.1"
  :description "Integrant methods for running a HTTP-Kit web server"
  :url "https://github.com/duct-framework/server.http.http-kit"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-beta3"]
                 [duct/core "0.6.1"]
                 [http-kit "2.2.0"]
                 [duct/logger "0.2.1"]
                 [integrant "0.6.1"]]
  :profiles
  {:dev {:dependencies [[clj-http "2.1.0"]]}})
