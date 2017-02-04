(set-env!
  :dependencies '[[org.clojure/clojure "1.9.0-alpha14" :scope "provided"]

                  [org.clojure/clojurescript "1.9.456" :scope "provided"]
                  [adzerk/boot-cljs "1.7.228-2" :scope "provided"]

                  [hoplon/hoplon "6.0.0-alpha17" :scope "provided"]

                  [adzerk/boot-reload "0.5.0" :scope "test"]
                  [tailrecursion/boot-jetty "0.1.3" :scope "test"]
                  [tailrecursion/boot-heredoc "0.1.1" :scope "test"]]
  :resource-paths #{"src"})

(require
  '[adzerk.boot-cljs :refer [cljs]]
  '[adzerk.boot-reload :refer [reload]]
  '[boot.git :refer [last-commit]]
  '[boot.heredoc :refer [heredoc]]
  '[hoplon.boot-hoplon :refer [hoplon prerender]]
  '[tailrecursion.boot-jetty :refer [serve]])

(def +version+ "0.1.32-0")

(task-options!
  push {:repo "deploy-clojars"}
  pom  {:project        'mynomoto/hoplon-spectre.css
        :version        +version+
        :description    "Hoplon bindings for spectre.css"
        :url            "https://github.com/mynomoto/hoplon-spectre.css"
        :scm            {:url "https://github.com/mynomoto/hoplon-spectre.css"}
        :license        {"Eclipse Public License" "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask local-install
  "Build and install the project locally."
  []
  (comp (pom) (jar) (install)))

(defn demo
  []
  (merge-env!
    :resource-paths #{"demo"}
    :dependencies '[[hoplon/highlight "8.4.0-0"]]))

(deftask dev
  "Build hoplon-spectre for local development."
  []
  (demo)
  (comp
    (watch)
    (speak)
    (heredoc)
    (hoplon)
    (reload :on-jsload 'hoplon.dev/reload)
    (cljs)
    (serve :port 8000)))

(deftask page
  "Build the hoplon-spectre pages."
  []
  (demo)
  (comp
    (heredoc)
    (hoplon)
    (cljs :optimizations :advanced)
    (prerender)
    (sift :include #{#"\.out" #"\.cljs"} :invert true)
    (target :dir #{"target"})))

(deftask release []
  (merge-env!
    :repositories [["deploy-clojars" {:url "https://clojars.org/repo"
                                      :username (System/getenv "CLOJARS_USER")
                                      :password (System/getenv "CLOJARS_PASS")}]])
  (comp
    (local-install)
    (sift :include [#".*\.jar"])
    (push)))
