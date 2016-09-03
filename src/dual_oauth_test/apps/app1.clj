(ns dual-oauth-test.apps.app1
  (:use compojure.core ring.util.response)
  (:require [clj-oauth2.client :as oauth2]
            [clj-http.client :as http]
            [dual-oauth-test.services.fb :as fb]
            [dual-oauth-test.services.helpers :as h]))

(defn talk-to-app2 [request]
  (->> request
    (:params)
    (assoc {} :query-params)
    (http/get "http://localhost:4000/get-info")
    (h/println->)))

(defroutes app-routes
  (GET "/healthcheck" [] {:status 200 :body {:system "OK"}})
  (GET "/login" [] (redirect (:uri fb/redirect-url)))
  (GET "/callback" request (talk-to-app2 request)))
