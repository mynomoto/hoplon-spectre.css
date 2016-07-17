(set-env!
  :dependencies '[[org.clojure/clojure "1.9.0-alpha8" :scope "provided"]

                  [org.clojure/clojurescript "1.9.93" :scope "provided"]
                  [adzerk/boot-cljs "1.7.228-1" :scope "provided"]

                  [hoplon/hoplon "6.0.0-alpha16" :scope "provided"]

                  [hoplon/boot-hoplon "0.1.13" :scope "test"]
                  [adzerk/boot-reload "0.4.11" :scope "test"]
                  [tailrecursion/boot-jetty "0.1.3" :scope "test"]
                  [tailrecursion/boot-heredoc "0.1.1" :scope "test"]
                  [adzerk/bootlaces "0.1.13" :scope "test"]]
  :resource-paths #{"src"})

(require
  '[adzerk.boot-cljs :refer [cljs]]
  '[adzerk.boot-reload :refer [reload]]
  '[adzerk.bootlaces :refer [bootlaces! push-release push-snapshot build-jar]]
  '[boot.git :refer [last-commit]]
  '[boot.heredoc :refer [heredoc]]
  '[hoplon.boot-hoplon :refer [hoplon prerender]]
  '[tailrecursion.boot-jetty :refer [serve]])

(def +version+ "0.1.0")
(bootlaces! +version+)

(task-options!
  push {:repo           "deploy"
        :ensure-branch  "master"
        :ensure-clean   true
        :ensure-tag     (last-commit)
        :ensure-version +version+}
  pom  {:project        'mynomoto/hoplon-spectre.css
        :version        +version+
        :description    "Hoplon bindings for spectre.css"
        :url            "https://github.com/mynomoto/hoplon-spectre.css"
        :scm            {:url "https://github.com/mynomoto/hoplon-spectre.css"}
        :license        {"Eclipse Public License" "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask demo
  []
  (with-pre-wrap fileset
    (merge-env!
      :resource-paths #{"demo"}
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
    (reload :on-jsload 'hoplon.dev/reload)
    (cljs)
    (serve :port 8000)))

(deftask page
  "Build the hoplon-spectre pages."
  []
  (comp
    (demo)
    (heredoc)
    (hoplon)
    (cljs :optimizations :advanced)
    (prerender)
    (target :dir #{"target"})))

(deftask release
  "Release hoplon-spectre."
  []
  (comp
    (build-jar)
    (push-release)))
