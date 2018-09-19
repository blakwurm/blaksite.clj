(ns user
  (:require [clojure.tools.nrepl.server :as nrepl]
            [clojure.tools.namespace.repl :as namespace.repl]
            [dev]))
(defn jack []
  (require 'com.blakwurm.yushan.core)
  (in-ns 'com.blakwurm.yushan.core)
  :loaded)

(defn go
  "Load and switch to the 'dev' namespace."
  [& opts]
  (dev/start-nrepl)
  (require 'dev)
  (in-ns 'dev)
  :loaded)

  
(defn -main [& args])
