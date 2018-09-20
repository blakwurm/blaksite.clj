(ns blaksite.core
  (:require [net.cgrand.enlive-html :as html]
            [clojure.edn :as edn]
            [clojure.string :as str]))

(def locations
  {:template "template/"
   :output   "docs/"
   :front-page "index.html"})
   
   
 
(defn location-of [thing-name])

(def thingi "woot") 

(defn cleanstring [stringer]
  (-> stringer
      (str/replace "\n" "")
      (str/replace "\t" ""))) 

#_(html/deftemplate index "test/template/html/index.html"
    [ctxt]
    [:title (html/content (:blaksite/title ctxt))])

(defmulti site-template-for identity)

(defmethod site-template-for :index [ctxmap]
   (let [template (html/html-resource (java.io.StringReader. (slurp "template/index.html")))]
     (html/at template
              [:title] (html/content (:blaksite/title ctxmap))
              [:.sitetitle] (html/content (:blaksite/name ctxmap))
              [:.sitetagline] (html/content (:blaksite/tagline ctxmap)))))

(defn build-template [])

(defn -main [& args]
  (let [opts (edn/read-string (slurp "siteopts.edn"))
        htmres (html/html-resource (java.io.StringReader. (slurp "template/index.html")))]
             
    ;(println (clojure.java.io/file "template/html/index.html")) 
    ;(println)
    (spit "blbl.html" (reduce str
                       (html/emit*
                        (site-template-for :index opts))))))
    ;(println htmres)))
