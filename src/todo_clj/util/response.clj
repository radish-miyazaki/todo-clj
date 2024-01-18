(ns todo-clj.util.response
  (:require
   [potemkin :as p]
   [ring.util.http-response :as rres]))

(defmacro import-ns [ns-sym]
  `(p/import-vars
     [~ns-sym
      ~@(map first (ns-publics ns-sym))]))

(import-ns ring.util.http-response)

(defn html [res]
  (rres/content-type res "text/html; charset=utf-8"))

