(ns todo-clj.core
  (:require
   [compojure.core :refer [defroutes GET]]
   [compojure.route :as route]
   [ring.adapter.jetty :as server]
   [ring.util.response :as res]))

(defn html [res]
  (res/content-type res "text/html; charset=utf-8"))

(defn home-view [_]
  "<h1>ホーム画面</h1><a href=\"/todo\">TODO 一覧</a>")

(defn home [req]
  (-> (home-view req)
      res/response
      html))

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
      html))

(defroutes handler
  (GET "/" _ home)
  (GET "/todo" _ todo-index)
  (route/not-found "<h1> 404: Page not found </h1>"))

(defonce server (atom nil))

(defn start-server []
  (when-not @server
    (reset! server (server/run-jetty #'handler {:port 3000 :join? false}))))

(defn stop-server []
  (when @server
    (.stop @server)
    (reset! server nil)))

(defn restart-server []
  (when @server
    (stop-server)
    (start-server)))

