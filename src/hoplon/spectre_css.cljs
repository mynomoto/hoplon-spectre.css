(ns hoplon.spectre-css
  (:require
    [hoplon.core :as h]
    [javelin.core :as j]))

(h/defelem header
  [attrs children]
  ((h/header {:class "text-center"})
   attrs
   children))

(defn button-class
  [options]
  {"loading" (:loading options)
   "btn-lg" (:lg options)
   "btn-sm" (:sm options)
   "btn-block" (:block options)
   "disabled" (:disabled options)
   "active" (:active options)
   "input-group-btn" (:input-group options)
   "btn" true})

(h/defelem a-button
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (button-class options))
                (button-class options))]
    ((h/a {:class class})
     (dissoc attrs :options)
     children)))

(h/defelem a-button-primary
  [attrs children]
  ((a-button attrs)
   {:class "btn-primary"}
   children))

(h/defelem a-button-link
  [attrs children]
  ((a-button attrs)
   {:class "btn-link"}
   children))

(h/defelem button
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (button-class options))
                (button-class options))]
    ((h/button {:class class})
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

(h/defelem button-clear
  [attrs children]
  ((button attrs)
   {:class "btn-clear"
    :aria-label "Close"}
   children))

(defn button-group-class
  [options]
  {"btn-group" true
   "btn-group-block" (:block options)})

(h/defelem button-group
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (button-group-class options))
                (button-group-class options))]
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

(defn table-class
  [options]
  {"table-striped" (:striped options)
   "table-hover" (:hover options)
   "table" true})

(h/defelem table
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (table-class options))
                (table-class options))]
    ((h/table :class class)
     (dissoc attrs :options)
     children)))

(h/defelem input-hint
  [attrs children]
  ((h/p :class "form-input-hint")
   attrs
   children))

(defn input-class
  [options]
  {"form-input" true
   "input-lg" (:lg options)
   "input-sm" (:sm options)
   "input-inline" (:inline options)
   "is-danger" (:error options)
   "is-success" (:success options)})

(h/defelem input
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (input-class options))
                (input-class options))]
    ((h/input :class class)
     (dissoc attrs :options)
     children)))

(h/defelem textarea
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (input-class options))
                (input-class options))]
    ((h/input :class class)
     (dissoc attrs :options)
     children)))

(h/defelem input-group
  [{:keys [options] :as attrs} children]
  ((h/div attrs)
   :class "input-group"
   children))

(defn input-group-text-class
  [options]
  {"input-group-addon" true
   "addon-lg" (:lg options)
   "addon-sm" (:sm options)})

(h/defelem input-group-text
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (input-group-text-class options))
                (input-group-text-class options))]
    ((h/span :class class)
     (dissoc attrs :options)
     children)))

(defn form-group-class
  [options]
  {"form-group" true
   "has-danger" (:error options)
   "has-success" (:success options)})

(h/defelem form-group
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (form-group-class options))
                (form-group-class options))]
    ((h/div :class class)
     (dissoc attrs :options)
     children)))

(h/defelem form-label
  [{:keys [options] :as attrs} children]
  ((h/label :class "form-label")
   (dissoc attrs :options)
   children))

(defn select-class
  [options]
  {"form-select" true
   "select-lg" (:lg options)
   "select-sm" (:sm options)
   "is-danger" (:error options)
   "is-success" (:success options)})

(h/defelem select
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (select-class options))
                (select-class options))]
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

(h/defelem figure
  [attrs children]
  ((h/figure :class "figure")
     attrs
     children))

(defn figcaption-class
  [options]
  {"figure-caption" true
   "text-center" (:center options)
   "text-right" (:right options)
   "text-left" (:left options)})

(h/defelem figcaption
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (figcaption-class options))
                (figcaption-class options))]
    ((h/figcaption :class class)
     (dissoc attrs :options)
     children)))

(defn img-class
  [options]
  {"img-responsive" true
   "rounded" (:rounded options)})

(h/defelem img
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (img-class options))
                (img-class options))]
    ((h/img :class class)
     (dissoc attrs :options)
     children)))

(defn columns-class
  [options]
  {"columns" true
   "col-oneline" (:oneline options)
   "col-gapless" (:gapless options)})

(h/defelem columns
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (columns-class options))
                (columns-class options))]
    ((h/div :class class)
     (dissoc attrs :options)
     children)))

(defn col-class
  ([val]
   (when (integer? val)
     {(str "col-"  val) true})))

(defmethod h/do! :col
  [elem key val]
  (h/do! elem :class (col-class val)))

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

(defmethod h/do! :badge
  [elem key val]
  (h/do! (elem :class "badge") :data-badge val))

(defn hide-class
  [val]
  (let [val (set val)]
    {"hide-xs" (:xs val)
     "hide-sm" (:sm val)
     "hide-md" (:md val)
     "hide-lg" (:lg val)
     "hide-xl" (:xl val)}))

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
  {"avatar-xs" (:xs options)
   "avatar-sm" (:sm options)
   "avatar-lg" (:lg options)
   "avatar-xl" (:xl options)
   "avatar" true})

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
  {"selected" (:selected options)
   "chip-sm" true})

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
  ((h/ul {:class "menu"})
   (dissoc attrs :options)
   children))

(h/defelem autocomplete-item
  [{:keys [options] :as attrs} children]
  ((h/li {:class "menu-item"})
   (dissoc attrs :options)
   children))

(defn chip-icon
  [avatar-image]
  (h/div
    :class "chip-icon"
    (avatar-img :src avatar-image)))

