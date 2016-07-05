(ns hoplon.spectre-css
  (:require [hoplon.core :as h]
            [javelin.core :as j]))

(h/defelem header
  [attrs children]
  ((h/header {:class "text-center"})
   attrs
   children))

(defn button-options
  [options]
  (let [options-set (set options)]
    {"loading" (:loading options-set)
     "btn-lg" (:lg options-set)
     "btn-sm" (:sm options-set)
     "btn-block" (:block options-set)
     "input-group-btn" (:input-group options-set)
     "btn" true}))

(h/defelem button
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (button-options options))
                (button-options options))]
    ((h/a {:class class})
     (dissoc attrs :options)
     children)))

(h/defelem button-primary
  [attrs children]
  ((button attrs)
   {:class "btn-primary"}
   children))

(h/defelem button-link
  [attrs children]
  ((button attrs)
   {:class "btn-link"}
   children))

(h/defelem button*
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (button-options options))
                (button-options options))]
    ((h/button {:class class})
     (dissoc attrs :options)
     children)))

(h/defelem button-clear
  [attrs children]
  ((button* attrs)
   {:class "btn-clear"}
   children))

(defn button-group-options
  [options]
  (let [options-set (set options)]
    {"btn-group" true
     "btn-group-block" (:block options-set)}))

(h/defelem button-group
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (button-group-options options))
                (button-group-options options))]
    ((h/div {:class class})
     (dissoc attrs options)
     children)))

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

(defn table-options
  [options]
  (let [options-set (set options)]
    {"table-striped" (:striped options-set)
     "table-hover" (:hover options-set)
     "table" true}))

(h/defelem table
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (table-options options))
                (table-options options))]
    ((h/table :class class)
     (dissoc attrs :options)
     children)))

(defn input-options
  [options]
  (let [options-set (set options)]
    {"form-input" true
     "input-lg" (:lg options-set)
     "input-sm" (:sm options-set)
     "input-inline" (:inline options-set)
     "is-danger" (:error options-set)
     "is-success" (:success options-set)}))

(h/defelem input
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (input-options options))
                (input-options options))]
    ((h/input :class class)
     (dissoc attrs :options)
     children)))

(h/defelem textarea
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (input-options options))
                (input-options options))]
    ((h/input :class class)
     (dissoc attrs :options)
     children)))

(h/defelem input-group
  [{:keys [options] :as attrs} children]
  ((h/div attrs)
   :class "input-group"
   children))

(defn input-group-text-options
  [options]
  (let [options-set (set options)]
    {"input-group-addon" true
     "addon-lg" (:lg options-set)
     "addon-sm" (:sm options-set)}))

(h/defelem input-group-text
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (input-group-text-options options))
                (input-group-text-options options))]
    ((h/span :class class)
     (dissoc attrs :options)
     children)))

(defn form-group-options
  [options]
  (let [options-set (set options)]
    {"form-group" true
     "has-danger" (:error options-set)
     "has-success" (:success options-set)}))

(h/defelem form-group
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (form-group-options options))
                (form-group-options options))]
    ((h/div :class class)
     (dissoc attrs :options)
     children)))

(h/defelem form-label
  [{:keys [options] :as attrs} children]
  ((h/label :class "form-label")
   (dissoc attrs :options)
   children))

(defn select-options
  [options]
  (let [options-set (set options)]
    {"form-select" true
     "select-lg" (:lg options-set)
     "select-sm" (:sm options-set)}))

(h/defelem select
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (select-options options))
                (select-options options))]
    ((h/select :class class)
     (dissoc attrs :options)
     children)))

(h/defelem input-radio
  [{:keys [options] :as attrs} label-content]
  (h/label
   :class "form-radio"
   ((h/input
     :type "radio")
    (dissoc attrs :options))
   (h/i :class "form-icon")
   label-content))

(h/defelem input-switch
  [{:keys [options] :as attrs} label-content]
  (h/label
   :class "form-switch"
   ((h/input :type "checkbox")
    (dissoc attrs :options))
   (h/i :class "form-icon")
   label-content))

(h/defelem input-checkbox
  [{:keys [options] :as attrs} label-content]
  (h/label
   :class "form-checkbox"
   ((h/input :type "checkbox")
    (dissoc attrs :options))
   (h/i :class "form-icon")
   label-content))

(defn img-options
  [options]
  (let [options-set (set options)]
    {"img-responsive" true
     "rounded" (:rounded options-set)}))

(h/defelem img
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (img-options options))
                (img-options options))]
    ((h/img :class class)
     (dissoc attrs :options)
     children)))

(defn columns-class
  [options]
  (let [options-set (set options)]
    {"columns" true
     "col-gapless" (:gapless options-set)}))

(h/defelem columns
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (columns-class options))
                (columns-class options))]
    ((h/div :class class)
     (dissoc attrs :options)
     children)))

