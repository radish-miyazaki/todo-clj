(ns todo-clj.view.main
  (:require
   [hiccup2.core :as hc]))

(defn home-view [_]
  (-> (list [:h1 "ホーム画面"]
            `[:a {:href "/todo"} "TODO 一覧"])
      hc/html
      str))

