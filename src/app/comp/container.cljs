
(ns app.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo-ui.core :as ui]
            [respo.macros :refer [defcomp cursor-> list-> <> div button textarea span pre]]
            [verbosely.core :refer [verbosely!]]
            [respo.comp.space :refer [=<]]
            [reel.comp.reel :refer [comp-reel]]
            [respo-md.comp.md :refer [comp-md]]
            [app.config :refer [dev?]]
            [app.snippets :refer [files]]))

(defcomp
 comp-snippet
 (snippet)
 (div
  {:style {:border (str "1px solid " (hsl 0 0 92)), :width 400, :overflow :auto}}
  (div {:style {:padding 8}} (<> (:name snippet)))
  (pre
   {:inner-text (:content snippet),
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
    (div {:style {:height 48, :border-bottom (str "1px solid " (hsl 0 0 92))}})
    (list->
     {:style ui/flex}
     (->> files (map (fn [snippet] [(:key snippet) (comp-snippet snippet)]))))
    (when dev? (cursor-> :reel comp-reel states reel {})))))
