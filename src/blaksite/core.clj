(ns blaksite.core
  (:require [net.cgrand.enlive-html :as html]
            [clojure.edn :as edn]
            [clojure.string :as str]))
 
(def thingi "woot") 

(defn cleanstring [stringer]
  (-> stringer
      (str/replace "\n" "")
      (str/replace "\t" ""))) 

#_(html/deftemplate index "test/template/html/index.html"
    [ctxt]
    [:title (html/content (:blaksite/title ctxt))])

(defn index-template [ctxmap]
   (let [template (html/html-resource (java.io.StringReader. (slurp "template/html/index.html")))]
     (html/at template
              [:title] (html/content (:blaksite/title ctxmap))
              [:#pagetitle] (html/content (:blaksite/name ctxmap))
              [:#pagesubtitle] (html/content (:blaksite/tagline ctxmap)))))

(defn testme []
  (reduce str (html/emit* (index-template (edn/read-string (slurp "siteopts.edn"))))))  

(defn -main [& args]
  (let [opts (edn/read-string (slurp "siteopts.edn"))
        htmres (html/html-resource (java.io.StringReader. (slurp "template/html/index.html")))]
             
    ;(println (clojure.java.io/file "template/html/index.html")) 
    ;(println)
    (println (testme))
    (spit "blbl.html" (reduce str
                       (html/emit*
                        (index-template opts))))))
    ;(println htmres)))