(defn chip-placeholder
  [color initials]
  (h/div
    :class "chip-icon"
    (avatar :data-initial initials :css {:background-color color})))

(defn chip-content
  [title]
  (h/div :class "chip-content" title))

(defn chip-big-avatar
  [title avatar-image]
  (h/div
    :class "chip"
    (chip-icon avatar-image)
    (chip-content title)))

(defn autocomplete-item-avatar-chip
  [title avatar-image]
  (autocomplete-item
    (h/a :href "#"
      (chip-big-avatar title avatar-image))))

(defn chip-big-avatar-placeholder
  [title color initials]
  (h/div
    :class "chip"
    (chip-placeholder color initials)
    (chip-content title)))

(defn autocomplete-item-avatar-placeholder-chip
  [title color initials]
  (autocomplete-item
    (h/a :href "#"
      (chip-big-avatar-placeholder title color initials))))

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
  [attrs children]
  ((h/span {:class "label"})
   attrs
   children))

(h/defelem label-primary
  [attrs children]
  ((label {:class "label-primary"})
   attrs
   children))

(h/defelem label-success
  [attrs children]
  ((label {:class "label-success"})
   attrs
   children))

(h/defelem label-danger
  [attrs children]
  ((label {:class "label-danger"})
   attrs
   children))

(h/defelem toast
  [attrs children]
  ((h/div {:class "toast"})
   attrs
   children))

(h/defelem toast-primary
  [attrs children]
  ((toast {:class "toast-primary"})
   attrs
   children))

(h/defelem toast-success
  [attrs children]
  ((toast {:class "toast-success"})
   attrs
   children))

(h/defelem toast-error
  [attrs children]
  ((toast {:class "toast-danger"})
   attrs
   children))

(h/defelem menu
  [attrs children]
  ((h/ul {:class "menu"})
   attrs
   children))

(h/defelem menu-item
  [attrs children]
  ((h/li {:class "menu-item"})
   attrs
   children))

(defn menu-link-class
  [options]
  {"active" (:active options)})

(h/defelem menu-link
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (menu-link-class options))
                (menu-link-class options))]
    (menu-item
      ((h/a :class class)
       (dissoc attrs :options)
       children))))

(defn menu-header
  [content]
  (h/li
    :class "menu-header"
    (h/span
      :class "menu-header-text"
      content)))

(h/defelem dropdown
  [attrs children]
  ((h/div {:class "dropdown"})
   attrs
   children))

(h/defelem dropdown-simple-button
  [attrs children]
  ((h/button
     {:class "btn btn-link dropdown-toggle" :tabindex "0"})
   attrs
   children))

(h/defelem dropdown-group-button
  [text]
  (h/div :class "btn-group"
    (h/button :class "btn"
      text)
    (h/button :class "btn dropdown-toggle" :tabindex "0"
      (h/i :class "icon-caret"))))

(h/defelem breadcrumb
  [attrs children]
  ((h/ul {:class "breadcrumb"})
   attrs
   children))

(h/defelem breadcrumb-item
  [attrs children]
  (h/li
    :class "breadcrumb-item"
    (h/a
      attrs
      children)))

(defn tab-class
  [options]
  {"tab-block" (:block options)
   "tab" true})

(h/defelem tab
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (tab-class options))
                (tab-class options))]
    ((h/ul {:class class})
     (dissoc attrs :options)
     children)))

(defn tab-item-class
  [options]
  {"active" (:active options)
   "tab-item" true})

(h/defelem tab-item
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (tab-item-class options))
                (tab-item-class options))]
    (h/li :class class
      (h/a
        (dissoc attrs :options)
        children))))

(h/defelem pagination
  [attrs children]
  ((h/ul {:class "pagination"})
   attrs
   children))

(defn page-item-class
  [options]
  {"active" (:active options)
   "page-item" true})

(h/defelem page-item
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (page-item-class options))
                (page-item-class options))
        content (if (:href attrs)
                  (h/a
                    (dissoc attrs :options)
                    children)
                  (h/span
                    (dissoc attrs :options)
                    children))]
    (h/li :class class
      content)))

(defn modal-class
  [options]
  {"active" (:active options)
   "modal-sm" (:sm options)
   "modal" true})

(h/defelem modal
  [{:keys [options] :as attrs} children]
  (let [class (if (j/cell? options)
                (j/cell= (modal-class options))
                (modal-class options))]
    (h/div :class class
      (h/div :class "modal-overlay")
      ((h/div
        :class "modal-container"
        :role "document")
        (dissoc attrs :options)
        children))))

(h/defelem modal-header
  [attrs children]
  ((h/div :class "modal-header")
   attrs
   children))

(h/defelem modal-title
  [attrs children]
  ((h/div :class "modal-title")
   attrs
   children))

(h/defelem modal-body
  [attrs children]
  ((h/div :class "modal-body")
   attrs
   children))

(h/defelem modal-footer
  [attrs children]
  ((h/div :class "modal-footer")
   attrs
   children))

(h/defelem card
  [attrs children]
  ((h/div :class "card")
   attrs
   children))

(h/defelem card-image
  [attrs children]
  (h/div :class "card-image"
    (img attrs children)))

(h/defelem card-header
  [attrs children]
  ((h/div :class "card-header")
   attrs
   children))

(h/defelem card-body
  [attrs children]
  ((h/div :class "card-body")
   attrs
   children))

(h/defelem card-footer
  [attrs children]
  ((h/div :class "card-footer")
   attrs
   children))

(defn divider []
 (h/div :class  "divider"))

(defn loading []
 (h/div :class  "loading"))
