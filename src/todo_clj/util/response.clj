(ns todo-clj.util.response
  (:require
   [ring.util.response :as res]))

(defn html [res]
  (res/content-type res "text/html; charset=utf-8"))

(def response #'res/response)
(alter-meta! #'response #(merge % (meta #'res/response)))

(def redirect #'res/redirect)
(alter-meta! #'response #(merge % (meta #'res/redirect)))

