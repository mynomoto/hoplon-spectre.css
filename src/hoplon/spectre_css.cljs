(ns hoplon.spectre-css
  (:require [hoplon.core :as h]))

(h/defelem header
  [attrs children]
  (h/header
   (merge-with merge attrs
               {:class "text-center"})
   children))

(h/defelem button-primary
  [attrs children]
  (h/a
   (merge-with #(str %1 " " %2)
               attrs
               {:shape "rect"
                :class "btn btn-primary"})
   children))

(h/defelem button-group
  [attrs children]
  (h/div
   (merge-with #(str %1 " " %2)
               attrs
               {:class "btn-group"})
   children))

(h/defelem button-group-block
  [attrs children]
  (h/div
   (merge-with #(str %1 " " %2)
               attrs
               {:class "btn-group btn-group-block"})
   children))

(h/defelem highlight
  [attrs children]
  (h/span
   (merge-with #(str %1 " " %2)
               attrs
               {:class "highlight"})
   children))

(h/defelem ul
  [attrs children]
  (h/ul
   (merge-with #(str %1 " " %2)
               attrs
               {:class "list"})
   children))

(h/defelem ol
  [attrs children]
  (h/ol
   (merge-with #(str %1 " " %2)
               attrs
               {:class "list"})
   children))

(h/defelem dl
  [attrs children]
  (h/dl
   (merge-with #(str %1 " " %2)
               attrs
               {:class "list"})
   children))
