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
     "btn-lg" (:large options-set)
     "btn-sm" (:small options-set)
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
     "input-lg" (:large options-set)
     "input-sm" (:small options-set)
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
     "addon-lg" (:large options-set)
     "addon-sm" (:small options-set)}))

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
     "select-lg" (:large options-set)
     "select-sm" (:small options-set)}))

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

(h/defelem columns
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (img-options options))
                (img-options options))]
    ((h/div (dissoc attrs :options))
     :class "columns"
     children)))
