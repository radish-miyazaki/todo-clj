(defproject todo-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/java.jdbc "0.7.12"]
                 [org.postgresql/postgresql "42.7.1"]
                 [ring "1.11.0"]
                 [ring/ring-defaults "0.4.0"]
                 [ring/ring-anti-forgery "1.3.0"]
                 [metosin/ring-http-response "0.9.3"]
                 [compojure "1.7.0"]
                 [environ "1.2.0"]
                 [hiccup "2.0.0-RC2"]
                 [metosin/malli "0.13.0"]
                 [potemkin "0.4.7"]]
  :plugins [[lein-environ "1.2.0"]]
  :repl-options {:init-ns todo-clj.core}
  :profiles {:dev {:dependencies [[prone "2021-04-23"]]
                   :env {:dev true}}})

