(ns dev
  (:require [clojure.tools.nrepl.server :as nrepl]
            [clojure.tools.namespace.repl :as namespace.repl]))

(println "user ns loaded")

(defn foo []
  (println "booyeah!"))

(def *nrepl-server (atom nil))

(defn cider-handler []
  (require 'cider.nrepl)
  (ns-resolve 'cider.nrepl 'cider-nrepl-handler))

(defn start-nrepl []
  (when-not @*nrepl-server
    (reset! *nrepl-server (nrepl/start-server :port 4242 :handler (cider-handler))))
  (println "Ripple In!"))

(defn stop-nrepl []
  (nrepl/stop-server @*nrepl-server))

(defn start-cider []
  (nrepl/start-server :port 4242 :handler (cider-handler))) 

(defn reset []
  (do
    (namespace.repl/refresh)))

(defn -main []
  (start-nrepl))


