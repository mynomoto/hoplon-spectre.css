(ns hoplon.dev)

(defn reload []
  (.log js/console "reload!!!")
  (.reload (.-location js/window)))
