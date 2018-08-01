
(ns app.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo-ui.core :as ui]
            [respo.macros
             :refer
             [defcomp cursor-> list-> <> div button textarea input span pre]]
            [verbosely.core :refer [verbosely!]]
            [respo.comp.space :refer [=<]]
            [reel.comp.reel :refer [comp-reel]]
            [respo-md.comp.md :refer [comp-md]]
            [app.config :refer [dev?]]
            [app.snippets :refer [files]]
            ["escape-html" :as escape-html]
            ["highlight.js/lib/index" :as hljs]
            [clojure.string :as string]))

(def supported-langs
  {"clojure" "clojure",
   "bash" "bash",
   "clj" "clojure",
   "javascript" "javascript",
   "js" "javascript",
   "typescript" "typescript",
   "ts" "typescript"})

(defcomp
 comp-snippet
 (snippet)
 (div
  {:style {:border (str "1px solid " (hsl 0 0 92)),
           :width 400,
           :overflow :auto,
           :display :inline-block,
           :margin 8}}
  (div
   {:style {:padding 8, :border-bottom (str "1px solid " (hsl 0 0 90))}}
   (<> (:name snippet)))
  (pre
   {:innerHTML (let [code (:content snippet), lang (:lang snippet)]
      (if (contains? supported-langs lang)
        (.-value (.highlight hljs (get supported-langs lang) code))
        (escape-html code))),
    :style {:font-family ui/font-code,
            :font-size 12,
            :line-height "18px",
            :margin 0,
            :padding 8,
            :padding-bottom 40}})))

(defcomp
 comp-container
 (reel)
 (let [store (:store reel), states (:states store)]
   (div
    {:style (merge ui/global ui/fullscreen ui/column)}
    (div
     {:style (merge ui/center {:height 48, :border-bottom (str "1px solid " (hsl 0 0 92))})}
     (input
      {:style ui/input,
       :placeholder "Query",
       :value (:content store),
       :on-input (fn [e d! m!] (d! :content (:value e)))}))
    (list->
     {:style (merge ui/flex {:padding 16, :overflow :auto, :padding-bottom 120})}
     (->> files
          (filter
           (fn [snippet]
             (string/includes? (string/lower-case (:name snippet)) (:content store))))
          (map (fn [snippet] [(:key snippet) (comp-snippet snippet)]))))
    (when dev? (cursor-> :reel comp-reel states reel {})))))
