(set-env!
 :dependencies '[[adzerk/boot-cljs "1.7.228-1" :scope "provided"]
                 [adzerk/boot-reload "0.4.8" :scope "provided"]
                 [hoplon/boot-hoplon "0.1.13" :scope "provided"]
                 [hoplon/hoplon "6.0.0-alpha16" :scope "provided"]
                 [org.clojure/clojure "1.9.0-alpha5" :scope "provided"]
                 [org.clojure/clojurescript "1.9.36" :scope "provided"]
                 [tailrecursion/boot-jetty "0.1.3" :scope "provided"]]
 :source-paths #{"src"})

(require
 '[adzerk.boot-cljs         :refer [cljs]]
 '[adzerk.boot-reload       :refer [reload]]
 '[hoplon.boot-hoplon       :refer [hoplon]]
 '[tailrecursion.boot-jetty :refer [serve]])

(deftask demo
  []
  (with-pre-wrap fileset
    (merge-env! :resource-paths #{"demo"}
                :dependencies '[[hoplon/highlight "8.4.0-0"]])
    fileset))

(deftask dev
  "Build hoplon-spectre for local development."
  []
  (comp
   (demo)
   (watch)
   (speak)
   (hoplon)
   (reload)
   (cljs)
   (serve :port 8000)))

(deftask prod
  "Build hoplon-spectre for production deployment."
  []
  (comp
   (hoplon)
   (cljs :optimizations :advanced)
   (target :dir #{"target"})))
