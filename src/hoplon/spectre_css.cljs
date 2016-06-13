(ns hoplon.spectre-css
  (:require [clojure.string :as str]
            [hoplon.core :as h]))

(h/defelem header
  [attrs children]
  (h/header
   (merge-with merge attrs
               {:class "text-center"})
   children))

(h/defelem button-primary
  [attrs children]
  (h/a
   (merge-with #(str/join " " %1 %2)
               attrs
               {:shape "rect",
                :class "btn btn-primary"})
   children))
