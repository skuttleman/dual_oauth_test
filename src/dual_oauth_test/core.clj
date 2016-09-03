(ns dual-oauth-test.core
  (:use org.httpkit.server)
  (:require [compojure.handler :refer [site]]
            [dual-oauth-test.apps.app1 :as app1]
            [dual-oauth-test.apps.app2 :as app2]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.middleware.cors :refer [wrap-cors]]))

(defn app [app-routes]
  (-> app-routes
    (wrap-json-response)
    (wrap-cors #".*")))

(defn run [name port app]
  (run-server (site app) {:port port})
  (println (str name " is listening on port: " port)))

(defn -main [& _]
  (->> app1/app-routes
    (app)
    (run "App1" 3000))
  (->> app2/app-routes
    (app)
    (run "App2" 4000)))
