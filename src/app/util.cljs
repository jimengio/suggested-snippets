
(ns app.util
  (:require ["copy-to-clipboard" :as copy]
            ["shortid" :as shortid]
            [respo-message.action :as message-action]))

(defn copy-text! [text d!]
  (copy text)
  (let [new-token (.generate shortid)]
    (d! message-action/create {:text "Copied!", :token new-token})
    (js/setTimeout #(d! message-action/remove-one {:token new-token}) 2000)))

(defn get-env! [property] (aget (.-env js/process) property))
