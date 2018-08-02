
(ns app.snippets (:require [app.macros :refer [inline-resource]]))

(def files
  [{:key :component-base,
    :name "Component base",
    :content (inline-resource "snippets/component-base.tsx"),
    :lang "js"}
   {:key :immer-form-input,
    :name "ImmerForm input field",
    :content (inline-resource "snippets/immer-form-input.tsx"),
    :lang "js"}
   {:key :immer-state,
    :name "immerState function",
    :content (inline-resource "snippets/immer-state.tsx"),
    :lang "js"}
   {:key :immer-state-promise,
    :name "immerState with promise",
    :content (inline-resource "snippets/immer-state-promise.tsx"),
    :lang "js"}
   {:key :map-state-to-props,
    :name "mapStateToProps function",
    :content (inline-resource "snippets/map-state-to-props.tsx"),
    :lang "js"}])
