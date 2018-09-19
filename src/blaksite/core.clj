(ns blaksite.core
  (:require [selmer.parser :as selmer]
            [clojure.edn :as edn]))
 
(def thingi "woot") 

(defn -main [& args]
  (let [opts (edn/read-string (slurp "siteopts.edn"))]
    
    (spit "blbl.txt" (pr-str opts))))
