(ns todo-clj.handler.todo
  (:require
   [compojure.core :refer [context defroutes GET POST]]
   [todo-clj.util.response :as res]))

(def todo-list
  [{:title "朝ごはんを作る"}
   {:title "燃えるゴミを出す"}
   {:title "卵を返って帰る"}
   {:title "お風呂を洗う"}])

(defn todo-index-view [_]
  `("<h1>TODO 一覧</h1>"
    "<ul>"
    ~@(for [{:keys [title]} todo-list]
            (str "<li>" title "</li>"))
    "</ul>"))

(defn todo-index [req]
  (-> (todo-index-view req)
      res/response
      res/html))

(defn todo-new [_] "TODO new")
(defn todo-new-post [_] "TODO new post")
(defn todo-search [_] "TODO search")
(defn todo-show [_] "TODO show")
(defn todo-edit [_] "TODO edit")
(defn todo-edit-post [_] "TODO edit post")
(defn todo-delete [_] "TODO delete")
(defn todo-delete-post [_] "TODO delete post")

(defroutes todo-routes
  (context "/todo" _
           (GET "/" _ todo-index)
           (GET "/new" _ todo-new)
           (POST "/new" _ todo-new-post)
           (GET "/search" _ todo-search)
           (context "/:todo-id" _
                    (GET "/" _ todo-show)
                    (GET "/edit" _ todo-edit)
                    (POST "/edit" _ todo-edit-post)
                    (GET "/delete" _ todo-delete)
                    (POST "/delete" _ todo-delete-post))))

