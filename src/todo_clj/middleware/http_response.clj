(ns todo-clj.middleware.http-response
  (:require
   [hiccup2.core :as hc]
   [ring.util.http-status :as status]
   [todo-clj.util.response :as res]))

(defn- error-view [{:keys [status]}]
  (let [{:keys [name description]} (status/status status)]
    (-> (str (hc/html `([:h1 ~name]
          [:h2 ~description])))
        res/ok
        res/html)))

(defn wrap-http-response [handler]
  (fn [req]
    (try
      (handler req)
      (catch clojure.lang.ExceptionInfo e#
        (let [error-data (ex-data e#)
              error-type (:type error-data)]
          (if (= :ring.util.http-response/response error-type)
            (error-view (:response error-data))
            (throw e#)))))))

