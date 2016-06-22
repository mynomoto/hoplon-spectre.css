(ns hoplon.spectre-css
  (:require [hoplon.core :as h]
            [javelin.core :as j]))

(h/defelem header
  [attrs children]
  ((h/header {:class "text-center"})
   attrs
   children))

(h/defelem button-primary
  [attrs children]
  ((h/a {:shape "rect"
         :class "btn btn-primary"})
   attrs
   children))

(h/defelem button-group
  [attrs children]
  ((h/div {:class "btn-group"})
   attrs
   children))

(h/defelem button-group-block
  [attrs children]
  ((h/div {:class "btn-group btn-group-block"})
   attrs
   children))

(h/defelem highlight
  [attrs children]
  ((h/span {:class "highlight"})
   attrs
   children))

(h/defelem ul
  [attrs children]
  ((h/ul {:class "list"})
   attrs
   children))

(h/defelem ol
  [attrs children]
  ((h/ol {:class "list"})
   attrs
   children))

(h/defelem dl
  [attrs children]
  ((h/dl {:class "list"})
   attrs
   children))

(h/defelem table
  [{:keys [options] :as attrs} children]
  (let [table-options {:striped "table-striped"
                       :hover "table-hover"}
        class (if (j/cell? options)
                (j/cell=
                 (let [options-set (set options)]
                   {"table-striped" (:striped options-set)
                    "table-hover" (:hover options-set)
                    "table" true}))
                {"table-striped" (:striped options)
                 "table-hover" (:hover options)
                 "table" true})]
    ((h/table :class class)
     (dissoc attrs :options)
     children)))
