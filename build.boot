(set-env!
 :dependencies '[[org.clojure/clojure "1.9.0-alpha8" :scope "provided"]

                 [org.clojure/clojurescript "1.9.93" :scope "provided"]
                 [adzerk/boot-cljs "1.7.228-1" :scope "provided"]

                 [adzerk/boot-reload "0.4.11" :scope "test"]
                 [tailrecursion/boot-jetty "0.1.3" :scope "test"]

                 [hoplon/boot-hoplon "0.1.13" :scope "provided"]
                 [hoplon/hoplon "6.0.0-alpha16" :scope "provided"]
                 [tailrecursion/boot-heredoc "0.1.1" :scope "test"]]
 :resource-paths #{"src"})

(require
 '[adzerk.boot-cljs         :refer [cljs]]
 '[adzerk.boot-reload       :refer [reload]]
 '[hoplon.boot-hoplon       :refer [hoplon]]
 '[boot.heredoc             :refer [heredoc]]
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
   (heredoc)
   (hoplon)
   (reload)
   (cljs)
   (serve :port 8000)))

(deftask prod
  "Build hoplon-spectre for production deployment."
  []
  (comp
   (heredoc)
   (hoplon)
   (cljs :optimizations :advanced)
   (target :dir #{"target"})))
