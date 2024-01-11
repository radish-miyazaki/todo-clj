(ns todo-clj.handler.main
  (:require
   [compojure.core :refer [defroutes GET]]
   [compojure.route :as route]
   [todo-clj.util.response :as res]
   [todo-clj.view.home :as view]))

(defn home [req]
  (-> (view/home-view req)
      res/response
      res/html))

(defroutes main-routes
  (GET "/" _ home)
  (route/not-found "<h1> Page not found </h1>"))

