(ns todo-clj.util.validation
  (:require
   [malli.core :as m]
   [malli.error :as me]))

(defn validate [schema value]
  (let [errors (me/humanize (m/explain schema value))]
    (if (nil? errors)
      value
      (throw (ex-info "Validation error" (assoc errors :type :validation-error))))))

(defmacro with-fallback [fallback & body]
  `(try
     ~@body
     (catch clojure.lang.ExceptionInfo e#
        (if (= :validation-error (:type (ex-data e#)))
         (~fallback (ex-data e#))
         (throw e#)))))

