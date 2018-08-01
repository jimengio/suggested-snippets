
(ns app.snippets (:require [app.macros :refer [inline-resource]]))

(def files
  [{:name "Component base", :content (inline-resource "snippets/component-base.tsx")}])
