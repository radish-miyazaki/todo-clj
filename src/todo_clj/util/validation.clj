(ns todo-clj.util.validation
  (:require
   [malli.core :as m]
   [malli.error :as me]))

(defn validate [schema value]
  (let [errors (me/humanize (m/explain schema value))]
    (if (nil? errors)
      value
      (throw (ex-info "Validation error" errors)))))

(defmacro with-fallback [fallback & body]
  `(try
     ~@body
     (catch clojure.lang.ExceptionInfo e#
         (~fallback (ex-data e#)))))

