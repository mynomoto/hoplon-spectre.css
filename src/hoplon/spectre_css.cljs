(ns hoplon.spectre-css
  (:require [hoplon.core :as h]))

(h/defelem header
  [attrs children]
  (h/header
   (merge-with merge attrs
               {:class "text-center"})
   children))
