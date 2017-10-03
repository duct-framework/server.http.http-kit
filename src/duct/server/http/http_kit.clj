(ns duct.server.http.http-kit
  (:require [org.httpkit.server :as httpkit]
            [duct.logger :as logger]
            [integrant.core :as ig]))

(defmethod ig/init-key :duct.server.http/http-kit [_ {:keys [handler logger] :as opts}]
  (let [handler (atom (delay (:handler opts)))
        logger  (atom logger)
        options (dissoc opts :handler :logger)]
    (logger/log @logger :report ::starting-server (select-keys opts [:port]))
    {:handler     handler
     :logger      logger
     :stop-server (httpkit/run-server (fn [req] (@@handler req)) options)}))

(defmethod ig/halt-key! :duct.server.http/http-kit [_ {:keys [logger stop-server]}]
  (logger/log @logger :report ::stopping-server)
  (stop-server))

(defmethod ig/suspend-key! :duct.server.http/http-kit [_ {:keys [handler]}]
  (reset! handler (promise)))

(defmethod ig/resume-key :duct.server.http/http-kit [key opts old-opts old-impl]
  (if (= (dissoc opts :handler :logger) (dissoc old-opts :handler :logger))
    (do (deliver @(:handler old-impl) (:handler opts))
        (reset! (:logger old-impl) (:logger opts))
        old-impl)
    (do (ig/halt-key! key old-impl)
        (ig/init-key key opts))))
