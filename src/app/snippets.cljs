
(ns app.snippets (:require [app.macros :refer [inline-resource]]))

(def files
  [{:key :component-base,
    :name "Component base",
    :content (inline-resource "snippets/component-base.tsx"),
    :lang "js"}])