(defn column-class
  ([val]
   (column-class val nil))
  ([val size]
   (if (integer? val)
     {"column" true
      (str "col-" (when size (str size "-")) val) true}
     {"column" true})))

(defmethod h/do! :column
  [elem key val]
  (h/do! elem :class (column-class val)))

(defmethod h/do! :column-xs
  [elem key val]
  (h/do! elem :class (column-class val "xs")))

(defmethod h/do! :column-sm
  [elem key val]
  (h/do! elem :class (column-class val "sm")))

(defmethod h/do! :column-md
  [elem key val]
  (h/do! elem :class (column-class val "md")))

(defn hide-class
  [val]
  (let [options-set (set val)]
    {"hide-xs" (:xs options-set)
     "hide-sm" (:sm options-set)
     "hide-md" (:md options-set)
     "hide-lg" (:lg options-set)
     "hide-xl" (:xl options-set)}))

(defmethod h/do! :hide
  [elem key val]
  (h/do! elem :class (hide-class val)))

(h/defelem navbar-section
  [attrs children]
  ((h/section {:class "navbar-section"})
   attrs
   children))

(h/defelem navbar
  [attrs children]
  ((h/header {:class "navbar"})
   attrs
   children))

(h/defelem navbar-title-link
  [attrs children]
  ((h/a {:class "navbar-brand"})
   attrs
   children))

(defn avatar-class
  [options]
  (let [options-set (set options)]
    {"avatar-xs" (:xs options-set)
     "avatar-sm" (:sm options-set)
     "avatar-lg" (:lg options-set)
     "avatar-xl" (:xl options-set)
     "avatar" true}))

(h/defelem avatar
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (avatar-class options))
                (avatar-class options))]
    ((h/figure {:class class})
     (dissoc attrs :options)
     children)))

(h/defelem avatar-img
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (avatar-class options))
                (avatar-class options))]
    ((h/img {:class class})
     (dissoc attrs :options)
     children)))

(h/defelem avatar-icon
  [{:keys [options] :as attrs} children]
  ((h/img {:class "avatar-icon"})
   (dissoc attrs :options)
   children))

(defn chip-class
  [options]
  (let [options-set (set options)]
    {"selected" (:selected options-set)
     "chip-sm" true}))

(h/defelem chip
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (chip-class options))
                (chip-class options))]
    ((h/div {:class class})
     (dissoc attrs :options)
     children)))

(h/defelem chip-text
  [{:keys [options] :as attrs} children]
  ((h/span {:class "chip-name"})
   (dissoc attrs :options)
   children))

(defn icon
  [icon-class]
  ((h/span :class "icon")
   :class icon-class))

(h/defelem autocomplete
  [{:keys [options] :as attrs} children]
  ((h/div {:class "form-autocomplete"})
   (dissoc attrs :options)
   children))

(h/defelem autocomplete-input
  [{:keys [options] :as attrs} children]
  ((h/div {:class "form-autocomplete-input"})
   (dissoc attrs :options)
   children))

(defn avatar-chip-input
  ([title avatar-image]
   (avatar-chip-input title avatar-image nil))
  ([title avatar-image options]
   (chip
    (cond-> {}
      options (assoc :options options))
    (avatar-img :src avatar-image)
    (chip-text title)
    (button-clear))))

(defn chip-input
  ([title]
   (chip-input title nil))
  ([title options]
   (chip
    (cond-> {}
      options (assoc :options options))
    (chip-text title)
    (button-clear))))

(h/defelem autocomplete-list
  [{:keys [options] :as attrs} children]
  ((h/ul {:class "form-autocomplete-list"})
   (dissoc attrs :options)
   children))

(h/defelem autocomplete-item
  [{:keys [options] :as attrs} children]
  ((h/li {:class "form-autocomplete-item"})
   (dissoc attrs :options)
   children))

(defn autocomplete-item-avatar-chip
  [title avatar-image]
  (autocomplete-item
   (h/div
    :class "chip hand"
    (h/div
     :class "chip-icon"
     (avatar-img :src avatar-image))
    (h/div :class "chip-content" title))))

(defn tooltip-class
  [position]
  {"tooltip-right" (= position :right)
   "tooltip-left" (= position :left)
   "tooltip-bottom" (= position :bottom)
   "tooltip" true})

(defn add-tooltip
  ([elem text]
   (add-tooltip elem text nil))
  ([elem text position]
   (elem
    :data-tooltip text
    :class (tooltip-class position))))

(h/defelem label
  [{:keys [options] :as attrs} children]
  ((h/span {:class "label"})
   (dissoc attrs :options)
   children))

(h/defelem label-primary
  [{:keys [options] :as attrs} children]
  ((label {:class "label-primary"})
   (dissoc attrs :options)
   children))
