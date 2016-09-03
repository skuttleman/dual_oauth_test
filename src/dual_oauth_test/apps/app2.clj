(ns dual-oauth-test.apps.app2
  (:use compojure.core ring.util.response)
  (:require [clj-oauth2.client :as oauth2]
            [dual-oauth-test.services.fb :as fb]
            [dual-oauth-test.services.helpers :as h]))

(defn get-token [code]
  (oauth2/get-access-token fb/oauth-config {:code code} fb/redirect-url))

(defn get-me [token]
  (oauth2/get "https://graph.facebook.com/me?fields=id,name,email" {:oauth2 token}))

(defn get-info [{params :params}]
  (->> params
    (:code)
    (get-token)
    (get-me)
    (h/println->)))

(defroutes app-routes
  (GET "/healthcheck" [] {:status 200 :body {:system "OK"}})
  (GET "/get-info" request (get-info request)))
