(ns todo-clj.view.layout
  (:require
   [hiccup.page :refer [doctype include-css include-js]]
   [hiccup2.core :as hc]))

(defn common [_ & body]
  (hc/html
   {:mode :html}
   (doctype :html5)
   [:html
    [:head
     [:title "TODO-clj"]
     (include-css "/css/normalize.css"
                  "/css/papier-1.3.1.min.css"
                  "/css/style.css")
     (include-js "/js/main.js")]
   [:body
    [:header.top-bar.bg-green.depth-3 "TODO-clj"]
    [:main body]]]))

