(defproject duct/server.http.http-kit "0.1.0-SNAPSHOT"
  :description "Integrant methods for running a HTTP-Kit web server"
  :url "https://github.com/duct-framework/server.http.http-kit"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha17"]
                 [http-kit "2.2.0"]
                 [duct/logger "0.1.1"]
                 [integrant "0.4.0"]]
  :profiles
  {:dev {:dependencies [[clj-http "2.1.0"]]}})
